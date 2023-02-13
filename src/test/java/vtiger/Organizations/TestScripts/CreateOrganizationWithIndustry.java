package vtiger.Organizations.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClasss;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationsInfoPage;
import objectRepository.OrganizationsPage;

@Listeners(genericUtilities.ListnersImplementation.class)
public class CreateOrganizationWithIndustry extends BaseClasss 
{
	@Test(groups = "RegressionSuite")
	public void createOrgWithIndustryTest() throws EncryptedDocumentException, IOException
	{	
		String ORGNAME = eUtil.readDataFromExcelSheet("Organizations", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDataFromExcelSheet("Organizations", 4, 3);
		
		//Step 1: Click on organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		Reporter.log("Clicked on organizations link", true);
		
		//Step 2: Click on create organization lookup image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("Clicked on created organization lookup image",true);
		
		//Step 3: Create new organization with orgname and industry and click on save button
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);
		Reporter.log("Organization created with orgname and industry", true);
		
		//Step 4: Validation
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String orgHeader = oip.getOrganizationHeader();
		
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		Reporter.log(""+orgHeader+"===>PASS",true);
	}
}
