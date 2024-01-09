package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility{

	
	@FindBy(linkText="Contacts")
	private WebElement contactLnk;
	
	@FindBy(linkText="Calendar")
	private WebElement calendarLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;
	
	


	@FindBy(linkText="Leads")
	private WebElement LeadsLnk;
	
	@FindBy(xpath="//img[@style='padding: 0px;padding-left:5px']")
	private WebElement userImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getCalendarLnk() {
		return calendarLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getLeadsLnk() {
		return LeadsLnk;
	}

	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getUserImg() {
		return userImg;
	}



	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	
	public void signOutApp(WebDriver driver)
	{
		mouseOverAction(driver,userImg);
		SignOutLnk.click();
	}
	
	
}
