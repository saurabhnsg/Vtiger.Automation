package vtiger.Practice;

import genericUtilities.JavaUtility;

public class JavaUtilityPractice 
{
	public static void main(String[] args) 
	{
		JavaUtility jUtil= new JavaUtility();
		int number = jUtil.getRandomNumber();
		System.out.println(number);
		
		String date = jUtil.getSystemDate();
		System.out.println(date);
		
		String dateInSpecificFormat = jUtil.getSystemDateInFormat();
		System.out.println(dateInSpecificFormat);
	}
}
