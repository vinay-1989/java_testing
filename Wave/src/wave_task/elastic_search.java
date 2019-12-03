package wave_task;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class elastic_search {

	public static void main(String[] args) throws IOException, ParseException {
		String Stext = null,Ttext = null;
		int recid=0;
  //File file=new File("C:\\Users\\vinay.rao\\Downloads\\PaytmData.txt");
		
		FileReader fr=new FileReader("C:\\Users\\vinay.rao\\Desktop\\Elasticdata.txt");
		
		BufferedReader br=new BufferedReader(fr);
		String[] list=new String[20];
		String st;
		while ((st = br.readLine()) != null) {

			JSONParser parser = new JSONParser();
			Object object = parser.parse(st);
			JSONObject jsonObject = (JSONObject)object;
			 Stext=(String)jsonObject.get("SourceText");
			 Ttext=(String)jsonObject.get("TargetText");
			System.out.println(Stext +Ttext);
			 Random random = new Random();         
			  recid = random.nextInt(1000);    		

		}		
			String payload="{\"SourceLanguage\":\"en\",\"TargetLanguage\":\"hi\",\"SourceText\":\""+Stext+"\",\"TargetText\":\""+Ttext+"\",\"RecID\":\""+recid+"\",\"TLTRFlag\":\"0\",\"TargetQuality\":\"1\",\"Classification\":\"A\",\"SubClassification\":\"B\",\"TLTRFlag\":\"0\",\"TargetQuality\":\"2\",\"clientname\":\"paytm\"}";
			String requestUrl="http://192.168.100.21/TranslationMemory/Home/UploadData";
			String Res=sendPostRequest(requestUrl, payload);
			System.out.println(Res) ;  
			
		

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
			jsonString = new StringBuffer();
			 String line;
				        while ((line = br.readLine()) != null) {
				                jsonString.append(line);
				        }
			  br.close();
			  connection.disconnect();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return jsonString.toString();
	}

}
