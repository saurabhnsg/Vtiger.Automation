package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListnersImplementation implements ITestListener
{

	public void onTestStart(ITestResult result) 
	{	
		String methodName = result.getMethod().getMethodName();
		System.out.println("-----"+methodName+" - Test Execution Started-----");
	}

	
	public void onTestSuccess(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println("-----"+methodName+" - Test Script Pass----");
	}

	
	public void onTestFailure(ITestResult result) 
	{	
		WebDriverUtility wUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("-----"+methodName+" - Test Script Failed----");
		System.out.println(result.getThrowable());
		
		String ScreenShotName = methodName+"-"+jUtil.getSystemDateInFormat();
		
		try 
		{
			wUtil.takeScreenShot(BaseClasss.sdriver, ScreenShotName);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	
	public void onTestSkipped(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println("-----"+methodName+" - Test Script Skipped----");
		System.out.println(result.getThrowable());
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
	
	}

	
	public void onTestFailedWithTimeout(ITestResult result) 
	{

	}

	
	public void onStart(ITestContext context) 
	{
		System.out.println("-----Suite Execution Started-----");
	}

	
	public void onFinish(ITestContext context) 
	{
		System.out.println("-----Suite Execution Finished-----");
	}
	
}
