package com.tutninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutninja.qa.base.base;
import com.tutninjaproj.qa.Pages.HomePage;
import com.tutninjaproj.qa.Pages.RefisterPage;
import com.tutninjaproj.qa.utils.utilities;


public class RegisterTest extends base {
	RefisterPage rp;
	HomePage hp;
	public RegisterTest()
	{
		super();//calling base class constructor //calling parent class constructor
	}
	 public WebDriver driver;
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	@BeforeMethod
	public void setup()
	{
		driver=intializeBrowser(prop.getProperty("browsername"));
		HomePage hp=new HomePage(driver);
		hp.MyAccountDropMenu();
		hp.selectRegister();
		
	}
	
	 @Test(priority=1)
	public void RegisterwithMantatoryDetails() {
	   
		 rp=new RefisterPage(driver);
		 rp.RegwithMandatoryfields(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"),utilities.generateEmailTimeStamp(),dataprop.getProperty("phone"),"12347","12347");

		 String RegMessage1=rp.RegisterationMsg();
	 
    Assert.assertEquals(RegMessage1, dataprop.getProperty("successmsgforRegist"),"account successpage is not created");	 

	 
	}
	 @Test(priority=2)
	 public void RegisterWithAlldetails()
	 {
		 
		 rp=new RefisterPage(driver);
		 rp.RegawithAllFields(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"),utilities.generateEmailTimeStamp(),dataprop.getProperty("phone"),"12347","12347");
		  String RegMessage1=rp.RegisterationMsg();
	    Assert.assertEquals(RegMessage1,dataprop.getProperty("successmsgforRegist"),"account successpage is not created");	 
		 
	 }
	 
	 @Test(priority=3)
	 public void RegisterwithAlreadyregisteredAcc()
	 {
		
		 rp=new RefisterPage(driver);
		 //rp.RegawithRegisterEmail(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"),prop.getProperty("validemail"),dataprop.getProperty("phone"),prop.getProperty("validpassword"),prop.getProperty("validpassword"));
		 rp.RegwithMandatoryfields(dataprop.getProperty("firstname"), dataprop.getProperty("lastname"),prop.getProperty("validemail"),dataprop.getProperty("phone"),prop.getProperty("validpassword"),prop.getProperty("validpassword"));

		 
		 		 String AcutalwarnMess=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();//div class finds few lines of message
		 Assert.assertTrue(AcutalwarnMess.contains(dataprop.getProperty("warningemail")));
	 
	 }
	 
	 @Test(priority=4)
	 public void RegisterwithoutFillingDet()
	 {
		  rp=new RefisterPage(driver);
		 rp.ClickSubmit();
		 String fnamewarningmsg=rp.fnameWarningMsg();
		 		 Assert.assertEquals(fnamewarningmsg,dataprop.getProperty("fnamewrning"));
		 String TelPhoneWarning=rp.TelWarningMsg();
		 Assert.assertEquals(TelPhoneWarning, dataprop.getProperty("phonewarning"),"warning message didnot match");
	 }
	 

}
