package wave_task;

import java.io.BufferedReader;
import java.io.File;
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

import net.bytebuddy.description.modifier.SynchronizationState;

public class sentence_break {

	public static void main(String[] args) {
		
		String line1=null;
	  String[] output;
		try {
			Charset charset = Charset.forName("UTF-8");
			Path _path = Paths.get("D:\\Wave_Automation\\Senetence_brake\\input_sentencebrkfile.txt");
			List<String> lines = Files.readAllLines(_path,charset);
			for (String line : lines) {	
				line1=line;		
				System.out.println(line1);
//				if(line1.contains(". ")) {
//				System.out.println("true");
//				output=	line1.split("\\. ");
//				System.out.println(output[0]);
//				System.out.println(output[1]);
//				System.out.println(output[2]);
//				}
//				else {
//					System.out.println("false");
//				}
		
				String payload=line1;
				//String key="BEA2-55EF-603A-40D7-A27F-B767-D0B9-8A72";
				String requestUrl="http://192.168.100.21/Localization1.3/SentenceBreak.ashx?key=BEA2-55EF-603A-40D7-A27F-B767-D0B9-8A72";
				String Res=sendPostRequest(requestUrl, payload);							
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}
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
				inputLine=response.toString();
				System.out.println(inputLine);
				JSONParser parser = new JSONParser();
				Object object = parser.parse(inputLine);
				JSONArray array = (JSONArray)object;
				//System.out.println(array.size());
//				  for(int i=0;i<array.size();i++) {
//					  JSONObject  jo1=(JSONObject)  array.get(i);
//					  System.out.print("en_prefix=");
//						System.out.print(jo1.get("en_prefix"));
//						System.out.print(" ");
//						 System.out.print("en_suffix=");
//						 System.out.print(jo1.get("en_suffix"));
//						System.out.println("");
//				  }
				
				
				 
				
				
				//JSONObject js = (JSONObject)object;
			//	JSONArray ja= (JSONArray) js.get("data");
			//org.json.JSONObject jso= json.getJSONObject(0);
				JSONObject obj2 = (JSONObject)array.get(1);
		//System.out.println(obj2.get("an_engword"));	
		
//			 JSONObject  jo1=(JSONObject) ja.get(0);
//			System.out.println(jo1.get("an_engword").toString());
//			
				
				
				
						
			}
			br.close();	
			//return response.toString();

		} catch (Exception e) {
			//throw new RuntimeException(e.getMessage());
		}
		return response.toString();
	}
}
