package wave_task;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class localized {

	static void edittool(String txtsearch) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\selenium jar\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://stackoverflow.com/questions/40837892/how-to-find-out-x-and-y-offset-when-trying-to-drag-move-an-element-in-selenium");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		/*	driver.get("http://192.168.100.21/P9EditToolQA/User/Login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("txtName")).sendKeys("admin");
		Thread.sleep(2000);
		driver.findElement(By.id("Password")).sendKeys("@321");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".btn.btn-info.btn-sm")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("12")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#right_column .table>tbody>tr>td>a")).click();
		Thread.sleep(2000);	

		WebElement ele=driver.findElement(By.cssSelector("#P9Trans>thead>tr:nth-child(2)>td>input"));
		ele.sendKeys(txtsearch);
		Thread.sleep(2000);
		ele.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		WebElement ele1=driver.findElement(By.cssSelector("#P9Trans tbody .P9Trans-selected>td:nth-child(2)"));
		action.doubleClick(ele1).perform();
		Thread.sleep(3000);
		WebElement ele2= driver.findElement(By.cssSelector("#SpellCheck #Edittext"));
		ele2.clear();




		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.open()");

		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window((String) tabs.get(1)); */
//		driver.navigate().to("https://www.google.com");
//		Thread.sleep(2000);
//
//		WebElement google1=driver.findElement(By.cssSelector(".RNNXgb.sbfc .SDkEP .a4bIc input.gLFyf.gsfi"));
//		System.out.println(google1.getAttribute("class"));
//		google1.sendKeys("dfdf");
//		google1.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);
//		driver.findElement(By.id("tw-source-text-ta")).sendKeys(txtsearch);
//		Thread.sleep(3000);
//		String hindi= driver.findElement(By.id("tw-target-text")).getText();
//		System.out.println(hindi);
		//	driver.switchTo().window((String) tabs.get(0));
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("#SpellCheck #Edittext")).sendKeys(hindi);
//		Thread.sleep(3000);
//		driver.findElement(By.id("btnDone")).click();

		//		Thread.sleep(15000);
		//		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
		//		jse1.executeScript("window.open()");
		//		driver.switchTo().window((String) tabs.get(1));
		//		driver.navigate().to("http://192.168.100.21/LuceneReader/User/Login");
		//		Thread.sleep(3000);
		//		driver.findElement(By.id("txtName")).sendKeys("admin");
		//		driver.findElement(By.id("Password")).sendKeys("@321");
		//              Thread.sleep(3000);
		//           driver.findElement(By.cssSelector("fieldset>div>div div:nth-child(5)")).click();   
		//            Thread.sleep(3000);
		//         driver.findElement(By.id("txtInput")).sendKeys(name);
		//         Thread.sleep(2000);
		//         driver.findElement(By.id("btnSearch")).click();
	}


	public static  void main(String[] args) {
		String vinay="What can we help you find?";
		try {
			edittool(vinay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
