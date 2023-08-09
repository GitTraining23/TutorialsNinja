package com.tutninjaproj.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	// webelements are objects
	WebDriver driver;
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-password")
	private WebElement password;

	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginclick;

	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailpwordwarning;

	public loginPage(WebDriver driver)
	{
		this.driver=driver;//when we create object in the login class, the constructor will be called and get driver details from login page and assign in this page
		PageFactory.initElements(driver,this);// to over come stale element expression we are using pagefactory to intialize all elements
	}
	
	//Actions
	
	public void enteremail(String emailText) {
		email.sendKeys(emailText);
	}
	
	public void enterpassword(String pword) {
		password.sendKeys(pword);
	}
	
	
	public void login() 
	{
		loginclick.click();
		
	}
	public void LoginDetails(String emailText,String pword)
	{
		email.sendKeys(emailText);
		password.sendKeys(pword);
		loginclick.click();
	}
	
	public String emailpasswordwarning() {
		
		String emailpwwarning=emailpwordwarning.getText();
		return emailpwwarning;
		
	}

}
