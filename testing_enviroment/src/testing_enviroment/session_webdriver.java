package testing_enviroment;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.eclipse.jetty.client.HttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.http.W3CHttpCommandCodec;
import org.openqa.selenium.remote.http.W3CHttpResponseCodec;
import org.openqa.selenium.remote.server.DriverFactory;

public class session_webdriver {

	

	public static void main(String [] args) throws IOException, InterruptedException {
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//		HttpGet httpGet = new HttpGet("http://targethost/homepage");
//		CloseableHttpResponse response1 = httpclient.execute(httpGet);
//		CookieStore cookieStore = new BasicCookieStore();
//		HttpClientContext localContext = HttpClientContext.create();
//		localContext.setCookieStore(cookieStore);		 
//		HttpGet httpget = new HttpGet("https://www.amazon.in/ap/signin");
//		System.out.println("Executing request " + httpget.getRequestLine());
//		 HttpClient client = new HttpClient();
//		Future<HttpResponse> future = (Future<HttpResponse>) client.getExecutor();
//	
//		HttpPost httpPost = new HttpPost("https://www.hepsiburada.com/ayagina-gelsin/Customer/Login");
//		List<NameValuePair> params = new ArrayList<NameValuePair>();
//		params.add(new BasicNameValuePair("em", "username"));
//		params.add(new BasicNameValuePair("p", "password"));
//		httpPost.setEntity(new UrlEncodedFormEntity(params));
//		Future<HttpResponse> future = httpclient.execute(httpPost,localContext,null);
//		HttpResponse response = future.get();
//		cookies = cookieStore.getCookies();

	    WebDriver driver = new ChromeDriver();
	    driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#nav-tools>a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ap_email")).sendKeys("8826960092");
		Thread.sleep(1000);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ap_password")).sendKeys("mahansar@1989");
		Thread.sleep(2000);
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(3000);
		driver.navigate().to("https://www.amazon.in/Vendoz-Women-White-Casual-Sneakers/dp/B07NC5D4LT/ref=sr_1_6?crid=1IYV6L2C2VX12&keywords=sneakers+for+women+stylish&qid=1557989353&s=gateway&sprefix=sneakers%2Caps%2C303&sr=8-6");
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		Set<Cookie> cookies1 = driver.manage().getCookies();
		System.out.println("Coockies = "+cookies1);
		driver.close();
		
	
		
		WebDriver driver2=new ChromeDriver();
		driver2.get("https://www.amazon.in/");
		for(Cookie cookie : cookies1)
		{
		driver2.manage().addCookie(cookie);
		}
		driver2.navigate().to("https://www.amazon.in/Vendoz-Women-White-Casual-Sneakers/dp/B07NC5D4LT/ref=sr_1_6?crid=1IYV6L2C2VX12&keywords=sneakers+for+women+stylish&qid=1557989353&s=gateway&sprefix=sneakers%2Caps%2C303&sr=8-6");
	    
	    Thread.sleep(2000);
		WebElement select=driver.findElement(By.cssSelector("id#native_dropdown_selected_size_name"));
		System.out.println(select.getAttribute("class"));
	    
	    
	   
//	    driver.get("https://www.google.com");
//	    CommandExecutor ce= ((RemoteWebDriver)driver).getCommandExecutor();
//	    
//	    Capabilities cap =  ((RemoteWebDriver)driver).getCapabilities();
//	   SessionId session= ((RemoteWebDriver)driver).getSessionId();
//	    
//	      System.out.println("Session id: " + session.toString());
//	      System.out.println("command_exe: " + ce.toString());
//	     WebDriver  driver1 = WebDriver.Remote(command_executor=url,desired_capabilities={})
	      
//	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//	    WebDriver driver1 = new RemoteWebDriver(new URL("http://localhost:4722/wd/hub"), capabilities);
//
//         SessionId ses= ((RemoteWebDriver)driver1).getSessionId();
//         System.out.println("Session id: " + ses.toString());
	    
//	    HttpCommandExecutor executor = (HttpCommandExecutor) ((RemoteWebDriver) driver).getCommandExecutor();
//	    URL url = executor.getAddressOfRemoteServer();
//	    SessionId session_id = ((RemoteWebDriver) driver).getSessionId();
//        System.out.println(url);
//        System.out.println(session_id );
//	    RemoteWebDriver driver2 = createDriverFromSession(session_id, url);
//	    driver2.get("https://www.amazon.in/?ref_=nav_signin&");
	}
}
