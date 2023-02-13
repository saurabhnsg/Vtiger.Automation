package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage 
{	
	//Declaration
	@FindBy (xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	@FindBy (id ="mouseArea_Organization Name")
	private WebElement orgName;
	
	
	//Initialization
	public OrganizationsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getOrgHeaderText() 
	{
		return orgHeaderText;
	}
	
	public WebElement getorgName() 
	{
		return orgName;
	}
	
	
	
	//Business Library
	/**
	 * This method will capture the organization header & return it to the caller
	 * @return
	 */
	public String getOrganizationHeader()
	{
		return orgHeaderText.getText();
	}
	
	
	/**
	 * This method will capture organization name & return to the caller method
	 * @return
	 */
	public String getOrgName()
	{
		return orgName.getText();
	}

}

