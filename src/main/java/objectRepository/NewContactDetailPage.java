package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContactDetailPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeaderTxt;
	
	public NewContactDetailPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderTxt() {
		return contactHeaderTxt;
	}
	
	public String captureHeaderTxt()
	{
		String headerTxt= contactHeaderTxt.getText();
		
		return headerTxt;
		 
	}	

}
