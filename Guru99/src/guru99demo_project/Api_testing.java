package guru99demo_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.URL;
//import groovy.util.slurpersupport.GPathResult;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.http.Method;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;


public class Api_testing {
//
	public static void main(String[] args){
		System.out.println("test");
		System.setProperty("webdriver.chrome.driver", "A:\\selenium_projects\\jars\\chrome_driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://ewumoney.xyz/showadv.php?rstr=0.24694760613451305");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("raovinay27");
		driver.findElement(By.id("password")).sendKeys("Mahansar@1989");
		driver.findElement(By.xpath("//*[@id=\"main\"]/form/table/tbody/tr[5]/td/div/a/img")).click();
		
//
////		RestAssured rs=new RestAssured();
////		rs.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
////	    rs.basePath="/ramji";
////	    RequestSpecification req_sp=rs.given();
////	    Response resp= req_sp.request(Method.GET, "/delhi");
////		System.out.println(resp.getBody().asString());
////		given().request(Method.GET, "/delhi").getBody().asString();
//
//	//System.out.println(given().when().get("http://192.168.100.21/MoxCorpus/corpusapi/spellcheck?sentence=लोन&lang=Hindi&vocabs=standard").getBody().asString());
//	System.out.println(given().get("http://192.168.100.21/MoxCorpus/corpusapi/spellcheck?sentence=लोन&lang=Hindi&vocabs=standard").getBody().asString());
////	rs.baseURI ="http://restapi.demoqa.com/utilities/weather/city/Hyderabad";
////	 RequestSpecification req_spe= rs.given();
////	 req_spe.basePath(rs.basePath);
////
////
////	Response rp= req_spe.request(Method.GET);
////	System.out.println(rp.getBody().asString());;
////
//	//RestAssured.basePath="";
////		Response response = given().
////				contentType(ContentType.JSON)
////				.accept(ContentType.JSON)
////				.body("{\"key\":\"BEA2-55EF-603A-40D7-A27F-B767-D0B9-8A72\","
////						+ "\"data\":[{\"field\":\"\","
////						+ "\"text\":\"ek anokhi kahani\","
////						+ "\"qual\":1,"
////						+ "\"op\":0,"
////						+ "\"inln\":\"English\","
////						+ "\"category\":\"\","
////						+ "}"
////						+ "],\"lang\":[\"hindi\"],"
////						+ "\"categories\":\"Address_Name\","
////						+ "\"QAmode\":true,"
////						+ "\"recid\":\"2k2j32\","
////						+ "\"priority\": null}")
////				.when()
////				.post(ROOT_URI + "/create");
////		System.out.println("POST Response\n" + response.asString());
	}
	}
