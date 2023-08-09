package com.tutninja.qa.testcases;



import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutninja.qa.base.base;
import com.tutninjaproj.qa.Pages.AccountPage;
import com.tutninjaproj.qa.Pages.HomePage;
import com.tutninjaproj.qa.Pages.loginPage;
import com.tutninjaproj.qa.utils.utilities;

public class LoginTest extends base {
	
	public WebDriver driver;

	loginPage lpage;

	public LoginTest()
			{
				super();//calling base class constructor //calling parent class constructor
			}
	
	
	
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
		
	}
	
	@BeforeMethod
	public void setup()
	{
	
		driver=intializeBrowser(prop.getProperty("browsername"));
		HomePage hp=new HomePage(driver);
		hp.MyAccountDropMenu();
		hp.SelLogin();
		
	}
	
@Test(priority=2)
public void verifyLoginWithInvalidcredentials() throws InterruptedException
{
	lpage=new loginPage(driver);
	lpage.LoginDetails(utilities.generateEmailTimeStamp(),"12345" );
	 
	 Assert.assertTrue(lpage.emailpasswordwarning().contains(dataprop.getProperty("emailpasswordwarn")),"could not find");
	System.out.println("warning message shown");
	
	Thread.sleep(2000);
	 driver.quit();

}
@Test(priority=3)
public void verifyLoginWithInvalidPassword()
{
	
	lpage=new loginPage(driver);
	lpage.LoginDetails(prop.getProperty("validemail"),"12345" );
	 Assert.assertTrue(lpage.emailpasswordwarning().contains(dataprop.getProperty("emailpasswordwarn")),"could not find");

	System.out.println("warning message shown");
	 
	 driver.quit();

}
@Test(priority=4)
public void verifyLoginWithInvalidEmail()
{
	lpage=new loginPage(driver);
	lpage.LoginDetails(utilities.generateEmailTimeStamp(), prop.getProperty("validpassword"));
	 Assert.assertTrue(lpage.emailpasswordwarning().contains(dataprop.getProperty("emailpasswordwarn")),"could not find");
	System.out.println("warning message shown");
	 
	 driver.quit();

}
@Test(priority=5)
public void verifyLoginWithNovalues()
{
 
	lpage=new loginPage(driver);
	lpage.login();
	 Assert.assertTrue(lpage.emailpasswordwarning().contains(dataprop.getProperty("emailpasswordwarn")),"could not find");
 	 
	System.out.println("warning message shown");
	 
	 driver.quit();

}



@Test(priority=1)
public void verifyLoginWithvalidcredentials()
{
	lpage=new loginPage(driver);
	lpage.LoginDetails(prop.getProperty("validemail"),prop.getProperty("validpassword") );
	AccountPage ap=new AccountPage(driver);
	 Assert.assertTrue(ap.EditInfoDisplay()); 	
	driver.quit();

}

@DataProvider(name="validcredentialSupplier")
public Object[][] getData() throws IOException 
{
	
	Object[][] data=utilities.getTestDataFromExcel("Login");
	return data;
}
//@Test(priority=6,dataProvider="validcredentialSupplier")
public void verifyLoginWithvalidcredentials1(String email,String password)
{
 
	 driver.findElement(By.id("input-email")).sendKeys(email);
	 driver.findElement(By.id("input-password")).sendKeys(password);

	 //driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpassword"));
	 driver.findElement(By.xpath("//input[@value='Login']")).click();
	 Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	 	 driver.quit();

}


}