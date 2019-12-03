package wave_task;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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

public class Gatewayapi {

	public static void main(String[] args) throws IOException {
		int sn_number=0;
		try {
			Charset charset = Charset.forName("utf-8");	
			Path _path = Paths.get("D:\\Wave_Automation\\Gateway\\GatewayinputFile.txt");
			List<String> lines = Files.readAllLines(_path,charset);
			for (String line : lines) {	
				int number=++sn_number;
				System.out.print(number +" ");
				Random rand = new Random();         //in case of paytm
				int key = rand.nextInt(1000);    //in case of paytm
				String payload="[{\"Key\":\""+key+"\","
						+ "\"TransFlag\":0,"
						+ "\"Classification\":\"translation\","
						+ "\"SubClassification\":\"translation\","
						+ "\"Domain\":\"\","
						+ "\"RequestQuality\":1,"
						+ "\"SourceLanguage\":\"English\","
						+ "\"Splitter\":\"\","
						+ "\"EngWord\":\""+line+"\","
						+ "\"Language\":\"\","
						+ "\"Url\":\"\","
						+ "\"WordCount\":0,"
						+ "\"OriginalText\":null}]";
				String requestUrl="http://192.168.100.21/Localization1.3/GatewayAPI1.2.ashx?MOXLang=Gujarati&Appkey=BEA2-55EF-603A-40D7-A27F-B767-D0B9-8A72";
				String Res=sendPostRequest(requestUrl, payload);
				//	System.out.println(Res) ; 						
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static String sendPostRequest(String requestUrl, String payload) {
		StringBuffer jsonString;
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
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
				JSONParser parser = new JSONParser();
				Object object = parser.parse(inputLine);
				JSONArray ja= (JSONArray)object;		
				JSONObject  jo1=	  (JSONObject) ja.get(0);
				Object o1=jo1.get("text");
				System.out.print(o1 +"\t");
				System.out.print("\t");
				System.out.print(jo1.get("qual"));
				System.out.println("");
			}
			br.close();	
			return response.toString();
		}
		catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}	
	}
}
