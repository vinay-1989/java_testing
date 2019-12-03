package wave_task;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class updateindex {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader fr=new FileReader("D:\\Wave_Automation\\update_index_file\\updateindexfile.txt");
		try{
			BufferedReader buf = new BufferedReader(fr);
			ArrayList<String> words = new ArrayList<>();
			String lineJustFetched = null;
			String[] wordsArray;
			int a=0;
			int j=0;

			while(true){
				j=++j;
				System.out.print(j +" ");
				lineJustFetched = buf.readLine();         
				if(lineJustFetched == null){  
					break; 
				}else{
					wordsArray = lineJustFetched.split("\t");

					for(a=0;a<wordsArray.length;a++) {

						System.out.print(wordsArray[a]);
						System.out.print(" ");
					}
					//	System.out.println(wordsArray[0]);


					String payload="[{\"EngWord\":\""+wordsArray[0]+"\","
							+ "\"LangWord\":\""+wordsArray[1]+"\","
							+ "\"Phrase\":\"gunjan\","
							+ "\"Language\":\"Gujarati\","
							+ "\"Category\":\"gunjan\","
							+ "\"quality\":\""+wordsArray[3]+"\","
							+ "\"rk\":1,"                      //rk is translation and literation
							+ "\"rt\":0,"
							+ "\"Type\":3,"                    // 1 for insert , 3 for delete
							+ "\"Terminology\":"+wordsArray[4]+""
							+ "}]";
					String requestUrl="http://192.168.100.21/Localization1.3/UpdateIndex.ashx?ln=Gujarati";

					String Res=sendPostRequest(requestUrl, payload);
					System.out.println(Res) ; 
				}
			}	
			buf.close();
		}catch(Exception e){
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
			}
			br.close();
			System.out.println(response.toString());

			jsonString = new StringBuffer();


		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return jsonString.toString(); 
	}

}
