package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewOrgInfo {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderTxt;

	public NewOrgInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderTxt() {
		return OrgHeaderTxt;
	}
	
	
}
