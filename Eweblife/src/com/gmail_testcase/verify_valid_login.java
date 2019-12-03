package com.gmail_testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.gmail_page.loginpage;

import helper.Browserfactory;

public class verify_valid_login {
	@Test
	public void valid_user() {
		// start the browser
		WebDriver driver=Browserfactory.startBrowser("chrome", "http://vinay.com/");
		
		// create page object using pageFactory
		loginpage Lo_page=PageFactory.initElements(driver, loginpage.class);
		
		//call the method
		Lo_page.pass_locator("vinay", "1234");
		
		
		
	}
	

}
