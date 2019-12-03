package wave_task;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class lsearch {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "A:\\selenium_projects\\jars\\chrome_driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://192.168.100.21/LuceneReader/User/Login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("txtName")).sendKeys("admin");
		driver.findElement(By.id("Password")).sendKeys("123");
              Thread.sleep(3000);
             driver.findElement(By.cssSelector("fieldset>div>div div:nth-child(5)")).click();
            Thread.sleep(3000);
            
            JavascriptExecutor jse = (JavascriptExecutor)driver;
    		jse.executeScript("window.open()");
    		jse.executeScript("window.open()");
            ArrayList tabs = new ArrayList (driver.getWindowHandles());
            
    		driver.switchTo().window((String) tabs.get(1));
    		driver.navigate().to("http://192.168.100.21/EditToolQA");
            Thread.sleep(2000);
            driver.switchTo().window((String) tabs.get(0));
            
         driver.findElement(By.id("txtInput")).sendKeys("please enter your wallet passcode");
         Thread.sleep(2000);
         driver.findElement(By.id("btnSearch")).click();
        
 		driver.switchTo().window((String) tabs.get(2));
		driver.navigate().to("https://www.google.com/");
         
        
		
		
         
         
//1st way to select 'HindiTranslate.txt' from drop-down
		// Select select=new Select(driver.findElement(By.id("DDL_FolderList"))); 
		// select.selectByVisibleText("HindiTranslate.txt");

//2nd way to select 'HindiTranslate.txt' from drop-down by using down-arrow key
//		WebElement ele=driver.findElement(By.id("DDL_FolderList"));
//		ele.click();
//		Select select=new Select(driver.findElement(By.id("DDL_FolderList")));
//		List<WebElement> li= select.getOptions();
//		String[] text=new String[li.size()];
//		for(int i=0;i<li.size();i++) {
//			text[i]=li.get(i).getText();
//			if(text[i].equalsIgnoreCase("HindiTranslate.txt")) {
//				select.selectByIndex(i);
//				Thread.sleep(2000);
//				ele.sendKeys(Keys.RETURN);
//				break;
//			}
//			ele.sendKeys(Keys.DOWN);
//		}
//		calldata(driver);  // call for getting string from text file
//
//	}

//	static void calldata(WebDriver driver) throws IOException, InterruptedException {
//
//		try {
//			Charset charset = Charset.forName("utf-8");
//			Path _path = Paths.get("C:\\Users\\vinay.rao\\Desktop\\testdata.txt");
//			List<String> lines = Files.readAllLines(_path,charset);
//			for (String line : lines) {	
//				System.out.println(line);
//
//				WebElement we=driver.findElement(By.id("Txt_SearchText"));
//				we.sendKeys(line);
//				Thread.sleep(2000);
//				driver.findElement(By.id("CBox_WholeWordMatch")).click();
//				Thread.sleep(2000);
//				driver.findElement(By.id("Btn_SearchData")).click();
//				Thread.sleep(8000);
//				List<WebElement> rt=driver.findElements(By.cssSelector(".datagrid > table  tbody > tr"));
//				for(int j=1;j<=rt.size();j++) {
//					List<WebElement> rt1=driver.findElements(By.cssSelector(".datagrid > table  tbody > tr:nth-child("+j+")"));
//					System.out.println(rt1.get(0).getText());
//					System.out.print(" ");
//				}		
//				driver.findElement(By.name("Txt_SearchText")).clear();
//				Thread.sleep(1000);
//			}
//		}catch(FileNotFoundException e) {
//
//		}
	}
}
