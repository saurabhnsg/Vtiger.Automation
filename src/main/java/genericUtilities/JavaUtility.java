package genericUtilities;

import java.util.Date;
import java.util.Random;

//single line comment in java
/* multi line comment in java */
/** This is description 
* 
* This class consist of generic methodS related to Java
* @author Saurabh N
* 
*/

public class JavaUtility 
{	
	/**
	 * This method will generate random number for every run
	 * @return
	 */
	public int getRandomNumber()
	{
		Random r= new Random();
		int value =r.nextInt(2000);
		return value; 
	}
	
	/**
	 * This method will provide the system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d= new Date();
		String value = d.toString(); //convert to the String
		return value;
	}
	
	/**
	 * This method will return date in specific format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d= new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-"); //this is we have written to change format of date from old to new :  to - because we cant save the file with :
		String dateInFormat = date+" "+month+" "+year+" "+time;
	
		return dateInFormat;
	}	
	

}