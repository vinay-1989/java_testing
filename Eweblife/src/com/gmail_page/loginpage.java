package com.gmail_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class loginpage {
	//in this login page we will capture only the locator by using the "FindBy" annotation and "How class".

	WebDriver drive;
	
	public loginpage(WebDriver local_driver) {
		this.drive=local_driver;
		
	}
	
	// using find method
	@FindBy(id="txtName") 
	@CacheLookup
	WebElement username;
	
	
	//standard approach using How class
	@FindBy(how=How.ID,using="Password")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.CSS,using="body > form > div:nth-child(2) > div > div > div > div:nth-child(6) > input")
	@CacheLookup
	WebElement signin_button;
	
	public void pass_locator(String uid, String pass) {
		username.sendKeys(uid);
		password.sendKeys(pass);
		signin_button.click();
	}

}
