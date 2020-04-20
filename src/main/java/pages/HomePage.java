package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePage extends TestBase{
	
	
	//String identifierText;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[contains(text(), 'Demo User')]")
	WebElement txtLogin;
	
	@FindBy(xpath="//frame[@name='mainpanel']")
	WebElement frameUser;
	
	
	@FindBy(xpath="//li/a[contains(text() , 'Home')]")
	WebElement homeTab;
	
	@FindBy(xpath="//a[contains(text() , 'Contacts')]")
	WebElement lnkContact;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement lnkNewContact;
	
	public boolean verifyUser()
	{
		
		boolean flag = txtLogin.isDisplayed();
		return flag;
	}
	
	
	public void switchToFrame() {
		
		driver.switchTo().frame(frameUser);
	}
	
	 public void clickOnNewContactTab() {
		
		Actions action =new Actions(driver);
		action.moveToElement(lnkContact).build().perform();
		lnkNewContact.click();
	}

}
