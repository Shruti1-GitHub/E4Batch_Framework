package contactTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactPage;
import objectRepository.CreateNewContact;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.NewContactDetailPage;


@Listeners(genericUtilities.ListenersImplimentation.class)
public class TestCreateContact extends BaseClass {
	/*
	 * This Test is creating contact record with mandatory details only
	 */

@Test(groups="RegressionSuite")
public void createContactwithLastname() throws Throwable
	{
		// TODO Auto-generated method stub
		
		
		
		ExcelUtility ex= new ExcelUtility();
		String LASTNAME= ex.ReadDataFromExcelFile("Contact", 5, 2);
		
		HomePage hp= new HomePage(driver);
		hp.getContactLnk().click();
		
		ContactPage cp= new ContactPage(driver);
		cp.getPlusImg().click();
		
		
		CreateNewContact newcontact=new CreateNewContact(driver);
		newcontact.createContactRecord(LASTNAME);
		
		NewContactDetailPage contactinfo= new NewContactDetailPage(driver);
		String contactheader=contactinfo.captureHeaderTxt();
		
		Assert.assertTrue(contactheader.contains(LASTNAME));
		
		System.out.println(contactheader);
		
	
		
		
	}
}
