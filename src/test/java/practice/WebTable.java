package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.HomePage;

public class WebTable extends BaseClass{
	
	@Test
	public  void WebTableTest()
	{
		HomePage hm= new HomePage(driver);
		hm.getContactLnk().click();
		 WebElement table = driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[*]/input[@name=\"selected_id\"]"));
		
		/*for(WebElement s : table)
		{
			
		}*/
		
	}

}
