package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.selenium.TestBase;


public class Utility extends TestBase{
	
	
	public Utility() {
		
		PageFactory.initElements(driver, this);
	}

		public static long PAGE_LOAD_TIMEOUT=20;
		
		public static String preFixTab="//a[contains(text() , '";
		
		
		public static String suffixTab = "')]";
		
		
		@FindBy(xpath="//frame[@name='mainpanel']")
		WebElement frameUser;
		
		public void switchToFrame() {
			
			driver.switchTo().frame(frameUser);
		}
		
		public static By createXpathForTab(String identifierText) {
			
			return By.xpath(preFixTab + identifierText + suffixTab);
		}
		
		public void clickOnTab(String identiFierText)
		{
			By tab=createXpathForTab(identiFierText);
			driver.findElement(tab).click();
		}
		
		
		public static String TakeScreenshot(String screenShotName) throws IOException{
			
			 //create a string variable which will be unique always
	        String df = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
	        
	        //create object variable of TakeScreenshot class  
	        TakesScreenshot ts = (TakesScreenshot)driver;
	        
	        //create File object variable which holds the screen shot reference 
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        
	        //store the screen shot path in path variable. Here we are storing the screenshots under screenshots folder 
	        String path = System.getProperty("user.dir") + "\\test-output\\screenshots3\\" + screenShotName + df + ".jpeg";
	        
	        //create another File object variable which points(refer) to the above stored path variable
	        File destination = new File(path);
	        
	        //use FileUtils class method to save the screen shot at desired path
	        FileUtils.copyFile(source, destination);
	        
	        //return the path where the screen shot is saved 
	        return path;
		}
		
		
}
