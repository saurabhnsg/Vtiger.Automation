package vtiger.Contacts.TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClasss;
import objectRepository.ContactsInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationsInfoPage;
import objectRepository.OrganizationsPage;

@Listeners(genericUtilities.ListnersImplementation.class)
public class CreateContactWithOrganization extends BaseClasss
{
	@Test(groups="SmokeSuite")
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException 
	{	
		String ORGNAME = eUtil.readDataFromExcelSheet("Organizations", 1, 2)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 1, 2);
		
		//Step 1: Click on organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		Reporter.log("Clicked on organizations link",true);
		
		//Step 2: Click on create organizaion lookup image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("Clicked on create organization lookup image",true);
		
		//Step 3: Create organization and save
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		Reporter.log("Organization created",true);
		
		//Step 4: Validation
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String orgHeader = oip.getOrganizationHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		Reporter.log(""+orgHeader+"===>Organization created",true);
		
		//Step 5: Click on contacts link
		hp.clickOnContactsLink();
		Reporter.log("Clicked on contacts link",true);
		
		//Step 6: Click on create contact lookup image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookupImg();
		Reporter.log("Clicked on created contact lookup image",true);
		
		//Step 7: Create contact with lastname & orgname & save
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(LASTNAME,ORGNAME,driver);
		Reporter.log("Contact created with lastname & orgname",true);
		
		//Step 8: Validate
		ContactsInfoPage cip= new ContactsInfoPage(driver);
		String conHeader = cip.getContactHeader();
		Assert.assertTrue(conHeader.contains(LASTNAME));
		Reporter.log(""+conHeader+"===>PASS",true);
	}
}
