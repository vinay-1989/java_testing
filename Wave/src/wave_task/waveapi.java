package wave_task;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class waveapi {

	public static void main(String[] args) throws IOException, InterruptedException  {
		int sn_number = 0;
		String line1=null;
		
	
		try {	
			Charset charset = Charset.forName("UTF-8");
			Path _path = Paths.get("D:\\Wave_Automation\\Wave_input_output\\inputwavefile.txt");
			List<String> lines = Files.readAllLines(_path,charset);

			//String[] txtval =new String[lines.size()]; 
			for (String line : lines) {	
				int number=++sn_number;
				System.out.print(number +" ");
				//System.out.println(line);
				line1=line;
				//line1=line1.replace("\"", "\\\"");
                Thread.sleep(1000);
				Random rand = new Random();         //in case of paytm
				int recid = rand.nextInt(1000000);    //in case of paytm
				//in case of paytm  //"+recid+"
				String payload="{\"key\":\"BEA2-55EF-603A-40D7-A27F-B767-D0B9-8A72\","
						+ "\"data\":[{\"field\":\"\","
						+ "\"text\":\""+line1+"\","
						+ "\"qual\":1,"
						+ "\"op\":0,"
						+ "\"inln\":\"English\","
						+"\"Url\":\"\","
						+ "\"category\":\"\","
						+ "}"
						+ "],\"lang\":[\"hindi\",\"gujarati\"],"
						+ "\"categories\":\"\","						
						+ "\"QAmode\":true,"
						+ "\"recid\":\""+recid+"\","
						+ "\"priority\": null}";

				String requestUrl="http://192.168.100.21/Localization1.3/MoxApi.ashx";

				String Res=sendPostRequest(requestUrl, payload);
				//System.out.println(Res) ; 

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			//	System.out.println("CATCH");
		}
		//		Thread.sleep(20000);
		//		localized liz=new localized();
		//		liz.edittool(line1);
	}
	public static String sendPostRequest(String requestUrl, String payload) {
		StringBuffer response = null;

		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			writer.write(payload);
			writer.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;			
			response = new StringBuffer();			
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
				System.out.println(response);
				JSONParser parser = new JSONParser();
				Object object = parser.parse(inputLine);
				JSONObject jo = (JSONObject)object;
				JSONArray ja= (JSONArray) jo.get("data");		
				JSONObject  jo1=	  (JSONObject) ja.get(0);
				Object o1=jo1.get("text");
				//System.out.print(o1 +"\t");
				//System.out.print("\t");
				//System.out.print(jo1.get("qual"));
				//System.out.println("");
				//System.out.println("");						
			}
			br.close();	
			return response.toString();
		}
		catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		//return response.toString();	

	}
}
