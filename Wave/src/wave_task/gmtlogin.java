package wave_task;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.Future;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.ui.Select;
import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

public class gmtlogin {

	public  void abh(String[] args) throws InterruptedException, IOException, ParseException {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium jar\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions cop=new ChromeOptions();
		cop.addArguments("disable-infobars");
		WebDriver driver=new ChromeDriver();
		driver.get("https://moxveda.com/");
		//driver.get("https://www.10cric.com");
		driver.manage().window().maximize();
		//System.out.println(driver.findElement(By.tagName("title")).getText());
		
//DesiredCapabilities dc= DesiredCapabilities.chrome();
//cop.setHeadless(true);
//System.out.println(cop.getBrowserName());

//  cop.addArguments("headless", "--blink-settings=imagesEnabled=false");
// cop.merge(dc);
// WebDriver driver = new ChromeDriver(cop); 
//Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
// System.out.println(cop.getBrowserName());


//driver.manage().window().maximize();
//driver.get("http://gmtdev.mox.net.com/");
//long start = System.currentTimeMillis();


//		HashSet<Cookie> set=(HashSet<Cookie>) driver.manage().getCookies();
//		System.out.println(set.size());
//	for(Cookie st: set) {
//		System.out.println(st.getDomain());
//		System.out.println(st.getClass());
//  System.out.println(st.getValue());
//}

//		System.out.println(driver.getTitle());
//		long finish = System.currentTimeMillis();
//		long totalTime = finish - start; 
//		System.out.println("Total Time for page load - "+totalTime); 
//	driver.get("https://in.bookmyshow.com/tittakudi");

//driver.findElement(By.id("txtName")).sendKeys("admin");



//		Actions a=new Actions(driver);
//		a.moveToElement(driver.findElement(By.id("txtName"))).perform();
//		a.doubleClick().perform();
//		
//		JavascriptExecutor je=(JavascriptExecutor) driver;
//		//je.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", driver.findElement(By.id("formFooter")));
//		je.executeScript("document.getElementById('txtname').value='admin@testmail.com'");








//		Thread.sleep(3000);
//		driver.findElement(By.id("Password")).sendKeys("@321");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary.btn-block.btn-signin")).click();
//		Thread.sleep(4000);
//		Select select =new Select(driver.findElement(By.id("ddlClient")));
//		select.selectByVisibleText("BMS_Vinay");
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector(".container .row div:nth-child(2)")).click();
//		Thread.sleep(2000);
//		String username = RandomStringUtils.randomAlphabetic(10);
//		driver.findElement(By.id("txtUserName")).sendKeys(username);
//		Thread.sleep(1000);
//		String password = RandomStringUtils.randomAlphabetic(10);
//		driver.findElement(By.id("txtPassword")).sendKeys(password);
//		Thread.sleep(2000);
//		Select select1=new Select(driver.findElement(By.id("Roles")));
//		select1.selectByVisibleText("Translator");
//		Thread.sleep(2000);
//		WebElement cl=driver.findElement(By.id("txtQuality"));
//		cl.clear();
//		cl.sendKeys("40");
//		 Thread.sleep(2000);
//		 String email_id = RandomStringUtils.randomAlphabetic(12);
//		 String c_email=email_id+"@gmail.com";
//	 driver.findElement(By.cssSelector(".form-group.row div:nth-child(5) .col-sm-8.ui-widget>div>input")).sendKeys(c_email);
//	 Thread.sleep(3000);
//	driver.findElement(By.cssSelector(".form-control.ng-pristine.ng-untouched.ng-invalid.ng-invalid-required")).sendKeys("Azad");
//		 Thread.sleep(4000);
//		 WebElement lang=driver.findElement(By.cssSelector(".form-group.row div:nth-child(7) .col-sm-8.ui-widget .chosen-container.chosen-container-multi>ul>li>input"));	 	
//		 lang.click();
//		lang.sendKeys("hindi");
//		lang.sendKeys(Keys.ENTER);	
//		 Thread.sleep(3000);
//		 WebElement client=driver.findElement(By.cssSelector(".form-group.row div:nth-child(8) .col-sm-8.ui-widget .chosen-container.chosen-container-multi>ul>li>input"));
//		 
//		 client.click();
//		 Thread.sleep(2000);
//		client.sendKeys("BMS_Vinay");
//		Thread.sleep(1000);
//		client.sendKeys(Keys.ENTER);
//     Thread.sleep(2000);
//     ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//     driver.findElement(By.cssSelector(".form-group.row div:nth-child(11) .ui-widget >input")).click();	
//		


//		Select select1 =new Select(driver.findElement(By.id("cmbTransflag")));
//		select1.selectByVisibleText("Translation");
//		Thread.sleep(1000);
//		driver.findElement(By.id("btnSearch")).click();
//		Thread.sleep(2000);
//		System.out.println(driver.findElement(By.id("dvTotRecord")).getText());
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("#grid tbody > tr td:nth-child(3)")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector(".ui-dialog.ui-widget.ui-widget-content.ui-corner-all.ui-front.ui-draggable.ui-resizable .ui-dialog-titlebar.ui-widget-header.ui-corner-all.ui-helper-clearfix.ui-draggable-handle .ui-button.ui-widget.ui-state-default.ui-corner-all.ui-button-icon-only.ui-dialog-titlebar-close")).click();
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("#grid tbody > tr td:nth-child(3)")).click();
//		Thread.sleep(2000);
//		//driver.findElement(By.id("Edittext")).getText();
//		System.out.println(driver.findElement(By.id("Edittext")).getText());


