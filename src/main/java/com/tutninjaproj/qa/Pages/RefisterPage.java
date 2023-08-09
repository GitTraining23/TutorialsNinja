package com.tutninjaproj.qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RefisterPage {
	
	WebDriver driver;
	@FindBy(id="input-firstname")
	private WebElement fname;
	
	@FindBy(id="input-lastname")
	private WebElement lname;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@name='telephone']")
	private WebElement telNumber;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement conpassword;
	
	
	@FindBy(xpath="//input[@name='newsletter'][@value='0']")
	private WebElement nnewsLetter;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement ynewsLetter;
	
	@FindBy(xpath="//input[@name='agree'][@value='1']")
	private WebElement selAgree;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement Submit;
	

	@FindBy(xpath=("//div[contains(@class,'alert-dismissible')]"))
	private WebElement emailpwordwarning;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement RegMessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement fnameWarning;
	
	public String fnameWarningMsg()
	{
		String fnameMsg=fnameWarning.getText();
		return fnameMsg;
	}
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement TelWarning;
	
	public String TelWarningMsg()
	{
		String telphoneMsg=TelWarning.getText();
		return telphoneMsg;
	}
	
	public String RegisterationMsg()
	{
		String RegMsg=RegMessage.getText();
		return RegMsg;
	}

	public RefisterPage(WebDriver driver)
	{
		this.driver=driver;//when we create object in the login class, the constructor will be called and get driver details from login page and assign in this page
		PageFactory.initElements(driver,this);// to over come stale element expression we are using pagefactory to intialize all elements
	}
	
	
   public void ClickSubmit()
   {
	   Submit.click();
   }
   
	public void RegwithMandatoryfields(String firstname, String lastname,String regemail,String  telphonenum,String password1,String confirmpassword)
	{
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		email.sendKeys(regemail);
		telNumber.sendKeys(telphonenum);
		password.sendKeys(password1);
		conpassword.sendKeys(confirmpassword);
		nnewsLetter.click();
		selAgree.click();
		Submit.click();


	}
	public void RegawithAllFields(String firstname, String lastname,String regemail,String  telphonenum,String password1,String confirmpassword)
	{
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		email.sendKeys(regemail);
		telNumber.sendKeys(telphonenum);
		password.sendKeys(password1);
		conpassword.sendKeys(confirmpassword);
		ynewsLetter.click();
		selAgree.click();
		Submit.click();


	}
	public void RegawithRegisterEmail(String firstname, String lastname,String regemail,String  telphonenum,String password1,String confirmpassword)
	{
		fname.sendKeys(firstname);
		lname.sendKeys(lastname);
		email.sendKeys(regemail);
		telNumber.sendKeys(telphonenum);
		password.sendKeys(password1);
		conpassword.sendKeys(confirmpassword);
		ynewsLetter.click();
		selAgree.click();
		Submit.click();


	}
	
	
}