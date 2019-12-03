package wave_proj;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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

public class Tagging_1MGlive {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setOut(new PrintStream(new FileOutputStream("D:\\Wave_Automation\\LIVE\\1mg\\Live_Tagging\\Tag_output.txt")));
		
		String line1=null;
		int sn_number = 0;
		try {	
			
			Charset charset = Charset.forName("UTF-8");
			Path _path = Paths.get("D:\\Wave_Automation\\LIVE\\1mg\\Live_Tagging\\Tag_input.txt");
			
			List<String> lines = Files.readAllLines(_path,charset);
			
			for (String line : lines) {	
				int number=++sn_number;
				System.out.print(number+"\t");
				line1=line;  		
				String payload=line1;
				String requestUrl="http://13.126.129.45/p9trans/Tagging.ashx?ln=Hindi&key=C4C1-E4BA-7317-4798-A1A6-C4BF-9782-EF07";
				String Res=sendPostRequest(requestUrl, payload);		
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();	
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
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
			writer.write(payload);
			writer.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			response = new StringBuffer();			
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
				//System.out.println(response);
				JSONParser parser = new JSONParser();
				Object object = parser.parse(inputLine);		
				JSONObject  jo1=(JSONObject) object;
				Object o1=jo1.get("TagSentence");
				System.out.println(o1);
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
