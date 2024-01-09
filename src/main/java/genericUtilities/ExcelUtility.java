package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility  {
	/**
	 * This method is used to read data from excel file
	 * @param Sheet
	 * @param rw
	 * @param cell
	 * @return String Value to the caller
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @author ShrutiGarje
	 */
	
	public String ReadDataFromExcelFile(String Sheet,int rw,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String Value=wb.getSheet(Sheet).getRow(rw).getCell(cell).getStringCellValue();
		return Value;
	
	
	}
	public Workbook WriteDataFromExcelFile(String Sheet,int rw, int cell, String setval) throws IOException
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		wb.getSheet(Sheet).getRow(rw).createCell(cell).setCellValue(setval);
		 return wb;
		
	}


}
