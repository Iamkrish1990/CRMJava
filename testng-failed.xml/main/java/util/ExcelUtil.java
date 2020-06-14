package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import testBase.TestBase;

public class ExcelUtil extends TestBase{
	
	
	public static String userDirectory = System.getProperty("user.dir");
	
	 //Location of Test data excel file
    public static String testDataExcelPath =  userDirectory + "\\src\\test\\resources\\DataTables\\Contact.xlsx";
    
    static Workbook wb;
    static Sheet sheet;
    
    
    
    
    public static Object[][] getTestData(String sheetName)
    {
    	
    	FileInputStream fis =null;
    	try {
    		fis = new FileInputStream(testDataExcelPath);
    	}
    	catch(FileNotFoundException ex) {
    		ex.printStackTrace();
    	}
    	try {
    		wb=WorkbookFactory.create(fis);
    	}
    	catch(IllegalFormatException ex) {
    		ex.printStackTrace();
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}
    	sheet = wb.getSheet(sheetName);
    	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
    	for(int i=0;i<sheet.getLastRowNum();i++)
    	{
    		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
    		{
    			data[i][k] = sheet.getRow(i+1).getCell(k).toString();
    		}
    	}
    	return data;
    }
	
	

}
