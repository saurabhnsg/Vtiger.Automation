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
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;


/**
 * THis class contains all the basic configurations annotations
 * @author Saurabh
 *
 */
public class BaseClass 
{
	public WebDriverUtility wUtil= new WebDriverUtility();
	public PropertyFileUtility pUtil= new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver;

	
	@BeforeSuite(groups = {"SmokeSuite", "RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("====database connection successfull=====");
	}

	
	//@Parameters("browser")
	//@BeforeTest(groups = {"SmokeSuite", "RegressionSuite"})
	@BeforeClass(groups = {"SmokeSuite", "RegressionSuite"})
	public void bcConfig() throws IOException
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		
		if(BROWSER.equalsIgnoreCase("CHROME"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			sdriver=driver; //this is used for taking screenshot in listners
			System.out.println("===="+BROWSER+"+ Launched Successfully=====");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			sdriver=driver; //this is used for taking screenshot in listners
			System.out.println("===="+BROWSER+"+ Launched Successfully=====");
		}
		else
		{
			System.out.println("invalid browser name");
			System.out.println("===="+BROWSER+"+ Launched Successfully=====");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}
	
	
	@BeforeMethod(groups = {"SmokeSuite", "RegressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("=====Login Successfull=====");
	}
	
	
	@AfterMethod(groups = {"SmokeSuite", "RegressionSuite"})
	public void amConfig() 
	{
		HomePage hp= new HomePage(driver);
		hp.signoutOfApp(driver);
		System.out.println("=====Logout Successfull=====");
	}
	
	
	//@AfterTest(groups = {"SmokeSuite", "RegressionSuite"})
	@AfterClass(groups = {"SmokeSuite", "RegressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("====Browser Closed====");
		
	}
	
	
	@AfterSuite(groups = {"SmokeSuite", "RegressionSuite"})
	public void asConfig()
	{
		System.out.println("=====database connection closed====");
	}
}