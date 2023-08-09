package DemoPurpose;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readfromexcel {

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub

		readfromexcel rd=new readfromexcel();
		rd.getTestDataFromExcel("Login");
	}

	public String[][] getTestDataFromExcel(String sheetName) throws IOException
	  {
		  
		  XSSFWorkbook wbook=null;
		   File f=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutninjaproj\\qa\\testdata\\tutninja.xlsx");
		   FileInputStream fis=new FileInputStream(f);
		   System.out.println(fis);
		   //Workbook wb=new WorkbookFactory(fis);
		   wbook=new XSSFWorkbook(fis);
		  System.out.println(sheetName);
		  XSSFSheet sheet=wbook.getSheet(sheetName);
		  System.out.println(sheet);

		  int rows=sheet.getLastRowNum();
		  System.out.println("rows"+rows);

		  int cols=sheet.getRow(0).getLastCellNum();
		  DataFormatter DF=new DataFormatter();
		  String testData[][]=new String[rows][cols];
		  for(int i=0;i<=rows;i++)
		  {
			  for(int j=0;j<cols;j++)
			  {
				  testData[i][j]=DF.formatCellValue(sheet.getRow(i).getCell(j));
				  System.out.println(testData[i][j]);
				  
			  }
				  
			  
		  }

			  return testData;
	  }
}
