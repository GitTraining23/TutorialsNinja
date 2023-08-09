package com.tutninjaproj.qa.utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerClass implements ITestListener{

	
	ExtentReports extRepo;
	ExtentTest extentTest;
	String teststart;
	@Override
	public void onTestStart(ITestResult result) {
	 //teststart=result.getName();
		  extentTest = extRepo.createTest(result.getName());
		extentTest.log(Status.PASS, result.getName()+"started successfully");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		WebDriver driver=null;
		
	try {
		
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		//driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstanceName());
	} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
	 	String screenshotdetinationpath=utilities.screenshot(driver, result.getName());
	 	extentTest.addScreenCaptureFromPath(screenshotdetinationpath);
	 	extentTest.log(Status.FAIL, result.getName()+"got failed");
	 	extentTest.log(Status.INFO, result.getThrowable());
		

		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+"got skipped");
		

	}

	@Override
	public void onStart(ITestContext context) {
		 try {
			
			 extRepo = ExtendReports.generateReports();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//String teststart=context.getName();
		//System.out.println(teststart+"started successfully");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentTest.log(Status.INFO, teststart+"finished successfully");
		//System.out.println);
		extRepo.flush();
		String extentreportPath=System.getProperty("user.dir")+"\\test-output\\ExtentReport\\ExtentReport.html";
		File extentFile=new File(extentreportPath);
		try {
			Desktop.getDesktop().browse(extentFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
