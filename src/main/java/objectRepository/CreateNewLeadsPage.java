package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadsPage {
	
	@FindBy(name="lastname")
	private WebElement LastnameTxt;
	
	@FindBy(name="company")
	private WebElement CompanyTxt;
	
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement SaveBtn;
	
	
	
	public CreateNewLeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnameTxt() {
		return LastnameTxt;
	}

	public WebElement getCompanyTxt() {
		return CompanyTxt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	
	


}
