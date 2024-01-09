package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement LeadsLookupImg;
	
	
	public LeadsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getLeadsLookupImg() {
		return LeadsLookupImg;
	}
	
	
}
