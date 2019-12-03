package guru99demo_project;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jet_privilege {
	public static void main(String[]args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium jar\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://shop.jetprivilege.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(8000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(8000);
		//checkPageIsReady(driver);
		// (Banner Click)
		
	/*	driver.findElement(By.cssSelector(".bx-wrapper div:nth-child(2) div:nth-child(1) div:nth-child(4)")).click();// click on the 4th pagination
		
		Thread.sleep(2000);
		// Then Click on the 4th banner image
		driver.findElement(By.cssSelector(".bx_slider .bx-wrapper .bx-viewport #bxslider li:nth-child(4)>a")).click(); 
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector(".wrap_popup .dialog_wrap div:nth-child(2) "
				+ ".row div:nth-child(2) "
				+ ".wrap_form_content div:nth-child(2) "
				+ ".form_control input:nth-child(17)")).sendKeys("242659701");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".wrap_popup .dialog_wrap div:nth-child(2) "
				+ ".row div:nth-child(2) .wrap_form_content div:nth-child(2) "
				+ ".form_control .proceedBtn.default_btn_")).click(); */
		
//---------------------------------------------------------------------------------------------------------------------



	/*JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		driver.findElement(By.cssSelector(".bx-wrapper .bx-viewport #bxslide1Banner li:nth-child(1)")).click();
		
		Thread.sleep(2000);
		
		/*driver.findElement(By.cssSelector(".wrap_popup .dialog_wrap div:nth-child(2) "
				+ ".row div:nth-child(2) "
				+ ".wrap_form_content div:nth-child(2) "
				+ ".form_control input:nth-child(17)")).sendKeys("242659701");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".wrap_popup .dialog_wrap div:nth-child(2) "
				+ ".row div:nth-child(2) .wrap_form_content div:nth-child(2) "
				+ ".form_control .proceedBtn.default_btn_")).click();*/

		List<WebElement> list=driver.findElements(By.cssSelector(".bx-wrapper .bx-viewport #bxslide1Banner li"));
		System.out.println(list.size());
		Thread.sleep(2000);
		int k=5;
		int a=5;	
		for(int j=1;j<=list.size();j++) {
			Thread.sleep(3000);
			driver.findElement(By.cssSelector(".bx-wrapper .bx-viewport #bxslide1Banner li:nth-child("+j+") > .homeThumb")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".wrap_popup .dialog_wrap div:nth-child(1) #popup_close_btn")).click();
			/*	driver.findElement(By.cssSelector(".wrap_popup .dialog_wrap div:nth-child(2) "
					+ ".row div:nth-child(2) "
					+ ".wrap_form_content div:nth-child(2) "
					+ ".form_control input:nth-child(17)")).sendKeys("242659701");
			
			Thread.sleep(3000);
			/*driver.findElement(By.cssSelector(".wrap_popup .dialog_wrap div:nth-child(2) "
					+ ".row div:nth-child(2) .wrap_form_content div:nth-child(2) "
					+ ".form_control .proceedBtn.default_btn_")).click();  // proceed button
			ArrayList tabs = new ArrayList (driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(1));
			Thread.sleep(5000);
			driver.close();		
			driver.switchTo().window((String) tabs.get(0)); */
			if(j==k) {
				Thread.sleep(2000);
				driver.findElement(By.cssSelector("#online_partners .next_slide >a")).click();
				k=k+a;
			}
		}
		
		
	



		//.bx-controls.bx-has-pager.bx-has-controls-direction.bx-has-controls-auto .bx-pager.bx-default-pager div:nth-child(1)
		/*WebElement ele=driver.findElement(By.cssSelector(".bx-viewport #bxslider >li >a"));
		System.out.println(ele.getAttribute("class"));
		System.out.println(ele.getAttribute("data-jpmiledesc"));
		ele.click();*/
	}

	private static void checkPageIsReady(WebDriver driver) {
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		 if (js1.executeScript("return document.readyState").toString().equals("complete")){ 
			   System.out.println("Page Is loaded.");
			   return; 
			  } 
		 for (int i=0; i<10; i++){ 
			   try {
			    Thread.sleep(1000);
			    }catch (InterruptedException e) {} 
			   //To check page ready state.
			   if (js1.executeScript("return document.readyState").toString().equals("complete")){ 
			    break; 
			   }   
			  }
		
	}

}
