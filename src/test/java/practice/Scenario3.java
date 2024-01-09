package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver=new EdgeDriver();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		    driver.get("http://localhost/index.php?module=Home&action=index&parenttab=My%20Home%20Page");
		   driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		   driver.findElement(By.name("user_password")).sendKeys("admin");
		   driver.findElement(By.id("submitButton")).click();
		   driver.findElement(By.linkText("Calendar")).click();
		   Actions action = new Actions(driver);

		   WebElement ele = driver.findElement(By.xpath("//td[@class=\"calAddButton\"]"));
		   action.moveToElement(ele).perform();
		   driver.findElement(By.linkText("Call")).click();
		   driver.findElement(By.xpath("//input[@name=\"subject\"]")).sendKeys("Marraige");
		   driver.findElement(By.name("eventsave")).click();
		   Alert al = driver.switchTo().alert();
		   String msg = al.getText();
		   
			System.out.println(al.getText());
			if(msg.equals("Start Date & Time should be greater than or equal to Current date & time for Activities with status as Planned"))
			   {
				   System.out.println("scenario3 Pass");
			   }
			else
			{
				System.out.println("Fail");
			}
			al.accept();
			
			System.out.println("Alert accepted succesfully");
			
			driver.findElement(By.xpath("//input[@value=\"Cancel\"]")).click();
			  WebElement ele2 = driver.findElement(By.xpath("//img[@style=\"padding: 0px;padding-left:5px\"]"));
			   action.moveToElement(ele2).perform();
			   driver.findElement(By.linkText("Sign Out")).click();
			   driver.close();
		   
		   
		   
	}

}