//		Alert alert = driver.switchTo().alert();
//		alert.accept();

//		driver.findElement(By.id("ddlClient"));
//		Select select =new Select(driver.findElement(By.id("ddlClient")));
//		select.selectByVisibleText("vin_aegon"); // select client "vin_aegon" from dropdown
//		Thread.sleep(2000);
//		driver.findElement(By.id("mlnkMaster")).click(); //Click on Link MANAGE MASTER
//		Thread.sleep(5000);


// Getting Auth-key and Client name

//		List<WebElement> em=driver.findElements(By.cssSelector("#dvClientMaster .grid-mvc .grid-wrap .table.table-striped.grid-table tbody tr"));             
//		for(int h=0;h<em.size();h++) {
//			int x= h+1;
//			WebElement x1 =driver.findElement(By.cssSelector("#dvClientMaster .grid-mvc .grid-wrap .table.table-striped.grid-table tbody tr:nth-child("+x+") td:nth-child(3)"));            
//			WebElement x2 =driver.findElement(By.cssSelector("#dvClientMaster .grid-mvc .grid-wrap .table.table-striped.grid-table tbody tr:nth-child("+x+") td:nth-child(4)"));
//			System.out.print("Auth-Key="+x1.getText()+"        " +"client name="+x2.getText());
//			System.out.println();
//		}

// Click on link MANAGE USER and create Add NEW USER

//		driver.findElement(By.id("mlnkUserManagement")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.id("txtUserName")).sendKeys("Abdul");
//		driver.findElement(By.id("txtPassword")).sendKeys("98765");
//		Select select1=new Select(driver.findElement(By.id("Roles")));
//		select1.selectByVisibleText("Translator");
//		WebElement cl=driver.findElement(By.id("txtQuality"));
//		cl.clear();
//		cl.sendKeys("40");
//		driver.findElement(By.xpath("//*[@id=\"page_content\"]/div/form/div[5]/div/div/input")).sendKeys("abdul342gmail.com");
//		driver.findElement(By.name("UserFName")).sendKeys("abbu");
//		driver.findElement(By.cssSelector(".chosen-container.chosen-container-multi")).click();
//      	driver.findElement(By.cssSelector(".chosen-drop .chosen-results li:nth-child(9)")).click();
//      	Thread.sleep(4000);
//      	WebElement rt=driver.findElement(By.cssSelector(".row.ng-pristine.ng-scope.ng-invalid.ng-invalid-required.ng-valid-email"));
//      	rt.getAttribute("class");


//		String a= "C:\\Users\\vinay.rao\\Desktop\\vinay.txt";
//		String b="C:\\Users\\vinay.rao\\Desktop\\test1.txt";
//		
//		File f=new File(a);
//		
//		 FileOutputStream fos1=new FileOutputStream(a);   
//		 FileOutputStream fos2=new FileOutputStream(b); 		 
//         String data="My name is mr rao.";
//        byte[] bt=data.getBytes();
//       
//        fos1.write(bt);
//       FileInputStream fin=new FileInputStream("C:\\Users\\vinay.rao\\Desktop\\vinay.txt");  


//        int i=0;
//      while((i=fin.read())!=-1) {
//    	  
//    	      fos2.write(i);	     
//      }


//		FileReader fr=new FileReader("C:\\Users\\vinay.rao\\Desktop\\test.txt");
//		//System.err.println("error message");  
//		int i=System.in.read();
//		System.out.println(i);



//
//		driver.get("https://www.google.co.in");
//		Thread.sleep(3000);
//		driver.findElement(By.id("lst-ib")).sendKeys("coming soon");
//		WebElement gg=driver.findElement(By.cssSelector(".sbsb_b li:nth-child(6) div#sbse5 >.sbqs_c"));
//		System.out.println(gg.getAttribute("class"));
//		gg.click(); 


//				int i=0;
//				Thread.sleep(6000);
//				WebElement newv = null;
//				String text="coming soon mobile";
//				List<WebElement> el= driver.findElements(By.cssSelector(".sbsb_b .sbsb_c.gsfs > div  .sbqs_c"));
//				Thread.sleep(6000);
//				String[] qw=new String[el.size()];
//				for( i=0; i<el.size();i++) {	
//					qw[i]= el.get(i).getText();
//					System.out.println(qw[i]);
//					Thread.sleep(2000);
//					if(qw[i].equals(text)) {
//						int b=Arrays.asList(qw).indexOf(text);
//						System.out.println(b);
//						int c=b+1;
//						 newv=driver.findElement(By.cssSelector(".sbsb_b li:nth-child("+c+") > div .sbqs_c"));
//						System.out.println("value of 5th element="+newv.getText());

//}
//	}
// newv.click();
//for(WebElement av:el) {
//					qw[i]=av.getText();
//					System.out.println(qw[i]);
//					if(av.equals(text)) {				
//					}
//				}
//				if(qw[i].equals(text)) {
//					int a=qw[i].indexOf(text);
//				driver.findElement(By.cssSelector(".sbsb_b li:nth-child("+a+") div#sbse("+a+") >.sbqs_c")).click();
//				     }  

//}

}
}
