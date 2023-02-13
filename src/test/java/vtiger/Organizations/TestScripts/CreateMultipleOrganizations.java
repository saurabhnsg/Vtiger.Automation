package vtiger.Organizations.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClasss;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationsInfoPage;
import objectRepository.OrganizationsPage;

@Listeners(genericUtilities.ListnersImplementation.class)
public class CreateMultipleOrganizations extends BaseClasss
{
	@Test(dataProvider = "OrgNames")
	public void createMultipleOrgTest(String ORG, String Industry)
	{
		String ORGNAME = ORG + jUtil.getRandomNumber();
		
		//Step 1: Click on homepage link
		HomePage hp= new HomePage(driver);
		hp.clickOnOrganizationsLink();
		Reporter.log("Clicked on homepage link",true);
		
		//Step 2: Click on create organization lookup image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("Clicked on create organization lookup image",true);
		
		//Step 3: Create organization with orgname & industry
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, Industry);
		Reporter.log("Organization created with orgname & industry",true);
		
		//Step 4: Validate
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String orgHeader = oip.getOrganizationHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		Reporter.log(""+orgHeader+"===>PASS",true);
	}
	
	@DataProvider(name= "OrgNames")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eUtil.readMultipleDataFromExcelSheet("MultipleOrg");
		return data;
	}
}
