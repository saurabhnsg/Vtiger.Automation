package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * This class consist of generic methods related to PropertyFile
 * @author Saurabh N
 *
 */


/**
 * 
 * This method will read the data from the property file & return the value
 * @author Shree
 *
 */
public class PropertyFileUtility 
{
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream(IConstantUtility.PropertyFilePath);
		Properties pObj= new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}
}
