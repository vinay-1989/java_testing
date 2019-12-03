import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

import org.apache.http.client.methods.RequestBuilder;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class tagging_api_framework {
	
	
	
	
	
	
	public static void main(String[] args) throws IOException  {
		Response response = null;
		ClassLoader classLoader = new tagging_api_framework().getClass().getClassLoader();
		System.setOut(new PrintStream(new FileOutputStream("A:\\selenium_projects\\Api_automation\\src\\Files\\tag_output.txt")));
	//	File api_url=new File(classLoader.getResource("Files/api_path.txt").getFile());
		//File payload=new File(classLoader.getResource("Files/payload.txt").getFile());
		File input = new File(classLoader.getResource("File/vinayinput.txt").getFile());
		//String uri=new String( Files.readAllBytes(api_url.toPath()));
		//String text=new String( Files.readAllBytes(input.toPath()));
		//String s=new String(Files.readAllBytes(payload.toPath()));
		List<String> lines=Files.readAllLines(input.toPath());	
		for(String line:lines) {
		//	System.out.println(s.replace("myinput", line));
		System.out.println(line);
		//response=RestAssured.given().body(line).post(uri);
		String body=response.getBody().asString();
		//System.out.println(body);	
		JsonPath jsonPathEvaluator=  response.jsonPath();
		String output=jsonPathEvaluator.get("text");
		//String output1=jsonPathEvaluator.get("TrimSentence");
		//System.out.println(output);
		}}
}
