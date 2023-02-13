package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //Rule 1: create pom page for every web page
					  //Rule 2: class name should be the title of page and ending with page
{
	//Rule 3: identify the  web element using @FindBy, @FindAll, @FindBys annotation
	
	@FindBy (name="user_name")
	private WebElement UserNameEdt;
	
	@FindBy (name="user_password")
	private WebElement PasswordEdt;
	
	@FindBy (id="submitButton")
	private WebElement SubmitBtn;

	
	//Rule 4: create the constructor to initialize web elements/ variable
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Rule 5: Provide getters to access the web elements
	
	public WebElement getUserNameEdt() 
	{
		return UserNameEdt;
	}


	public WebElement getPasswordEdt() 
	{
		return PasswordEdt;
	}


	public WebElement getSubmitBtn() 
	{
		return SubmitBtn;
	}
	
	
	//Business Libraries - Generic Methods - for this application
	/**
	 * This method will login to the application
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username, String password)
	{
		UserNameEdt.sendKeys(username);
		PasswordEdt.sendKeys(password);
		SubmitBtn.click();
	}
	
}
