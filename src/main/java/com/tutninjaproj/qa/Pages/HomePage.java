package com.tutninjaproj.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement MyAccountDropMenu;
	
	
	@FindBy(linkText="Login")
	private WebElement SelLogin;
	
	@FindBy(linkText="Register")
	private WebElement SelRegister;
	 public HomePage(WebDriver driver)
	 {
		 this.driver =driver;
		 PageFactory.initElements(driver,this);// this means this.HomePage
	 }
	 
	
	public void MyAccountDropMenu() {
		MyAccountDropMenu.click();
		
	}

	public void SelLogin() {
		SelLogin.click();
		
	}
	public void selectRegister() {
		SelRegister.click();
		
	}
	

}




