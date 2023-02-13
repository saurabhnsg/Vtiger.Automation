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
import objectRepository.HomePage;

@Listeners(genericUtilities.ListnersImplementation.class)
public class CreateContact extends BaseClasss
{
	@Test(groups="SmokeSuite")
	public void createContactTest() throws EncryptedDocumentException, IOException
	{	
		String LASTNAME = eUtil.readDataFromExcelSheet("Contacts", 1, 2);
		
		
		//Step 1: Click on contacts link
		HomePage hp =  new HomePage(driver);
		hp.clickOnContactsLink();
		Reporter.log("Clicked on contacts link",true);
		
		//Step 2: Click on create contact lookup image
		ContactsPage cp= new ContactsPage(driver);
		cp.clickOnCreateContactLookupImg();
		Reporter.log("Clicked on create contact lookup image",true);
		
		//Step 3: Create contact with last name and save
		CreateNewContactPage cncp= new CreateNewContactPage(driver);
		cncp.createContact(LASTNAME);
		Reporter.log("Contact created with last name",true);
		
		//Step 4: Validation
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String conHeader = cip.getContactHeader();
		Assert.assertTrue(conHeader.contains(LASTNAME));
		Reporter.log(""+conHeader+"===>PASS",true);
	}
}
