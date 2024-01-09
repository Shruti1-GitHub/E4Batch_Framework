package practice;

import java.io.FileInputStream;
import java.time.Duration;

import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactPage;
import objectRepository.CreateNewContact;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.NewContactDetailPage;

public class Scenario1 {

  public static void main(String[] args) throws Throwable {
    // TODO Auto-generated method stub
	  
	  //read data from property file
	 /* FileInputStream fis= new FileInputStream("./src/test/resources/CommonData.properties");
	  Properties p =new Properties();
	  p.load(fis);*/
	  
	  //read data from Excel file
	/*  FileInputStream fis1= new FileInputStream("./src/test/resources/TestData1.xlsx");
	  Workbook wb= WorkbookFactory.create(fis1);*/
	  // String LASTNAME = wb.getSheet("Contact").getRow(5).getCell(2).getStringCellValue();
	  	PropertyFileUtility pUtility= new PropertyFileUtility();
		String URL = pUtility.ReadDataFromPropertyFile("url");
		String USERNAME = pUtility.ReadDataFromPropertyFile("username");
		String PASSWORD = pUtility.ReadDataFromPropertyFile("password");
	  	ExcelUtility excel= new ExcelUtility();
	  	SeleniumUtility selutil=new SeleniumUtility();
		String LASTNAME=excel.ReadDataFromExcelFile("Contact", 5, 1);
		
		
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get(URL);
		
		LoginPage lp= new LoginPage(driver);
		HomePage hm=new HomePage(driver);
		ContactPage cp=new ContactPage(driver);
		CreateNewContact cnew=new CreateNewContact(driver);
		NewContactDetailPage contactinfo= new NewContactDetailPage(driver);
    lp.loginToApp(USERNAME, PASSWORD);
    hm.getContactLnk().click();
    cp.getPlusImg().click();
    cnew.createContactRecord(LASTNAME);
    
  // driver.findElement(By.xpath("//a[text()='Contacts']")).click();
   /*driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
   driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
  
   driver.findElement(By.xpath("//input[@type='submit']")).click();*/
  // String Contact = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
    String contactinfonew = contactinfo.getContactHeaderTxt().getText();
   if(contactinfonew.contains(LASTNAME))
   {
	   System.out.println(contactinfonew+":=Scenario Pass");
   }
   else
   {
	   System.out.println("Fail");
   }
   
   
 
   //Actions action = new Actions(driver);

   WebElement ele = driver.findElement(By.xpath("//img[@style=\"padding: 0px;padding-left:5px\"]"));
  // action.moveToElement(ele).perform();
   selutil.mouseOverAction(driver,ele);
   driver.findElement(By.linkText("Sign Out")).click();
   
  /* Actions action = new Actions(driver);
   WebElement element = driver.findElement(By.xpath("//img[@onclick=\"fnvshobj(this,'addEvent'); gshow('addEvent','Call','2023-11-28','2023-11-28','08','00','am','09','00','am','hourview','event')\"]"));
   action.moveToElement(element);
   driver.findElement(By.xpath("//img[@onclick=\"fnvshobj(this,'addEvent'); gshow('addEvent','Call','2023-11-28','2023-11-28','08','00','am','09','00','am','hourview','event')\"]")).click();*/
  }

}