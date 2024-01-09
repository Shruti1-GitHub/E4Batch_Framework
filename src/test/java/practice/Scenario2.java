package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    WebDriver driver=new EdgeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
	    driver.get("http://localhost/index.php?module=Home&action=index&parenttab=My%20Home%20Page");
	   driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
	   driver.findElement(By.name("user_password")).sendKeys("admin");
	   driver.findElement(By.id("submitButton")).click();
	   
	   Actions action = new Actions(driver);

	   WebElement ele = driver.findElement(By.linkText("More"));
	   action.moveToElement(ele).perform();
	   driver.findElement(By.linkText("Campaigns")).click();
	   driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
	   driver.findElement(By.className("detailedViewTextBox")).sendKeys("Hulala");
	   driver.findElement(By.xpath("//input[@value=\"  Save  \"]")).click();
	   String Camp = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	   if(Camp.contains("Hulala"))
	   {
		   System.out.println("Scenario2 pass");
	   }
	   else
	   {
		   System.out.println("Fail");
	   }
	   
	   WebElement ele2 = driver.findElement(By.xpath("//img[@style=\"padding: 0px;padding-left:5px\"]"));
	   action.moveToElement(ele2).perform();
	   driver.findElement(By.linkText("Sign Out")).click();
	   
	   

	}

}
