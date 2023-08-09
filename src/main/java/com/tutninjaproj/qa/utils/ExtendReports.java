package com.tutninjaproj.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReports {

	public static ExtentReports generateReports() throws IOException
	{
		ExtentReports er=new ExtentReports();
		File erf = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\ExtentReport.html");
		ExtentSparkReporter SparkReporter=new ExtentSparkReporter(erf);
		SparkReporter.config().setTheme(Theme.DARK);
		SparkReporter.config().setReportName("Tutorialsninja");
		SparkReporter.config().setDocumentTitle("TN Automation Report");
		SparkReporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");
		er.attachReporter(SparkReporter);
		Properties configprop=new Properties();
		File f=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutninjaproj\\qa\\configfiles\\config.properties");
		FileInputStream fis=new FileInputStream(f);
		configprop.load(fis);
		er.setSystemInfo("ApplicationURL", configprop.getProperty("url"));
		er.setSystemInfo("BrowserName", configprop.getProperty("browsername"));
		er.setSystemInfo("osname",(System.getProperty("os.name")));
		er.setSystemInfo("username",(System.getProperty("user.name")));
		er.setSystemInfo("java version",(System.getProperty("java.version")));

		//System.out.println(System.getProperty("user.name"));
		//System.out.println(System.getProperty("java.version"));
         return er;

		
	}	
	
}
