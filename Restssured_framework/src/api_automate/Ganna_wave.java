package api_automate;
import api_automate.callingone;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Ganna_wave extends Thread {

	String fname=null;
	String waveurl=null;

	public void filenames(String name) {
		fname=name; 
	}
	public void run() {
		Response response=null;

		try {
			//System.out.println(Thread.currentThread().getName());
			//System.setOut(new PrintStream(new FileOutputStream("A:\\selenium_projects\\Restssured_framework\\src\\stfolder\\output.txt")));

			ClassLoader classLoader = new Ganna_wave().getClass().getClassLoader();
			File input = new File(classLoader.getResource(fname).getFile());
			File api = new File(classLoader.getResource("stfolder/api.txt").getFile());
			String waveurl=new String(Files.readAllBytes(api.toPath()));
			List<String> lines = Files.readAllLines(input.toPath());
			for(String line:lines) {	
				System.out.println(Thread.currentThread().getName());
				Random rand = new Random();         
				int id = rand.nextInt(897654344);		
				String payload="{\"key\":\"7EAE-37E3-4448-48F2-BFE9-8F02-B5A1-ADC3\","
						+ "\"data\":[{\"field\":\"\","
						+ "\"text\":\""+line+"\","
						+ "\"qual\":2,"
						+ "\"op\":1,"
						+ "\"inln\":\"English\","
						+"\"Url\":\"\","
						+ "\"category\":\"\","
						+ "}"
						+ "],\"lang\":[\"hindi\"],"
						+ "\"categories\":\"\","						
						+ "\"QAmode\":true,"
						+ "\"recid\":\""+id+"\","
						+ "\"priority\": null}";	
				response=RestAssured.given().body(payload).post(waveurl);
				//				String body=response.getBody().asString();
				//				System.out.println(body);

				
			}
			System.out.println("success");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}

