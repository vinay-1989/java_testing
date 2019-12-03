package guru99demo_project;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class payment_gateway {
	public static WebDriver driver;
	//JavascriptExecutor js=(JavascriptExecutor) driver;
	String[] list=null;
	String[] vinay=null;
	public int i,a,month,exp,qn;
	String cardnumber,Expiry,year;
	Scanner scan;

	@Test(priority=0)
	public void openbrowser() throws InterruptedException {
		System.out.println("hello");
		System.setProperty("webdriver.chrome.driver", "A:\\selenium_projects\\jars\\chrome_driver\\chromedriver.exe");
		scan=new Scanner(System.in);
		System.out.println("hello2");
		 System.out.print("please Enter Quantity for purchase product=");
		 qn=scan.nextInt();
		driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/payment-gateway/purchasetoy.php");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}

	//@Test(priority=1)
	public void card_details() throws InterruptedException {
		driver.get("http://demo.guru99.com/payment-gateway/cardnumber.php");
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		List<WebElement> ele=driver.findElements(By.cssSelector(".inner h4"));
		list=new String[ele.size()];
		for(int i=0;i<ele.size();i++) {
			list[i]=ele.get(i).getText();    
			System.out.println(list[i]);
			list[i]= list[i].replaceAll("[^0-9]", "");
		}	
		cardnumber=list[0];
		String Expiry=list[2]; // split Month and year 
		exp=Integer.parseInt(Expiry); // convert String to Int
		System.out.println(exp);
		month= exp/10000; // Getting  month value
		a=exp%10000;  //Getting year value
		year=Integer.toString(a);
	}
	//@Test(priority=3)
	public void checklimit() throws InterruptedException{
		driver.get("http://demo.guru99.com/payment-gateway/check_credit_balance.php");
		Thread.sleep(3000);
		//String[]a=cardnumber.split(":-"); // it will split value
		driver.findElement(By.id("card_nmuber")).sendKeys("cardnumber");
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		String match="This Card Not Any Transactions";
		List<WebElement> notrans= driver.findElements(By.cssSelector("#three .inner font"));
		String actual=notrans.get(1).getText();
		if(actual.equalsIgnoreCase(match)) {
			System.out.println("No transaction");
		}
	}



	//@Test(priority=2)
	public void shoping() throws InterruptedException {
		driver.get("http://demo.guru99.com/payment-gateway/purchasetoy.php");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		Select quantity=new Select(driver.findElement(By.cssSelector(".row div:nth-child(4) >select")));
		quantity.selectByIndex(qn-1);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".row div:nth-child(8)")).click();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		driver.findElement(By.id("card_nmuber")).sendKeys(cardnumber);
		Thread.sleep(3000);
		Select select=new Select(driver.findElement(By.id("month")));
		select.selectByIndex(month);
		Thread.sleep(3000);
		Select sel=new Select(driver.findElement(By.id("year")));
		sel.selectByVisibleText(year);
		Thread.sleep(2000);
		driver.findElement(By.id("cvv_code")).sendKeys(list[1]);
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();	
		Thread.sleep(2000);
	}




	//@Test(priority=4)
	public void randomnumber() throws InterruptedException {
		System.out.println("testttttt");
		for(int x=1;x<9;x++) {
			//driver.get("http://demo.guru99.com/payment-gateway/purchasetoy.php");

			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(3000);
			Select quantity=new Select(driver.findElement(By.cssSelector(".row div:nth-child(4) >select")));
			quantity.selectByIndex(x-1);
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".row div:nth-child(8)")).click();

			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			driver.findElement(By.id("card_nmuber")).sendKeys("7777888877778811");
			//7777888877778800
			Thread.sleep(3000);
			Select select=new Select(driver.findElement(By.id("month")));
			select.selectByIndex(x);
			Thread.sleep(3000);
			Select sel=new Select(driver.findElement(By.id("year")));
			sel.selectByIndex(x);
			Thread.sleep(2000);
			driver.findElement(By.id("cvv_code")).sendKeys("333");
			Thread.sleep(2000);
			driver.findElement(By.name("submit")).click();	
			Thread.sleep(2000);
		}	
	}

}
