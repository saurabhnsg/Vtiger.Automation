package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility
{
	
	//Declaration
	@FindBy (name= "accountname")
	private WebElement OrgNameEdt;;
	
	@FindBy (name="industry")
	private WebElement industryDropDown;;
	
	@FindBy (name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy (xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	//Initialization
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getOrgNameEdt() 
	{
		return OrgNameEdt;
	}


	public WebElement getIndustryDrp() 
	{
		return industryDropDown;
	}


	public WebElement getTypeDrp() 
	{
		return typeDropDown;
	}


	public WebElement getSaveEdt() 
	{
		return saveBtn;
	}
	
	
	//Business Library
	/**
	 * This method will create new organization & save
	 * @param OrgName
	 */
	public void createOrganization(String OrgName)
	{
		OrgNameEdt.sendKeys(OrgName);
		saveBtn.click();
	}
	
	
	/**
	 * This method will create new organization with industry
	 * @param OrgName
	 * @param Industry
	 */
	public void createNewOrganization(String OrgName, String Industry) 
	{
		OrgNameEdt.sendKeys(OrgName);
		handleDropdown(industryDropDown, Industry);
		saveBtn.click();
	}
}
