package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumUtility {
	/**
	 * This Method will Maximise the Window 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimise the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will implicitly wait for 10 seconds for all WebElements to load  
	 * @param driver
	 */
		public void addImplicitWait(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
	/**
	 * This method will Explicitly wait until element to be visible
	 * @param driver
	 * @param ele
	 */
	
	public void waitforElementtobeVisible(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	/**
	 * This method will Explicitly wait until element to be Clickable
	 * @param driver
	 * @param ele
	 */
	
	public void waitForElementtobeClickable(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	/**
	 * This method will Explicitly wait until element to get Title
	 * @param driver
	 * @param value
	 */
	public void waitforElementtogetTitel(WebDriver driver,String value)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains(value));
	}
	/**
	 * This Methos will handle dropdown by index
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement ele,int val)
	{
		Select s= new Select(ele);
		s.selectByIndex(val);
	}
	/**
	 * This method will handle dropdown by value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement ele,String val)
	{
		Select s= new Select(ele);
		s.selectByValue(val);
	}
	/**
	 * This method will handle dropdown by visible text
	 * @param value
	 * @param element
	 */
	
	public void handleDropdown(String val,WebElement ele)
	{
		Select s= new Select(ele);
		s.selectByVisibleText(val);
	}
	/**
	 * This method will perform mouse hovering action on a Web Element
	 * @param driver
	 * @param ele
	 */
	public void mouseOverAction(WebDriver driver,WebElement ele)
	{
		Actions a= new Actions(driver);
		a.moveToElement(ele).perform();
	}
	/**
	 * This method will perform Right click action on a Web Element
	 * @param driver
	 * @param ele
	 */
	public void rightClickAction(WebDriver driver,WebElement ele)
	{
		Actions a= new Actions(driver);
		a.contextClick(ele).perform();
	}
	/**
	 * This method will perform Drag and Drop action on a Web Element
	 * @param driver
	 * @param ele1
	 * @param ele2
	 */
	public void dragAndDropAction(WebDriver driver,WebElement ele1,WebElement ele2)
	{
		Actions a= new Actions(driver);
		a.dragAndDrop(ele1, ele2).perform();
		
	}
	/**
	 * This method will perform Double Click action on a Web Element
	 * @param driver
	 * @param ele
	 */
	
	public void doubleClickAction(WebDriver driver,WebElement ele)
	{
		Actions a= new Actions(driver);
		a.doubleClick(ele).perform();
	}
	/**
	 * This method will perform Scroll up action on a Web page
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(0,500);", "");
	}
	/**
	 * This method will perform Scroll down action on a Web page
	 * @param driver
	 */
	public void scrollUp(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Window.scrollBy(0,-500);", "");
	}
	/**
	 * This method will accept the alert Popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	/**
	 *  This method will cancel the alert Popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will get the text of alert Popup
	 * @param driver
	 * @return
	 */
	public String getTextAlert(WebDriver driver)
	{
		String text = driver.switchTo().alert().getText();
		return text;
	}
	/**
	 * This method will switch the control to frame by index
	 * @param driver
	 * @param frameindex
	 */
	public void handleFrame(WebDriver driver,int frameindex)
	{
		driver.switchTo().frame(frameindex);
	}
	/**
	 * This method will switch the control to frame by Id or Name
	 * @param driver
	 * @param framenameID
	 */
	public void handleFrame(WebDriver driver,String framenameID)
	{
		driver.switchTo().frame(framenameID);
	}
	/**
	 * This method will switch the control to frame by WebElementyes
	 * 
	 * @param driver
	 * @param ele
	 */
	public void handleFrame(WebDriver driver,WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	/**
	 * This Method will Switch the control to default page
	 * @param driver
	 */
	public void switchToDefaultPage(WebDriver driver)
	{
		driver.switchTo().defaultContent();
		
	}
	/**
	 * This Method will Switch the control to parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
		
	}
	/**
	 * This method will take screenshot and store in Screenshots folder
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver,String ScreenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/"+ScreenShotName+".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();
		
	}
	/**
	 * This method will switch the control to required window based on tiltle 
	 * @param driver
	 * @param expectedTitle
	 */
	public void handleWindows(WebDriver driver,String expectedTitle)
	{
		
		Set<String> allWinIds = driver.getWindowHandles();
		for(String winid:allWinIds)
		{
			String actualTitel = driver.switchTo().window(winid).getTitle();
			if(actualTitel.contains(expectedTitle))
			{
				break;
			}
		}
	}
	
	
	
}
