package testScripts.Contact;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import extentReportListener.ExtentReporterNG;
import pages.ContactPage;
import pages.HomePage;
import pages.LoginPage;
import testBase.TestBase;
import util.ExcelUtil;
import util.Utility;

public class CRM_R_1_0_Enter_Contact_Details extends TestBase{
	
	LoginPage login ;
	Utility util;
	ContactPage contactpage;
	ExcelUtil excelutil;
	ExtentReporterNG extentTest;
		
	@BeforeMethod
	public void setUp()
	{
		initilization();
		login=new LoginPage();
		util=new Utility();
		contactpage = new ContactPage();
		excelutil=new ExcelUtil();
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object[][] data=null;
		try {
		String fullClassName=this.getClass().getName();
		String[] str = fullClassName.split("\\.");
		String classStr = str[2];
		data = ExcelUtil.getTestData(classStr);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return data;
	}
	
	@Test(dataProvider="getCRMTestData")
	public void executeTest(String title, String firstName, String lastName,String company)
	{
		test = report.createTest("Verify_filling_of_Contact");
		HomePage homepage =login.memberLogin(prop.getProperty("userName"), prop.getProperty("password"));
		util.switchToFrame();
		boolean flag = homepage.verifyUser();
		Assert.assertTrue(flag , "Expected Message is not shown");
		homepage.clickOnNewContactTab();
		contactpage.enterContactInfo(title, firstName, lastName, company);
		
		 
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
		
	}



}
