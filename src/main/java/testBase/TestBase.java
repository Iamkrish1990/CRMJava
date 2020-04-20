package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import extentReportListener.ExtentReporting;
import util.Utility;
import util.WebEventListener;

public class TestBase {	
	protected static WebDriver driver;
	protected static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	//Create instance for Logger object
    public static Logger log = Logger.getLogger("devpinoyLogger");
    
    //get the reference of ExtentReports object to instantiate HTML reporting
   public static ExtentReports report=ExtentReporting.getExtentInstance();
    
    //indicate which test to include in report
    public static ExtentTest test;
	
	
	public TestBase()
	{
		try {
		prop=new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\config\\config.properties");
		prop.load(fis);
		}
		catch(FileNotFoundException ex)
		{
			ex.printStackTrace();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	
	public void initilization()
	{
		String browserName =prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Krishnendu PC\\Desktop\\SoftwareForAutomation\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
	
	

}
