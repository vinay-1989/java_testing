import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class life_Eweb {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.ie.driver", "A:\\selenium_projects\\jars\\chrome_driver\\chromedriver.exe");
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://bg-dev.eweblife.com/prm/bgbtw/rsvp-signup/apply?record=826");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".center .form_btn.submit")).click();
		List<WebElement> f=driver.findElements((By.className("required")));
		int j=1;
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector(".list_data .form.remove_padding div:nth-child(9)>div")).getText());
		for(int i=0;i<f.size();i++) {
			Thread.sleep(2000);
			WebElement man=	driver.findElement(By.xpath("//*[@id=\"applicationPage\"]/div["+j+"]/div[1]"));
					//driver.findElement(By.cssSelector(".list_data .form.remove_padding div:nth-child("+j+") div:nth-child(1)"));
			j=j+2;
			System.out.println(man.getText());	
		}
	}

	

}
