package com.tutninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutninjaproj.qa.utils.utilities;

public class base {
	public WebDriver driver;
	public Properties prop;
	public Properties dataprop;

	
	public base() 
	{
	    prop=new Properties();
	    	    dataprop=new Properties();
	    		File dataf=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutninjaproj\\qa\\testdata\\testdata.properties");

	    	    //File dataf=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutninjaproj\\qa\\tetdata\\testdata.properties");
	    try {
	    FileInputStream datafis=new FileInputStream(dataf);
	    dataprop.load(datafis);
	    }catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	
		File f1=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutninjaproj\\qa\\configfiles\\config.properties");
		try {
		FileInputStream fis=new FileInputStream(f1);
		prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public WebDriver intializeBrowser(String browserName)
	{
		if (browserName.equalsIgnoreCase("chrome"))
				{
			
						driver=new ChromeDriver();
				}else if (browserName.equalsIgnoreCase("firefox"))
						{
					
					driver=new FirefoxDriver();
			}else if (browserName.equalsIgnoreCase("edge"))
					{
				
				driver=new EdgeDriver();
		}
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.IMPLICIT_WAIT));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.PAGE_LOAD_WAIT));
		
		 driver.get(prop.getProperty("url"));
		
		return driver;	
		
	}
	

}
