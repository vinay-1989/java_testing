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
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Eweb_life {
	static WebDriver driver;

	@Test(priority=0)
	public void openbrowser() throws InterruptedException {
		System.setProperty("webdriver.ie.driver", "A:\\selenium_projects\\jars\\IE_driver\\IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability("requireWindowFocus", true);
		driver=new InternetExplorerDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("http://bg-dev.eweblife.com/prm/bgbtw/rsvp-signup/apply?record=826");
		driver.manage().window().maximize();
	}
	@Test//(priority=2)
	public void validate_field() throws InterruptedException {

		//		//Click on the submit button without filling any field
		//		JavascriptExecutor js = ((JavascriptExecutor) driver);
		//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.cssSelector(".center .form_btn.submit")).click();
		List<WebElement> f=driver.findElements((By.className("required")));
		int j=1;
		for(int i=0;i<f.size();i++) {
			Thread.sleep(2000);
			WebElement man=	driver.findElement(By.xpath("//*[@id=\"applicationPage\"]/div["+j+"]/div[1]"));
			j=j+2;
			System.out.println(man.getText());	
		}
	}

	//@Test(priority=1)
	public void fill_detail() throws InterruptedException, AWTException {

		driver.findElement(By.id("field_12052")).sendKeys("Vinay");
		driver.findElement(By.id("field_12053")).sendKeys("Rao");
		driver.findElement(By.name("field[12054][value]")).sendKeys("raovinay27@gmail.com");
		driver.findElement(By.id("phone_flag_field_12055_6884")).click();
		driver.findElement(By.name("field[12055][value][6884][number]")).sendKeys("9898989898");
		driver.findElement(By.name("field[12055][value][6884][extension]")).sendKeys("91");
		driver.findElement(By.id("field-12056-field_value_id-3627")).click();
		driver.findElement(By.id("field-12056-sub_field_ids-20-field_value_id-1")).click();
		driver.findElement(By.id("field_12056_sub_field_ids_2")).sendKeys("Rao");
		Select profile=new Select(driver.findElement(By.name("field[12058][field_value_id]")));
		profile.selectByVisibleText("Tester");
		//			JavascriptExecutor js = ((JavascriptExecutor) driver);
		//			js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div#field_block_field_12059 >a")).click();;
		driver.findElement(By.id("drop-area_field_12059")).click();
		Thread.sleep(4000);
		StringSelection strSel = new StringSelection("C:\\Users\\vinay.rao\\Desktop\\download.jpg");
		Clipboard clipboard= Toolkit.getDefaultToolkit().getSystemClipboard();

		clipboard.setContents(strSel, null);
		// be carefully when you are working with robot file in the meanwhile time 
		//you should not used/touch mouse or any keyboard event.
		Robot robot=new Robot();
		robot.delay(1000);
		//			robot.keyPress(KeyEvent.VK_ENTER);
		//			robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_ENTER);

		//driver.findElement(By.xpath("//*[@id=\"applicationPage\"]/div[26]/div[2]/label[2]/input[2]")).click();
		//			Select ticket=new Select(driver.findElement(By.id("section_674_745")));
		//			ticket.selectByVisibleText("2");
		//			driver.findElement(By.name("password")).sendKeys("Azyxw@123");
		//			driver.findElement(By.name("confirm_password")).sendKeys("Azyxw@123");
		//			Select security_ques=new Select(driver.findElement(By.name("security_question_id")));
		//			security_ques.selectByValue("8");
		//			driver.findElement(By.name("security_answer")).sendKeys("vihu");
		//			//click on the submit button
		//			driver.findElement(By.cssSelector(".center .form_btn.submit")).click();

	}
}
