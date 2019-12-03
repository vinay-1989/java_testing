package wave_task;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xwpf.usermodel.ISDTContent;
import org.apache.xpath.operations.Equals;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class hdfc_crowling {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "A:\\selenium_projects\\jars\\chrome_driver\\chromedriver.exe");
		ChromeOptions cop=new ChromeOptions();
		cop.addArguments("vinay");
		WebDriver driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream("C:\\Users\\vinay.rao\\Desktop\\check.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int a=sheet.getLastRowNum();
		//System.out.println(a);
		String[] wrongurl=new String[a+1];
		int j=0;
		for( j=0; j<wrongurl.length;j++) {
			XSSFCell row= sheet.getRow(j).getCell(0);
			System.out.println(j+" "+row);
			String url=row.toString();
			driver.get(url);
			Thread.sleep(2000);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			List<WebElement> le=driver.findElements(By.tagName("a"));
			System.out.println(le.size());
			String[] myArray= new String[4];
			myArray[0]="#mm";
			myArray[1]="javascript";
			myArray[2]="tel:";
			
			
			String val;
			
			for(int i=0;i<le.size();i++) {
				//System.out.print(le.get(i).getText()+" ");
				val=le.get(i).getAttribute("href");
				if (val==null|| val=="") {
					System.out.println("not found");
					continue;
				}
				boolean check=false;
				for(int p=0;p<3;p++) {	
					String org=myArray[p].toString();
					Pattern p1 = Pattern.compile(org);
					Matcher m1=p1.matcher(val);
					if(m1.find()) {
						System.out.println("invalid url");
						check=true;
						break;
					}						
				}
				if(check==false) {
				System.out.println(val);
				}
			}

//						for(int k=0; k<le.size();k++) {
//							System.out.println(le.get(k).getAttribute("href"));				
//						}

						//WebElement ele=driver.findElement(By.tagName("body"));
						//String text=ele.getText();
			//			if(text.isEmpty()) {
			//				//System.out.println("body not present");
			//			}
			//			else {
			//			wrongurl[j]=driver.getCurrentUrl();
			//			//System.out.println(wrongurl[j]);
			//			   driver.quit();
			//			   
			//			}

			//			if(driver.getTitle().equals("Bad Request")) {
			//				wrongurl[j]=url;
			//				System.out.println(wrongurl[j]);
			//			}
			//}


		
	}}
}

