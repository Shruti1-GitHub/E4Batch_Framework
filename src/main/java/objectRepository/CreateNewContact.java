package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContact extends SeleniumUtility {

	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(name="leadsource")
	private WebElement leadSourcedd;
	
	public WebElement getLeadSourcedd() {
		return leadSourcedd;
	}


	public CreateNewContact(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createContactRecord(String LASTNAME)
	{
		
		lastnameEdt.sendKeys(LASTNAME);
		saveBtn.click();
	}
	public void createContactRecord(String LASTNAME,String LeadSourse)
	{
		
		lastnameEdt.sendKeys(LASTNAME);
		handleDropdown(leadSourcedd,LeadSourse);
		saveBtn.click();
	}
}
