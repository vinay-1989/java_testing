package wave_task;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Log_manager {
	WebDriver driver;
	@Test(priority=0)
	public void openbrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "A:\\selenium_projects\\jars\\chrome_driver\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.get("http://localhost/Logmanager/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
	}
@Test(priority=1)
	public void login() throws InterruptedException {
	driver.findElement(By.id("txtName")).sendKeys("admin");
	Thread.sleep(2000);
	driver.findElement(By.id("Password")).sendKeys("@321");
	Thread.sleep(2000);
	driver.findElement(By.cssSelector(".btn.btn-primary")).click();
	Thread.sleep(2000);
}

@Test(priority=2)
public void Add_client() throws InterruptedException {
	driver.findElement(By.cssSelector("tbody td:nth-child(2) a:nth-child(2)")).click();
	Thread.sleep(2000);
	List<WebElement> we= driver.findElements(By.cssSelector("tr >td #jobtype input#IsJobCreation"));
	 we.get(1).click();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("tbody tr:nth-child(2)> td> div >input")).click();
	driver.findElement(By.id("txtCustomerName")).sendKeys("oracle_org");
	Thread.sleep(2000);
	driver.findElement(By.id("txtCustomerCode")).sendKeys("orc12");
	System.out.println(driver.findElement(By.id("txtAuthKey")).getAttribute("value"));
	

	
	
}
}
