package testScripts.Contact;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import testBase.TestBase;
import util.Utility;

public class CRM_R_1_1_Verify_Contact_Page extends TestBase{
	
	
	LoginPage login ;
	Utility util;
	
	@BeforeMethod
	public void setup()
	{
		initilization();
		login=new LoginPage();
		util=new Utility();
		
	}
	
	@Test
	public void execute()
	{
		test = report.createTest("Verify Contact Page");
		HomePage homepage =login.memberLogin(prop.getProperty("userName"), prop.getProperty("password"));
		util.switchToFrame();
		boolean flag = homepage.verifyUser();
		Assert.assertTrue(flag , "Expected Message is not shown");
		util.clickOnTab("Contacts");
		
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}

}
