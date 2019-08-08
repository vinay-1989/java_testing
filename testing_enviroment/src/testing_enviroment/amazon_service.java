package testing_enviroment;
import java.text.NumberFormat;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;


public class amazon_service {
	WebDriver driver;
	@Test(priority=0)
	public void openbrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "A:\\selenium_projects\\jars\\chrome_driver\\chromedriver.exe");	
		ChromeDriver dv=new ChromeDriver();
		
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		Thread.sleep(4000);
	}
	@Test(priority=1)
	public void login() throws InterruptedException {
		driver.findElement(By.cssSelector("#nav-tools>a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ap_email")).sendKeys("8826960092");
		Thread.sleep(1000);
		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ap_password")).sendKeys("mahansar@1989");
		Thread.sleep(2000);
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(3000);	
	}

	@Test(priority=2)
	public void search() throws InterruptedException {
		Thread.sleep(1000);
//		WebDriverWait wait=new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated((By.id("twotabsearchtextbox"))));
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sneakers");
		Thread.sleep(3000);
		List <WebElement> lwe=driver.findElements(By.cssSelector("#nav-flyout-iss-anchor>div>div>div .s-suggestion"));
		String clickable_product="sneakers for women stylish";
		Thread.sleep(2000);
		System.out.println(lwe.size());
		for(int i=0;i<lwe.size();i++) {
			String p_list=(lwe.get(i).getText());
			int a=++i;
			if(clickable_product.equals(p_list)) {
				//driver.findElement(By.cssSelector("#nav-flyout-iss-anchor>div>div>div div:nth-child("+a+")")).click();
				driver.findElement(By.xpath("//nav-flyout-searchAjax/div/div/div[position()=$"+a+"]"));        
			}
		}
		
		Thread.sleep(2000);
	}

	//@Test(priority=3)
	public void select_product() throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> dummy=driver.findElements(By.cssSelector(".s-result-list.sg-row > div"));
		System.out.println(dummy.size());
		String product_name="Vendoz Women White Sneaker Casual Shoes";
		for(int k=0;k<dummy.size();k++) {
			String data_index=dummy.get(k).getAttribute("data-index");
			int number=Integer.parseInt(data_index);
			int index= number+1;
			//Thread.sleep(2000);
			String product_name1=driver.findElement(By.cssSelector(".s-result-list.sg-row div:nth-child("+index+") div.a-section.a-spacing-medium div:nth-child(2) div:nth-child(2)>div>div>h2>a")).getText();
			if(product_name1.equals(product_name)) {
				driver.findElement(By.cssSelector(".s-result-list.sg-row div:nth-child("+index+") div.a-section.a-spacing-medium div:nth-child(2) div:nth-child(2)>div>div>h2>a")).click();
				Thread.sleep(2000);
				//driver.findElement(By.cssSelector(".s-result-list.sg-row div:nth-child("+index+") div.a-section.a-spacing-medium div:nth-child(2) div:nth-child(3)>div>div>h2>a")).click();
			}
		}}
		
		//@Test(priority=4)
		public void addtocart() {
			WebElement select=driver.findElement(By.cssSelector("id#native_dropdown_selected_size_name"));
		System.out.println(select.getAttribute("class"));
		//	Select s1=new Select(select);
//			s1.selectByValue("38 EU");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//		js.executeScript("window.scrollBy(0,1000)");
	


}
























//		int i=4;
//		int j=2;
// i++;


//	Base64.Encoder enc= Base64.getEncoder();
//	 String s="name";
//	byte [] z=s.getBytes();
//	System.out.println(enc.encodeToString(z));
//	  String str = enc.encodeToString("name".getBytes());  
//      System.out.println("Encoded string: "+str);




//		byte Arr1[]=enc.encode(Arr);
//		System.out.println(Arr1);
//		System.out.println("poiuihjj");




//	System.out.println(i--);
//		 HttpClient client = HttpClientBuilder.create().build();
//	        HttpGet request = new HttpGet("https://kodejava.org");
//
//	        try {
//	            HttpResponse response = cl-ient.execute(request);
//	            HttpEntity entity = response.getEntity();
//
//	            String content = EntityUtils.toString(entity);
//	            System.out.println(content);
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }


//		Scanner s=new Scanner(System.in);
//		System.out.print("plz enter value");
//		int i=s.nextInt();
//		for(int x=1;x<6;x++) {
//			
//			for(int j=1;j<6;j++) {
//				System.out.print("*");	
//				}
//			System.out.println(" ");
//			}
//	---------------------------------------------------------------------------	

//for(int x=1;x<6;x++) {
//			
//			for(int j=1;j<=x;j++) {
//			
//				System.out.print("*");	
//				}
//			System.out.println("");
//			
//			}
//---------------------------------------------------------------------		


//		for(int x=1;x<10;x++) {
//			  for(int j=10;j>=x;j--) 
//			  { 
//				System.out.print(" ");	
//			  }
//		    for(int k=1;k<=x;k++) {
//			  System.out.print("*");
//			  System.out.print(" ");
//		  }
//		  System.out.println("");
//		}

//-------------------------------------------------------------------------------------------
//		 Random rand = new Random();
//		 
//	        for(int j=1;j<=6;j++) {
//	        int rand_int1 = rand.nextInt(1000);
//	        
//	       System.out.println(rand_int1);
//	        }











//String a="Card Number:- 4604214442424304";
//		int k=987321;
//		     int a= k/10000;
//		     int b=k%10000;
//		
//		System.out.println(a);
//		System.out.println(b);


//long j=k;
//		String b="CVV:- 846";
//		String c="Credit Limit $100.00";
//		 String d=c.replaceAll("[^0-9]", "");
// System.out.println(k);
//		if(b.equalsIgnoreCase(a)) {
//			System.out.println("string found");
//		}


//		String a="Card Number4559214314864087";
//		 Matcher.m
//		 String res[]  = a.split(":-");
//		 System.out.println(res[0]);

//}

//@Test(groups={"car","scooter"})
//public void b() throws InterruptedException {
//	System.out.println("Test run  b");
//		System.setProperty("webdriver.chrome.driver", "D:\\selenium jar\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://www.guru99.com");
//		Thread.sleep(3000);
//}
//@Test (groups= {"car"})
//	public void a() {
//		int a = 0;
//		System.out.println(a);
//	}
//	//	@Test(groups={"scooter"})
//	public void c () {
//		System.out.println("test run c");
//	}
//	// @BeforeTest
//	public void vinay() {
//		System.out.println("Before test");
//	}
//	// @AfterTest
//	public void aftetest() {
//		System.out.println("after Test");
//	}
//	// @BeforeClass
//	public void bclass() {
//		System.out.println("before class");
//	}
//	//@AfterClass
//	public void afterclas() {
//		System.out.println("After class");
//	}
//	//	@AfterMethod
//	public void afterm() {
//		System.out.println("after Method is running");
//	}
//	//@BeforeMethod
//	public void bfm() {
//		System.out.println("Before Method");
//	}
//	// @ BeforeSuite
//	public void beforesuit() {
//		System.out.println("Before suit");
//	}

//}
