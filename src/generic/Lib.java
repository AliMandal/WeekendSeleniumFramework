package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Lib implements IAutoConstant {
	

	
	public static Workbook wb;
	public static String getCellValue(String sheet, int row, int column)
	{
		String getCellValue = "";
		
		try {
		 wb=WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
		getCellValue=	wb.getSheet(sheet).getRow(row).getCell(column).toString();
		} catch (Exception e)
		{
			
		}
		return getCellValue;
	
	
	}
	public static int getRowCount(String sheet)
	{
		int rowcount = 0;
		
		try {
		 wb=WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
		rowcount=	wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e)
		{
			
		}
		return rowcount;
	
	
	}
	
	public static String getPropertyValue(String key)
	{
		String propertyValue = "";
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(CONFIG_PATH));
			 propertyValue=prop.getProperty(key);
		}
		 catch (Exception e) {
			
		}
		
		return propertyValue;
	}
	
	public static void captureScreenShot(WebDriver driver, String testMethodName) 
	
	{
		
		try {
			Date d=new Date();
			String currentDate=d.toString().replaceAll(":", "_");
			TakesScreenshot ts=(TakesScreenshot) driver;
			File srcFile=ts.getScreenshotAs(OutputType.FILE);
			File destFile=new File(SNAPSHOT_PATH+testMethodName+"_"+currentDate+".png");
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {
			
			
		}
		
	}
	
	
	
	
	
	
}
