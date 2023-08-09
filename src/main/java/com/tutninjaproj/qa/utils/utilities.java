package com.tutninjaproj.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utilities {
	
	public static final int IMPLICIT_WAIT=20;
	public static final int PAGE_LOAD_WAIT=20;

	public static String generateEmailTimeStamp() {
		Date dd = new Date();
	  String date1=dd.toString().replace(" ","_" ).replace(":","_");
	  String email="asam"+date1+"@gmail.com";
	  //return "akiksam"+date1+"@gmail.com";//you can directly pass the value like this
	  return email;
	  
	  
	}
	public static Object[][] getTestDataFromExcel(String sheetName) 
	  {
	
		   File f=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutninjaproj\\qa\\testdata\\tutninja.xlsx");
		   XSSFWorkbook wbook=null;
		   try
		   {
			   FileInputStream fis=new FileInputStream(f);
		   
		    wbook=new XSSFWorkbook(fis);
		   }catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   System.out.println(wbook);
		   System.out.println(sheetName);

		  XSSFSheet sheet1=wbook.getSheet(sheetName);
		  int rows=sheet1.getLastRowNum();
		  int cols=sheet1.getRow(0).getLastCellNum();
		  //DataFormatter DF=new DataFormatter();
		  Object[][] testData=new Object[rows][cols];
		  for(int i=0;i<rows;i++)
		  {
			  XSSFRow row=sheet1.getRow(i+1);
			  for(int j=0;j<cols;j++)
			  {
				 
				  XSSFCell cell = row.getCell(j);
				  CellType cellType = cell.getCellType();
				  switch(cellType)
				  {
				  case STRING:
					  testData[i][j]=cell.getStringCellValue();
					  break;
				  case NUMERIC:
					  testData[i][j]=Integer.toString((int)cell.getNumericCellValue());
					  break;
				  case BOOLEAN:
					  testData[i][j]=cell.getBooleanCellValue();
					  break;
				  
				  }
			  }
				  
			  
		  }

			  return testData;
	  }
	  
	public static String screenshot(WebDriver driver,String testname) {
		File srcscreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 	String screenshotdetination=System.getProperty("user.dir")+"\\Screenshot"+testname+".png";
	 	try {
			FileHandler.copy(srcscreenshot,new File(screenshotdetination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 	return screenshotdetination;
	}
	
}
