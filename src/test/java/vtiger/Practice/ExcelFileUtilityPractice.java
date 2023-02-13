package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import genericUtilities.ExcelFileUtility;

public class ExcelFileUtilityPractice 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		ExcelFileUtility eUtil= new ExcelFileUtility();
		String value = eUtil.readDataFromExcelSheet("Organizations", 1, 1);
		System.out.println(value);
		
		int value1 = eUtil.getRowCount("Organizations");
		System.out.println(value1);
		
		eUtil.WriteDataIntoExcelSheet("Organizations", 1 , 4, "Qspiders");
	}
}
