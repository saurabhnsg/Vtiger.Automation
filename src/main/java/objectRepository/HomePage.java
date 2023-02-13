package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;


public class HomePage extends WebDriverUtility
{	
	//Declaration
	@FindBy (xpath= "//a[text()='Organizations']")
	private WebElement OrganizationLnk;
	
	@FindBy (xpath= "//a[text()='Contacts']")
	private WebElement ContactsLnk;
	
	@FindBy (xpath= "//a[text()='Opportunities']")
	private WebElement OpportunitiesLnk;
	
	@FindBy (xpath= "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy (xpath= "//a[text()='Sign Out']")
	private WebElement SignoutLink;
	
	
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	public WebElement getContactsLnk() 
	{
		return ContactsLnk;
	}


	public WebElement getOpportunitiesLnk() 
	{
		return OpportunitiesLnk;
	}


	public WebElement getAdministratorImg() 
	{
		return AdministratorImg;
	}


	public WebElement getSignoutLink() 
	{
		return SignoutLink;
	}


	public WebElement getOrganizationLnk() 
	{
		return OrganizationLnk;
	}


	//Business Libraries
	/**
	 * This method will click on organizations link
	 */
	public void clickOnOrganizationsLink()
	{
		OrganizationLnk.click();
	}
	
	
	/**
	 * This method will click on contacts
	 */
	public void clickOnContactsLink()
	{
		ContactsLnk.click();
	}
	
	
	/**
	 * This method will sign out from the application
	 */
	public void signoutOfApp(WebDriver driver) 
	{
		mouseHoverAction(driver, AdministratorImg);
		SignoutLink.click();
	}

}