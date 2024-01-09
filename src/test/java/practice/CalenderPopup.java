package practice;

import java.util.Date;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CalenderPopup {
	@Test
	public void calenderpopuptest()
	{
		WebDriver driver= new EdgeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath("(//p[text()=\"3\"])[2]")).click();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		//WebElement ele = driver.findElement(By.xpath("//div[text()=\"May 2024\"]"));
		
		//System.out.println(ele.getText());
		
		for(int i=0;i<3;i++)
		{
			
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		}
		
		String ele = driver.findElement(By.xpath("//div[@class=\"DayPicker-Months\"]/child::div/following-sibling::div/child::div[@class=\"DayPicker-Caption\"]/child::div")).getText();
		String month = "May";
		while(ele.equalsIgnoreCase(month))
		{
			
		}
		driver.findElement(By.xpath("(//p[text()='3'])[2]")).click();
		//driver.close();
		//driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		Date d= new Date();
		System.out.println(d.toString());
		String[] dt = d.toString().split(" ");
		
		String month1 = dt[1];
		
		String date1 = dt[2];
		System.out.println(month+","+date1);
		System.out.println(driver.findElement(By.xpath("//span[text()='Departure']")).getText());
		System.out.println(driver.findElement(By.xpath("//div[@class=\"DayPicker-Months\"]/child::div/following-sibling::div/child::div[@class=\"DayPicker-Caption\"]/child::div")).getText());
	}
	

}
