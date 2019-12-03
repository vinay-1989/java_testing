package wave_task;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class bms_crawling {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "A:\\selenium_projects\\jars\\chrome_driver\\chromedriver.exe");
		ChromeOptions cop=new ChromeOptions();
		cop.addArguments("vinay");
		WebDriver driver = new ChromeDriver();
		FileInputStream fis = new FileInputStream("C:\\Users\\vinay.rao\\Desktop\\checkdata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int a=sheet.getLastRowNum();
		System.out.println(sheet.getRow(0).getLastCellNum());
		System.out.println(a);
		String[] wrongurl=new String[a+1];
		int j=0;
		for( j=0; j<wrongurl.length;j++) {
			XSSFCell row= sheet.getRow(j).getCell(0);
			System.out.println(j+" "+row);
			String url=row.toString();
			driver.get(url);
			Thread.sleep(2000);
			driver.manage().window().maximize();
			Thread.sleep(8000);
		//	List<WebElement> le=driver.findElements(By.tagName("a"));
			///System.out.println(le.size());
			//String val = null;
//			for(int i=0;i<le.size();i++) {
//				//System.out.print(le.get(i).getText()+" ");
//				val=le.get(i).getAttribute("href");
//				System.out.println(val);
//				
//				FileOutputStream fos=new FileOutputStream("C:\\Users\\vinay.rao\\Desktop\\check.xlsx");
//				wb.write(fos);
				
				
				
				
				
				
//				try {
//				FileOutputStream fos=new FileOutputStream("C:\\Users\\vinay.rao\\Desktop\\output.txt" , true);
//				byte b[]=val.getBytes();
//				fos.write(b);
//				String lineSeparator = System.getProperty("line.separator");
//				fos.write(lineSeparator.getBytes());
//				
//				}catch(Exception e)
//						{System.out.println(e);}
				//}
		}}}
