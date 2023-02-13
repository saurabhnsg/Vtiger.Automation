package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{	
	//Declaration
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(name = "leadsource")
	private WebElement LeadSourceDropDown;
	
	@FindBy(xpath = "//input[@name='account_name']//following-sibling::img[@title='Select']")
	private WebElement organizationImg;
	
	@FindBy(id= "search_txt")
	private WebElement SearchEdt;
	
	@FindBy (name = "search")
	private WebElement SearchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	
	//Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getLastNameEdt() 
	{
		return LastNameEdt;
	}


	public WebElement getLeadSourceDropDown() 
	{
		return LeadSourceDropDown;
	}


	public WebElement getOrganizationImg() 
	{
		return organizationImg;
	}


	public WebElement getSearchEdt() 
	{
		return SearchEdt;
	}

	
	public WebElement getSearchBtn() 
	{
		return SearchBtn;
	}
	

	public WebElement getSaveBtn() 
	{
		return SaveBtn;
	}
	
	
	//Business Libraries
	/**
	 * This method will create contact with last name
	 * @param lastName
	 */
	public void createContact(String lastName)
	{
		LastNameEdt.sendKeys(lastName);
		SaveBtn.click();
	}
	
	
	/**
	 * This method will create contact with lastname & orgname
	 * @param lastName
	 * @param driver
	 * @param OrgName
	 */
	public void createContact(String lastName, String OrgName, WebDriver driver) 
	{
		LastNameEdt.sendKeys(lastName);
		organizationImg.click();
		switchToWindow(driver, "Accounts");
		SearchEdt.sendKeys(OrgName);
		SearchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+ OrgName +"']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
	}
	
	
}
