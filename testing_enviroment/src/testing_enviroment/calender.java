package testing_enviroment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class calender {
	String date;
	static int actualdate;
	static int month;
	static int year;
	static int actualyear;
	static int year1;
	XSSFWorkbook wb;
	static int monthcheat;
	static int z=0;

	public void userinput() {
		System.out.println("please Enter  date in the format: dd/mm/yy");
		Scanner scan=new Scanner(System.in);
		date=scan.next();
		String[] split=date.split("/");
		actualdate=Integer.parseInt(split[0]);
		month=Integer.parseInt(split[1]);
		year=Integer.parseInt(split[2]);
		actualyear=year;
	}
	public void logic() {		  
		year=year%100;
		year1=year/4;	
	}
	public void readmonth() throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\vinay.rao\\Desktop\\days.xlsx");
		wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(1);	 
		XSSFCell row=sheet.getRow(month-1).getCell(0);	
		monthcheat= (int)  row.getNumericCellValue();
	}
	public void readyear() {
		
		XSSFSheet sheet2=wb.getSheetAt(2);		
		for(int k=0;k<=sheet2.getLastRowNum();k++) {
			XSSFCell row1=sheet2.getRow(k).getCell(z);
			XSSFCell row2=sheet2.getRow(k).getCell(z+1);
			double a1= row1.getNumericCellValue();
			double a2=row2.getNumericCellValue();
			if(actualyear>=(int)a1 && actualyear<=(int)a2) {
				XSSFCell row3=sheet2.getRow(k).getCell(z+2);
				double yearC_value=row3.getNumericCellValue();
				int change=(int)yearC_value;
				int total=year+year1+actualdate+monthcheat+change;
				int x=total%7;
				XSSFSheet sheet1=wb.getSheetAt(0);
				System.out.println(sheet1.getRow(x).getCell(1));
			}
		}

	}
	public static void main(String[] args) throws IOException, ParseException {
		System.out.println("This is our calender program to find out day");
		calender cal=new calender();
		cal.userinput();
		cal.logic();
		cal.readmonth();
		cal.readyear();
	}
}
