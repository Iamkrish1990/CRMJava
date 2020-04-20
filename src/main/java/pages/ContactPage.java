package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class ContactPage extends TestBase{
	
	
	@FindBy(xpath="//a[contains(text() , 'Contacts')]")
	WebElement lnkContact;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement btnSave;
	
	
	private static String prefixContactField= "//td/strong[contains(text() , '";
	
	private static String suffixContactField= "')]/parent::td/following-sibling::td/input[@type='text']";
	
	
	private static String prefixContactDropdown="//td/strong[contains(text() , '";
	
	private static String suffixContactDropdown="')]/parent::td/following-sibling::td/select";
	
	
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public By createXpathForContactFields(String identifierText)
	{
		return By.xpath(prefixContactField + identifierText + suffixContactField);
	}
	
	public By createXpathForContactDropdown(String identifierText)
	{
		return By.xpath(prefixContactDropdown + identifierText + suffixContactDropdown);
	}
	
	public void enterFieldValues(String fieldName, String value)
	{
		By xpath  = createXpathForContactFields(fieldName);
		driver.findElement(xpath).sendKeys(value);
	}
	
	public void enterContactInfo(String titleName, String fname, String lname, String company) {
		
		By dropDownXpath=createXpathForContactDropdown("Title");
		
		Select select = new Select(driver.findElement(dropDownXpath));
		select.selectByValue(titleName);
		enterFieldValues("First Name", fname);
		enterFieldValues("Last Name", lname);
		enterFieldValues("Company", company);
		btnSave.click();
		
		
	}
	
	
	
		
	
	

}
 