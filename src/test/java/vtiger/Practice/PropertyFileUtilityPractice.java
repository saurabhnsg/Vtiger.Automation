package vtiger.Practice;

import java.io.IOException;

import genericUtilities.PropertyFileUtility;

public class PropertyFileUtilityPractice 
{
	public static void main(String[] args) throws IOException 
	{
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String url = pUtil.readDataFromPropertyFile("url");
		System.out.println(url);
	}
}
