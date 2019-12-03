package guru99demo_project;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStreamImpl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.asprise.util.ocr.OCR;

public class bank_proj {
	WebDriver driver;
	@Test(priority=0)
	public void openbrowser() throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "A:\\selenium_projects\\jars\\chrome_driver\\chromedriver.exe");
		driver=new ChromeDriver();
		//driver.get("http://demo.guru99.com/V1/index.php");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		driver.get("https://ewumoney.xyz/5228361344221/");
		//driver.get("http://bg-dev.eweblife.com/prm/bgbtw/rsvp-signup/apply?record=826");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"memberlogin\"]/div[1]/a[1]/u")).click();
		driver.findElement(By.id("username")).sendKeys("prithivi10");
		driver.findElement(By.id("email")).sendKeys("mes.prithivi02@gmail.com");
		driver.findElement(By.id("password1")).sendKeys("megha@shiter23");
		driver.findElement(By.id("password2")).sendKeys("megha@shiter23");
		//Thread.sleep(11000);
		//driver.findElement(By.xpath("//*[@id=\"main\"]/form/table/tbody/tr[12]/td/div/a/img")).click();
		String imgpath=driver.findElement(By.xpath("//*[@id=\"main\"]/form/table/tbody/tr[10]/td[1]/div/b/img")).getAttribute("src");
		 System.out.println("Image source path : \n"+ imgpath);
		 URL url = new URL(imgpath);
		 URLConnection uc= url.openConnection();
		//driver.get(imgpath);
//		 try {
//		 Image image = ImageIO.read(url);
//		 System.out.println("vinay");
//		 Thread.sleep(3000);
//		 String s = new OCR().recognizeCharacters((RenderedImage) image);
//		 System.out.println("Text From Image : \n"+ s);
//		 System.out.println("Length of total text : \n"+ s.length());
//		 }catch(Exception e) {
//			 System.out.println(e);
//		 }
		 BufferedImage image = ImageIO.read(new File("C:\\Users\\vinay.rao\\Desktop\\download.jpg"));   
		   String imageText = new OCR().recognizeCharacters((RenderedImage) image);  
		   System.out.println("Text From Image : \n"+ imageText);  
		   System.out.println("Length of total text : \n"+ imageText.length());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	//@Test(priority=1)
	public void mouseover_activity() throws InterruptedException {
		Actions act=new Actions(driver);
		//if you get value from the iframe first you have to switch to the iframe
		driver.switchTo().frame("_mN_main_224278574_0_n");
		Thread.sleep(2000);
		for(int k=1;k<=3;k++) {
			for(int n=1;n<=2;n++) {
				WebElement link= driver.findElement(By.cssSelector("#ad-wrapper div:nth-child(1) ul:nth-child("+k+") > li:nth-child("+n+") > a"));
				System.out.println(link.getText());
				Thread.sleep(2000);
				act.moveToElement(link).build().perform();
			}
		}
	}
	//@Test(priority=2)
	public void selenium_courses() throws InterruptedException {
		driver.findElement(By.cssSelector(".nav.navbar-nav li:nth-child(1)>a")).click();
		Thread.sleep(1000);
		List<WebElement> s_course=driver.findElements(By.cssSelector(".nav.navbar-nav li:nth-child(1) .dropdown-menu > li > a"));	
		int j=0;	
		for(int i=0;i<s_course.size();i++) {
			j++;		
			System.out.println(s_course.get(j).getText());
		}
	}
	//@Test(priority=1)
	public void login() throws InterruptedException {
		driver.findElement(By.name("uid")).sendKeys("mngr149640");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("Azebeba");
		Thread.sleep(2000);
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(2000);
	}

	//@Test(priority=2)
	public void addcustomer() throws InterruptedException {
		driver.navigate().to("http://demo.guru99.com/V1/html/addcustomerpage.php");
		driver.findElement(By.name("name")).sendKeys("vinay");
		Thread.sleep(1000);
		driver.findElement(By.id("dob")).sendKeys("28031989");
		Thread.sleep(1000);
		driver.findElement(By.name("addr")).sendKeys("1966 B/6 faridabad");
		Thread.sleep(1000);
		driver.findElement(By.name("city")).sendKeys("Faridabad");
		driver.findElement(By.name("state")).sendKeys("Haryana");
		Thread.sleep(2000);
		driver.findElement(By.name("pinno")).sendKeys("121001");
		Thread.sleep(1000);
		driver.findElement(By.name("telephoneno")).sendKeys("9087654343");
		Thread.sleep(2000);
		driver.findElement(By.name("emailid")).sendKeys("vinay.rao@process9.com");
		Thread.sleep(1000);
		driver.findElement(By.name("sub")).click();

		// check For the customer name field validation

		for(int i=1;i<=11;i++) {

			Scanner scan=new Scanner(System.in);
			String a=scan.next();
			System.out.println("Please Enter some input=");
			//	driver.findElement(By.name("name")).click();
			//	driver.findElement(By.name("name")).sendKeys(Keys.TAB);
			driver.findElement(By.name("name")).sendKeys(a);
			System.out.println("Error message="+driver.findElement(By.id("message")).getText());
			driver.findElement(By.name("name")).clear();
		}
	}
}
