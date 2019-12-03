import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class gurgaonchamber {
	static WebDriver driver;

	@Test(priority=0)
	public void openbrowser() throws InterruptedException, IOException {
			System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\vinay.rao\\Desktop\\gurgaonC.txt")));
		//	System.setProperty("webdriver.ie.driver", "A:\\selenium_projects\\jars\\IE_driver\\IEDriverServer.exe");
		driver=new ChromeDriver();
		FileInputStream fis = new FileInputStream("C:\\Users\\vinay.rao\\Desktop\\gurgaonchamber.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int a=sheet.getLastRowNum();
		//System.out.println(a);
		String[] wrongurl=new String[a+1];
		int j=0;

		for(j=0; j<wrongurl.length;j++) {
			int val=7;
			XSSFCell row= sheet.getRow(j).getCell(0);
			//System.out.println(j+" "+row);
			String url=row.toString();
			driver.get(url);
			driver.manage().window().maximize();
			Thread.sleep(3000);	
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			List<WebElement> table_count=driver.findElements(By.cssSelector("#middle-middle>table"));
		
			//getting company name

			for(int name=1; name<=table_count.size()-2;name++) {

				// getting how many tr is there?
			//	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(1000);
				List<WebElement> ell=driver.findElements(By.cssSelector("#middle-middle > table:nth-child("+val+") > tbody>tr"));
				Thread.sleep(2000);
				System.out.print(driver.findElement(By.cssSelector("#middle-middle > table:nth-child("+val+") > tbody > tr:nth-child(1) > th")).getText());
				System.out.print("\t");
				for(int k=2; k<=5;k++) {

					System.out.print(driver.findElement(By.cssSelector("#middle-middle > table:nth-child("+val+") > tbody > tr:nth-child("+k+") > td:nth-child(2)")).getText());
					System.out.print("\t");
				}
				System.out.println("");
				val++;
			}

		}
	}
}
