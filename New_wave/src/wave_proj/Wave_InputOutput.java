package wave_proj;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class Wave_InputOutput {
	public static void main(String[] key, String waveapi, String inputfilepath, String outputfilepath) throws IOException {
		String input,line,expected=null;
		String[] output=null;	
		int sn_number=0;
		try{				
		BufferedReader reader = new BufferedReader(new FileReader(inputfilepath));	
		reader.readLine(); 		
			 while((line=reader.readLine())!=null){
					int number=++sn_number;
					System.out.print(number +" ");
				output=line.split("\t");	
				for(int i=0;i<output.length;i++) {
					input=output[i];
					i=++i;
					expected=output[i];
					
					wavecall(input, expected, key, waveapi, outputfilepath, number);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void wavecall(String input, String expected, String[] key, String waveapi, String outputfilepath, int number) {
		Random rand = new Random();        
		int recid = rand.nextInt(1000);   	
		String payload="{"
				+ "\"key\":\""+key[0]+"\","
				+ "\"data\":[{\"field\":\"\","
				+ "\"text\":\""+input+"\","
				+ "\"qual\":1,"
				+ "\"op\":1,"
				+ "\"inln\":\"English\","
				+"\"Url\":\"\","
				+ "\"category\":\"\","
				+ "}"
				+ "],\"lang\":[\"hindi\"],"
				+ "\"categories\":\"\","
				+ "\"QAmode\":true,"
				+ "\"recid\":\""+recid+"\","
				+ "\"priority\": null}";

		
		String Res=sendPostRequest(payload, input, expected,waveapi,outputfilepath, number);
		
	}
	private static String sendPostRequest(String output_payload, String input, String expected, String waveapi, String outputfilepath, int number) {
		StringBuffer response = null;	
	
		try {
			URL url = new URL(waveapi);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; charset=ISO-8859-1");
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			writer.write(output_payload);
			writer.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			response = new StringBuffer();
			
			while ((inputLine = br.readLine()) != null) {
				
				response.append(inputLine);
				System.out.print(response +"\n");
				//System.out.println("");
				JSONParser parser = new JSONParser();
				Object object = parser.parse(inputLine);
				JSONObject jo = (JSONObject)object;
				JSONArray ja= (JSONArray) jo.get("data");		
				JSONObject  jo1=	  (JSONObject) ja.get(0);
				Object outtext=jo1.get("text");
				String	actualoutput=outtext.toString();
				Object outtext1=jo1.get("qual");
				String quality=outtext1.toString();
				
				writingdata(input, expected, actualoutput, quality, outputfilepath);// Now write data into text file
			}
			br.close();	
			return response.toString();
		}
		catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	public static void writingdata(String input, String expected, String actualoutput, String quality, String outputfilepath) throws IOException {
		//String filepath="C:\\Users\\vinay.rao\\Desktop\\waveoutput.txt";
		System.out.println(outputfilepath);
		
		BufferedWriter writer1 = new BufferedWriter(new FileWriter(outputfilepath, true));	
	
		for(int j=0;j<1;j++) {
			
			writer1.write(input);
			writer1.write("\t");
			writer1.write(expected);
			writer1.write("\t");
			writer1.write(actualoutput);
			writer1.write("\t");
			writer1.write(quality);
			if(expected.equalsIgnoreCase(actualoutput)) {
				writer1.write("\t");
				writer1.write("pass");
			}
			else {
				writer1.write("\t");
				writer1.write("Fail");
			}
			writer1.newLine();
		}	
		writer1.close();	
	}
}
