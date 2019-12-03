package wave_task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.Future;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.http.HttpClient;



public class cookies {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

		System.setProperty("webdriver.chrome.driver", "D:\\selenium jar\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions cop=new ChromeOptions();
		cop.addArguments("disable-infobars");
		WebDriver driver=new ChromeDriver();
		driver.get("https://moxveda.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='txtEmail']")).sendKeys("Kamlesh.verma@process9.com");//Enter email Id
		driver.findElement(By.xpath("//*[@id='txtLoginPass']")).sendKeys("123"); //enter password
		driver.findElement(By.xpath("//*[@id='btnLogin']")).click();
		Thread.sleep(3000);
		String name, value, domain, path;
		Date expiry = null;
		boolean isSecure;
		File file = new File("Cookies.txt");							
		file.createNewFile();			
		FileWriter fileWrite = new FileWriter(file);							
		BufferedWriter Bwrite = new BufferedWriter(fileWrite);	
		System.out.println(driver.manage().getCookies().size());
		for(Cookie ck : driver.manage().getCookies())							
		{			
			Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
			Bwrite.newLine();  
			System.out.print("name="+ck.getName()+"||");
			System.out.print("Value="+ck.getValue()+"||");
			System.out.print("Domain="+ck.getDomain()+"||");
			System.out.print("Path="+ck.getPath()+"||");
			System.out.print("Expiry="+ck.getExpiry()+"||");
			System.out.println("Secure="+ck.isSecure()+"||");
			System.out.println("");
		}		
		Bwrite.close();			
		fileWrite.close();	
		FileReader fileReader = new FileReader(file);							
		BufferedReader Buffreader = new BufferedReader(fileReader);	  
		String strline;	
		while((strline=Buffreader.readLine())!=null){	
			StringTokenizer token = new StringTokenizer(strline,";");									
			while(token.hasMoreTokens()){					
				name = token.nextToken();		
				value = token.nextToken();	
				domain = token.nextToken();					
				path = token.nextToken();		
				expiry = null;			
				String val;
				if(!(val=token.nextToken()).equals("null"))
				{	
					SimpleDateFormat format=new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");  
					System.out.println(val);
					expiry=format.parse(val);
				}		
				Boolean isSecure1 = new Boolean(token.nextToken()).booleanValue();		
				Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure1);			
				//System.out.println(ck);
				driver.manage().addCookie(ck); // This will add the stored cookie to your current session					
			}		
		}		
		driver.get("https://moxveda.com/Home/step1");
	}

}
