package OrganizationsTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import objectRepository.CreateNewOrganisation;
import objectRepository.HomePage;
import objectRepository.NewOrgInfo;
import objectRepository.OrganisationsPage;

@Listeners(genericUtilities.ListenersImplimentation.class)
public class TestCreateOrgRecord extends BaseClass {
	/*
	 * This Test is Creating new Organisation with Mandatory Details
	 */
	@Test(groups="RegressionSuite")
	public void CreateNewOrgWithGroupRadio() throws EncryptedDocumentException, IOException
	{
		ExcelUtility ex= new ExcelUtility();
		String OrgName = ex.ReadDataFromExcelFile("Organisations", 1, 2);
		
		HomePage hm= new HomePage(driver);
		hm.getOrganizationsLnk().click();
		
		OrganisationsPage op= new OrganisationsPage(driver);
		op.getOrganisationsLookupImg().click();
		
		CreateNewOrganisation co= new CreateNewOrganisation(driver);
		co.getOrgNameTxt().sendKeys(OrgName);
		co.getGroupRadio().click();
		co.getSaveBtn().click();
		
		NewOrgInfo no= new NewOrgInfo(driver);
				
		String orgheader = no.getOrgHeaderTxt().getText();
		AssertJUnit.assertTrue(orgheader.contains(OrgName));
		System.out.println(orgheader);
		
	}

}

