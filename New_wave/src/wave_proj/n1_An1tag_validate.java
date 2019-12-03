package wave_proj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
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

public class n1_An1tag_validate {

	public static void main(String[] args) throws FileNotFoundException {
		//System.setOut(new PrintStream(new FileOutputStream("D:\\Wave_Automation\\1Mg_tagging_file\\outputfile.txt")));
		String input,line,expected=null; 
		String[] output=null;
		int sn_number = 0;
		try{				
			BufferedReader reader = new BufferedReader(new FileReader("D:\\Wave_Automation\\tagging data\\demo.txt"));	
			reader.readLine(); 		
			while((line=reader.readLine())!=null){
				int number=++sn_number;
				System.out.print(number +" ");
				output=line.split("\t");	
				for(int i=0;i<output.length;i++) {
					input=output[i];
					i=++i;
					expected=output[i];
					
					String requestUrl="http://192.168.100.21/Localization1.3/tagging.ashx?ln=hindi&key=BEA2-55EF-603A-40D7-A27F-B767-D0B9-8A72";
					String Res=sendPostRequest(input, expected, requestUrl);
				}
			}
			System.out.println("completed");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String sendPostRequest(String input, String expected, String requestUrl) {
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
			writer.write(input);
			writer.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			response = new StringBuffer();			
			while ((inputLine = br.readLine()) != null) {
				
				JSONParser parser = new JSONParser();
				Object object = parser.parse(inputLine);		
				JSONObject  jo1=(JSONObject) object;
				Object output=jo1.get("TagSentence");
				String tagged_data=output.toString();
				writingdata(input, expected, tagged_data);
			}
			br.close();	
			return response.toString();
		}
		catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private static void writingdata(String input, String expected, String tagged_data) throws IOException {
		String outputfilepath ="D:\\Wave_Automation\\tagging data\\outputdemo.txt";
		BufferedWriter writer1 = new BufferedWriter(new FileWriter(outputfilepath, true));	

		for(int j=0;j<1;j++) {
			writer1.write(input);

			writer1.write("\t");
			writer1.write(expected);
			writer1.write("\t");
			writer1.write(tagged_data);
			writer1.write("\t");
			if(expected.equalsIgnoreCase(tagged_data)) {
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
