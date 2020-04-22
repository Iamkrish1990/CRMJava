package testScripts.login;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import testBase.TestBase;
import util.Utility;

public class CRM_R_1_0_Verify_Login_Credential extends TestBase{
	
	
	/*public verifyLogin()
	{
		super();
	}*/
	
	
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
		
		HomePage homepage =login.memberLogin(prop.getProperty("userName"), prop.getProperty("password"));
		util.switchToFrame();
		log.info("frame switched");
		boolean flag = homepage.verifyUser();
		Assert.assertTrue(flag , "Expected Message is not shown");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}
	

}
