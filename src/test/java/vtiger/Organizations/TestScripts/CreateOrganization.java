package vtiger.Organizations.TestScripts;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.BaseClasss;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationsInfoPage;
import objectRepository.OrganizationsPage;

@Listeners(genericUtilities.ListnersImplementation.class)
public class CreateOrganization extends BaseClasss
{
	@Test(groups = "SmokeSuite")
	public void createOrgWithDDTTest() throws EncryptedDocumentException, IOException 
	{
		String ORGNAME = eUtil.readDataFromExcelSheet("Organizations", 1, 2)+jUtil.getRandomNumber();
		
		//Step 4: Click on organizations module
		HomePage hp= new HomePage(driver);
		hp.clickOnOrganizationsLink();
		Reporter.log("Clicked on organizations link",true);
		
		//Step 5: Click on create organization button
		OrganizationsPage op= new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("Clicked on organizations lookup image",true);
		
		//Step 6: Create organization with orgname & click on save button
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(ORGNAME);
		Reporter.log("Organization created with orgname",true);
		
		//Step 7: Validate
		OrganizationsInfoPage oip= new OrganizationsInfoPage(driver);
		String orgHeader =oip.getOrganizationHeader();
		
		Assert.assertTrue(orgHeader.contains(orgHeader));
		Reporter.log(""+orgHeader+"===>PASS",true);
		
	}
}
