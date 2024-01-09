package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganisation {
	@FindBy(name="accountname")
	private WebElement OrgNameTxt;
	
	@FindBy(xpath="//input[@name='assigntype']/following-sibling::input")
	private WebElement GroupRadio;
	
	@FindBy(xpath="(//input[@value='  Save  '])[1]")
	private WebElement SaveBtn;
	
	public CreateNewOrganisation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameTxt() {
		return OrgNameTxt;
	}

	public WebElement getGroupRadio() {
		return GroupRadio;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	
	
	

}
