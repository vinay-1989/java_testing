package wave_task;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

public class Reprocess_api {

	public static void main(String[] args) throws FileNotFoundException {
		//
		String line1=null;
		int sn_number = 0;
		try {	
			Charset charset = Charset.forName("UTF-8");
			Path _path = Paths.get("D:\\Wave_Automation\\QA_Reprocess\\input_reprocess.txt");
			List<String> lines = Files.readAllLines(_path,charset);
			//String[] txtval =new String[lines.size()];
			for (String line : lines) {	
				int number=++sn_number;
				//System.out.print(number+"\t");
				line1=line;
			//System.out.println(line+"\t");
				Random rand = new Random();        
				int recid = rand.nextInt(1000);    
			
				String payload="{\"key\":\"BEA2-55EF-603A-40D7-A27F-B767-D0B9-8A72\","
						+ "\"data\":[{\"field\":\"\","
						+ "\"text\":\""+line1+"\","
						+ "\"qual\":1,"
						+ "\"op\":0,"
						+ "\"inln\":\"English\","
						+"\"Url\":\"\","
						+ "\"category\":\"\","
						+ "}"
						+ "],\"lang\":[\"hindi\"],"
					//	+ "\"categories\":\"general\","
						
						+ "\"InputLanguage\":\"English\""
//						+ "\"recid\":\""+recid+"\","
		//				+ "\"priority\": null"
						+ "}";
//System.out.println(payload);
				String requestUrl="http://192.168.100.21/Localization1.3/ReprocessLog.ashx";
			
				String Res=sendPostRequest(requestUrl, payload);
				//System.out.println(Res) ; 
				
			}
		} catch (Exception e) {
         System.out.println(e.getMessage());
			e.printStackTrace();
		//	System.out.println("CATCH");
		}
		
	}

	private static String sendPostRequest(String requestUrl, String payload) {
		StringBuffer response = null;
		
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json; charset=ISO-8859-1");
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
				JSONArray array = (JSONArray)object;
				JSONObject  jo1=(JSONObject)  array.get(0);
				//JSONObject jo = (JSONObject)object;
				  // JSONArray ja= (JSONArray) jo.get("data");			
				  // JSONObject  jo1=	  (JSONObject) ja.get(0);
			//	System.out.print(jo1.get("OriginalText")+"\t");
//				System.out.print(jo1.get("LangWord")+"\t");
//				System.out.print(jo1.get("OutputText")+"\t");
				//System.out.print(jo1.get("EngWord")+"\t");	
					
//				System.out.print(jo1.get("OutQual"));
//				System.out.println();
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