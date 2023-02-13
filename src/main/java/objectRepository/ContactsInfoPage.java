package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage 
{
	@FindBy (xpath = "//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	
	//Initialization
		public ContactsInfoPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}

		
		//Utilization
		public WebElement getContactHeaderText() 
		{
			return ContactHeaderText;
		}
		
		
		//Business Library
		/**
		 * This method will capture the contact header & return the value
		 * @return
		 */
		public String getContactHeader()
		{
			return ContactHeaderText.getText();
		}
}

