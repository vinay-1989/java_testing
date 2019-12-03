import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class pharmexcil {

	static WebDriver driver;

	@Test(priority=0)
	public void openbrowser() throws InterruptedException, IOException {
		System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\vinay.rao\\Desktop\\pharmexcil.txt")));
		//System.setProperty("webdriver.ie.driver", "A:\\selenium_projects\\jars\\IE_driver\\IEDriverServer.exe");
		driver=new ChromeDriver();
		driver.get("https://pharmexcil.com/members");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		//Actual
		driver.findElement(By.xpath("//*[@id=\"pagination-digg\"]/ul/li[2]")).click();

		for(int i=1; i<=226;i++) {
			Thread.sleep(2000);
			for(int l=2;l<=21;l++) {
				WebElement Cname=	driver.findElement(By.cssSelector("#content > table:nth-child(6) > tbody > tr:nth-child("+l+") > td:nth-child(1) > a"));
				System.out.print(Cname.getText()+"\t");
				WebElement member_cat=driver.findElement(By.cssSelector("#content > table:nth-child(6) > tbody > tr:nth-child("+l+") > td:nth-child(2)"));
				System.out.print(member_cat.getText()+"\t");
				WebElement Website=driver.findElement(By.cssSelector("#content > table:nth-child(6) > tbody > tr:nth-child("+l+") > td:nth-child(3) > a"));
				System.out.println(Website.getText());
			}
			driver.findElement(By.xpath("//*[@id=\"pagination-digg\"]/ul/li[12]")).click();
			Thread.sleep(1000);
		}
	}
}
