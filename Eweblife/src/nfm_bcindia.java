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

public class nfm_bcindia {
	static WebDriver driver;

	@Test(priority=0)
	public void openbrowser() throws InterruptedException, IOException {
		System.setOut(new PrintStream(new FileOutputStream("C:\\Users\\vinay.rao\\Desktop\\pharmexcil.txt")));
		System.setProperty("webdriver.ie.driver", "A:\\selenium_projects\\jars\\IE_driver\\IEDriverServer.exe");
		driver=new ChromeDriver();
		//driver.get("https://nfm-bcindia.in/en/exhibitor-details/exhibitors-brand-names/action/defaultlist/controller/Exhibitors/sortfeld/company/sortfolge/ASC/filterhash/4e4674eccea79923aba85a4417ff4b4e/");
		//driver.manage().window().maximize();
		//Thread.sleep(3000);
		// capture Url's listing
		//		List<WebElement> list=driver.findElements(By.cssSelector("#div_AusstellerTreffer > table > tbody > tr"));
		//		System.out.println(list.size());	
		//		for(int l=2;l<=20;l++) {
		//			WebElement urls=driver.findElement(By.cssSelector("#div_AusstellerTreffer > table > tbody > tr:nth-child("+l+") > td.col-sm-4.content_company > div > div:nth-child(2) > div.pull-left > a"));
		//		  System.out.println(urls.getAttribute("href"));
		//		}

		// click on 2nd pagination
		//	JavascriptExecutor js = (JavascriptExecutor) driver;
		//	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//driver.findElement(By.cssSelector("#c223 > div:nth-child(25) > div:nth-child(3) > div > ul li:nth-child(2)")).click();
		//	Thread.sleep(2000);

		// Click on the Last pagination icon
		//driver.findElement(By.cssSelector("#c223 > div:nth-child(25) > div:nth-child(3) > div > ul > li.last > a")).click();
		//  Thread.sleep(2000);

		// click on 33 pagination
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//	driver.findElement(By.cssSelector("#c223 > div:nth-child(25) > div:nth-child(3) > div > ul > li.page_6 > a")).click();

		//for(int pag=2; pag<33;pag++) {
		//			for(int url=2;url<=20;url++) {		
		//				WebElement urls=driver.findElement(By.cssSelector("#div_AusstellerTreffer > table > tbody > tr:nth-child("+url+") > td.col-sm-4.content_company > div > div:nth-child(2) > div.pull-left > a"));
		//				System.out.println(urls.getAttribute("href"));
		//				
		//			}
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//driver.findElement(By.cssSelector("#c223 > div:nth-child(25) > div:nth-child(3) > div > ul > li.next > a")).click(); //11th position of pagination forward icon

		FileInputStream fis = new FileInputStream("C:\\Users\\vinay.rao\\Desktop\\nfm_bcind.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int a=sheet.getLastRowNum();
		//System.out.println(a);
		String[] wrongurl=new String[a+1];
		int j=0;
		for( j=0; j<wrongurl.length;j++) {
			XSSFCell row= sheet.getRow(j).getCell(0);
			//System.out.println(j+" "+row);
			String url=row.toString();
			driver.get(url);
		//	driver.manage().window().maximize();
			Thread.sleep(2000);	

			List<WebElement> check=driver.findElements(By.cssSelector("#details > div:nth-child(2) > div.col-sm-4.content_kontakt > table > tbody > tr"));
			int value=check.size();
			//System.out.println(value);
			if(value==0) {
				System.out.println("no data available");
				
			}
			
			else {
				String C_name=driver.findElement(By.cssSelector("#details > div:nth-child(1) > div.col-sm-6.content_firma > h2")).getText();
				System.out.print(C_name+"\t");
				for(int k=0;k<value;k++) {
					int b=k+1;
					
					String label=	driver.findElement(By.cssSelector("#details > div:nth-child(2) > div.col-sm-4.content_kontakt > table > tbody > tr:nth-child("+b+")>td")).getText();		
					String label_value= driver.findElement(By.cssSelector("#details > div:nth-child(2) > div.col-sm-4.content_kontakt > table > tbody > tr:nth-child("+b+")>td.t_value")).getText();
					System.out.print(label+"\t"+label_value+"\t");
					
				}
				System.out.println("");
			}




//			WebElement phone=driver.findElement(By.cssSelector("#details > div:nth-child(2) > div.col-sm-4.content_kontakt > table > tbody > tr.communication_tel > td.t_value"));
//			System.out.println(phone.getText());
		}
	}
	//}
}
