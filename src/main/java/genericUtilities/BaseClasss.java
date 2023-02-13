package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClasss 
{	
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver;
	
	
	@BeforeSuite(groups= {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("====Data Base Connection Successfull====");
	}
	
	
	//@org.testng.annotations.Parameters("browser")
	//@BeforeTest(groups= {"SmokeSuite","RegressionSuite"})
	@BeforeClass(groups= {"SmokeSuite","RegressionSuite"})
	public void bcConfig() throws IOException
	{
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			sdriver = driver;
			System.out.println("===="+BROWSER+"+ Launched Successfully");
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			sdriver = driver;
			System.out.println("===="+BROWSER+"+ Launched Successfully");
		}
		else
		{
			System.out.println("====Invalid Browser Name====");
			System.out.println("===="+BROWSER+"+ Launched Successfully");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
		}
	
	
	@BeforeMethod(groups= {"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("=====Login Successfull=====");
	}
	
	
	@AfterMethod(groups= {"SmokeSuite","RegressionSuite"})
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.signoutOfApp(driver);
		System.out.println("====Logout Successfull====");
	}
	
	
	//@AfterTest(groups= {"SmokeSuite","RegressionSuite"})
	@AfterClass(groups= {"SmokeSuite","RegressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("====Browser Closed Successfully====");
	}
	
	
	@AfterSuite(groups= {"SmokeSuite","RegressionSuite"})
	public void asConfig()
	{
		System.out.println("====Database Disconnected Successfully====");
	}
	
	
}
