package com.tutninjaproj.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	
	WebDriver driver;
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;//when we create object in the login class, the constructor will be called and get driver details from login page and assign in this page
		PageFactory.initElements(driver,this);// to over come stale element expression we are using pagefactory to intialize all elements
	}
	//
	@FindBy(xpath="//input[@name='search']")
	private WebElement schProduct;
	
	public void SearchProduct(String prodname)
	{
		schProduct.sendKeys(prodname);
		
	}
	
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	public void searchButton()
	{
		searchButton.click();
	}
	
	
	
	@FindBy(xpath="//input[@id=\"button-search\"]/following-sibling::p")
	private WebElement invalWarning;
	
	public String invalidWarningMsg()
	{
		String invalWarningMsg=invalWarning.getText();
		return invalWarningMsg;
	}
	
}
