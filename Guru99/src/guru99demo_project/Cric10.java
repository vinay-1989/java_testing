package guru99demo_project;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Cric10 {
	WebDriver driver;

	//@Test(priority=0)
	
	public void openbrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "A:\\selenium_projects\\jars\\chrome_driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.10cric.com");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
	}

	//@Test(priority=1)
	public void Login() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"hr-mid-Top_ResponsiveHeader_33430-page-header-right8\"]/a")).click();
		driver.findElement(By.id("Center_LoginResponsiveBlock_21593-responsive-login-name-input")).sendKeys("raovinay27");
		driver.findElement(By.id("Center_LoginResponsiveBlock_21593-responsive-login-password-input")).sendKeys("Mahansar1989");
		driver.findElement(By.id("Center_LoginResponsiveBlock_21593-submit-button")).click();
		Thread.sleep(3000);
		//		WebElement mo=driver.findElement(By.cssSelector(".page-header-cell.page-header-right div:nth-child(9)"));
		//		Actions action=new Actions(driver);
		//		action.moveToElement(mo).build().perform();
		//		Thread.sleep(1000);
		//WebElement logout=driver.findElement(By.cssSelector("#item-0section-2hr-mid-Top_ResponsiveHeader_33430-page-header-right9 > a > span"));

		//logout.click();

	}

	//@Test(priority=2)
	public void TodayEvent() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#hr-bot-Top_ResponsiveHeader_33430-page-header-left1 > a")).click();
		Thread.sleep(4000);
		//		for(int next=1;next<=5;next++) {
		//			driver.findElement(By.cssSelector("#scarousel-1 > div.scarousel-btn.scarousel-btn-next > div")).click();
		//		}
		Thread.sleep(4000);
		List<WebElement> eventlist=driver.findElements(By.cssSelector("#todays-events .responsive-block.todays-events #sports-carouselCenter_TodaysEventsResponsiveBlock_21695 #scarousel-1 div:nth-child(1) >ul >li"));
		Thread.sleep(2000);
		for(int i=0;i<eventlist.size();i++) {
			if(i>=7) {
				driver.findElement(By.cssSelector("#scarousel-1 > div.scarousel-btn.scarousel-btn-next > div")).click();
				System.out.println(eventlist.get(i).getText()); 
			}
			else {
				System.out.println(eventlist.get(i).getText()); 
			}

		}

	}

	//System.out.println(eventlist.get(2).getText());

	//System.out.println(driver.findElement(By.cssSelector("#todays-events .responsive-block.todays-events #sports-carouselCenter_TodaysEventsResponsiveBlock_21695 #scarousel-1 div:nth-child(1) >ul >li")).getAttribute("id"));


	//@Test(priority=3)
	public void header() {
		List<WebElement> header=driver.findElements(By.cssSelector(".page-header-cell.page-header-left div:nth-child(2)> ul > li"));
		for(int j=0;j<header.size();j++) {
			System.out.print(header.get(j).getText() +" ");
		}

	}
	@SuppressWarnings("deprecation")
	@Test(priority=4)
		public void extract_link() throws IOException {
		//List<WebElement> le=driver.findElements(By.tagName("a"));
		//System.out.println(le.size());
		FileInputStream fis = new FileInputStream("C:\\Users\\vinay.rao\\Desktop\\cric.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("new");
		Row row=sheet.createRow(1);
		Cell cell=row.createCell(0);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		cell.setCellValue("SoftwareTestingMaterial");
		 FileOutputStream fos = new FileOutputStream("D:\\Test.xlsx");
		 wb.write(fos);
		 fos.close();
		 System.out.println("END OF WRITING DATA IN EXCEL");
	}
}
