package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility 
{	
	/**
	 * This method will read data from excel sheet and return the value
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelSheet(String sheet,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row ro = sh.getRow(rowNo);
		Cell ce = ro.getCell(cellNo);
		String value = ce.getStringCellValue();
		return value;
	}
	
	/**
	 * This method will provide the row count when the specific sheet is provided
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int rowcount = sh.getLastRowNum();
		return rowcount;
	}
	
	/**
	 * This method will write data into excelSheet
	 * @param sheet
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void WriteDataIntoExcelSheet(String sheet,int rowNo,int cellNo, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row ro = sh.getRow(rowNo);
		Cell ce = ro.createCell(cellNo);
		ce.setCellValue(value);
		
		FileOutputStream fos= new FileOutputStream(IConstantUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
	}
	
	
	/**
	 * This method will read multiple data from the excel sheet
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcelSheet(String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis= new FileInputStream(IConstantUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("MultipleOrg");
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object [] [] data = new Object [lastRow] [lastCell];	
		
		for (int i = 0; i < lastRow; i++) 
		{
			for (int j = 0; j < lastCell; j++) 
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
}
