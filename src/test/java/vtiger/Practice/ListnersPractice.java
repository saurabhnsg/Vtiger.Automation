package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClasss;

@Listeners(genericUtilities.ListnersImplementation.class)
public class ListnersPractice extends BaseClasss
{
	@Test
	public void tc1()
	{
		System.out.println("Test case1");
		Assert.fail();
		System.out.println("Test case successfull");
	}
}
