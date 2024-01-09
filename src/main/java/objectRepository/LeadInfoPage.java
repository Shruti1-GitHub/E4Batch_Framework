package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement LeadheaderTxt;
	
	public LeadInfoPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadheaderTxt() {
		return LeadheaderTxt;
	}
	
	

}
