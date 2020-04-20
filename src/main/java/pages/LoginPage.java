package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class LoginPage extends TestBase{
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(name="username")
	WebElement txtUserName;
	
	@FindBy(name="password")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	public HomePage memberLogin(String userName,String password) {
		
		txtUserName.sendKeys(userName);
		txtPassword.sendKeys(password);
		btnLogin.click();
		
		return new HomePage();
		
		
	}
	
	public String verifyLoginTitle()
	{
		return driver.getTitle();
	}

}
