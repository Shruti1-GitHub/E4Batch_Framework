package practice;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import genericUtilities.ExcelUtility;

public class WriteDataFromExcelFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ExcelUtility Wdata= new ExcelUtility();
		//Workbook wb= WorkbookFactory.create(fos);
		
		Workbook wb = Wdata.WriteDataFromExcelFile("Contact", 1, 2, "Shruti");
		FileOutputStream fos= new FileOutputStream("./src/test/resources/TestData1.xlsx");
		wb.write(fos);
		wb.close();

	}

}
