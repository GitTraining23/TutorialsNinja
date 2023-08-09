package com.tutninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutninja.qa.base.base;
import com.tutninjaproj.qa.Pages.SearchPage;

public class SearchProductTest extends base {
	
	
	public SearchProductTest()
	{
		super();//calling base class constructor //calling parent class constructor
	}
	public WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		SearchPage sp=new SearchPage(driver);
		driver=intializeBrowser(prop.getProperty("browsername"));
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
		
	}
	@Test(priority=1)
	public void searchAllreadyinProd()
	{
		
		
		SearchPage sp=new SearchPage(driver);
		sp.SearchProduct(dataprop.getProperty("prodname"));
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(dataprop.getProperty("prodname"));
		sp.searchButton();
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		
		String actualprod=driver.findElement(By.linkText(dataprop.getProperty("knownwarn"))).getText();
		Assert.assertEquals(actualprod,"HP LP30651","did not find correct match");
		//or
		//Assert.assertTrue(driver.findElement(By.linkText(dataprop.getProperty("knownwarn"))).isDisplayed());
		
	}
	@Test(priority=2,dependsOnMethods={"searchAllreadyinProd"})
	public void searchAllinvalidProd()
	{
		SearchPage sp=new SearchPage(driver);
		sp.SearchProduct(dataprop.getProperty("unknown"));
		sp.searchButton();
		
		//driver.findElement(By.xpath("//input[@name='search']")).sendKeys(dataprop.getProperty("unknown"));
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		//String invalidwarn=driver.findElement(By.xpath("//input[@id=\"button-search\"]/following-sibling::p")).getText();
		String invalidwarn=sp.invalidWarningMsg();
		Assert.assertEquals(invalidwarn,dataprop.getProperty("unknownwarn"),"not a valid message" );
	}
	
	

}
