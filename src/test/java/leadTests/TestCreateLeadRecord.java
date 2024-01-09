package leadTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import objectRepository.CreateNewLeadsPage;
import objectRepository.HomePage;
import objectRepository.LeadInfoPage;
import objectRepository.LeadsPage;

@Listeners(genericUtilities.ListenersImplimentation.class)
public class TestCreateLeadRecord extends BaseClass {
	
	/*
	 * This Test is creating new Lead record with Mandatory Details
	 */
	@Test(groups="SmokeSuite")
	public void CreateLeadWithMandDeatails() throws EncryptedDocumentException, IOException
	{
	
		ExcelUtility ex= new ExcelUtility();
		String Lastname = ex.ReadDataFromExcelFile("Contact", 8, 2);
		String Company=ex.ReadDataFromExcelFile("Contact", 8, 3);
		
		HomePage hm= new HomePage(driver);
		hm.getLeadsLnk().click();
		
		LeadsPage lp= new LeadsPage(driver);
		lp.getLeadsLookupImg().click();
		
		CreateNewLeadsPage cp= new CreateNewLeadsPage(driver);
		cp.getLastnameTxt().sendKeys(Lastname);
		cp.getCompanyTxt().sendKeys(Company);
		cp.getSaveBtn().click();
		
		
		LeadInfoPage Linfo= new LeadInfoPage(driver);
		String Leadheader = Linfo.getLeadheaderTxt().getText();
		Assert.assertTrue(Leadheader.contains(Lastname));
		System.out.println(Leadheader);
		
	
	}

}
