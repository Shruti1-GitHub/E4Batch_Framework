package genericUtilities;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	
	public PropertyFileUtility pUtil= new PropertyFileUtility();
	public JavaUtility jUtil= new JavaUtility();
	public SeleniumUtility selUtil= new SeleniumUtility();
	public WebDriver driver; 
	
	public static WebDriver sdriver;//for listener
	
	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
	public void dbConnection()
	{
		System.out.println("========DB Connection is succefull==========");
	}
	
	//@BeforeTest 
	//@Parameters("Browser")
	@BeforeClass(alwaysRun= true)
	public void bcconfig(/*String Browser*/) throws IOException
	{
		String url = pUtil.ReadDataFromPropertyFile("url");
		 driver= new EdgeDriver();
		
		/*if(Browser.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("Edge"))
		{
			driver= new EdgeDriver();
		}*/
		 
		 sdriver=driver;
		selUtil.maximizeWindow(driver);
		selUtil.addImplicitWait(driver);
		driver.get(url);
		System.out.println("========Browser lounched succefully==========");
		
	}
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		String Username = pUtil.ReadDataFromPropertyFile("username");
		String pass = pUtil.ReadDataFromPropertyFile("password");
		
		LoginPage lp= new LoginPage( driver);
		lp.loginToApp(Username, pass);
		System.out.println("========Login succefully==========");
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig()
	{
		HomePage hm= new HomePage(driver);
		hm.signOutApp(driver);
		System.out.println("========Logout succefully==========");
		
	}
	//@AfterTest
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("========browser closed successfully==========");
	}
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("========DB Connection is closed  succefully==========");
	}

}
