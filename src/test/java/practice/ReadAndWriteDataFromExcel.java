package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadAndWriteDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis= new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		/*String lastName = wb.getSheet("Contact").getRow(1).getCell(2).getStringCellValue();
		System.out.println("Before editing workbook last name:-"+lastName);
		wb.getSheet("Contact").createRow(1).createCell(2).setCellValue("SpiderMan");
		String lastName1 = wb.getSheet("Contact").getRow(1).getCell(2).getStringCellValue();
		wb.getSheet("Contact").createRow(1).createCell(1).setCellValue("CreateContactWithLastName");
		String cont = wb.getSheet("Contact").getRow(1).getCell(1).getStringCellValue();
		wb.getSheet("Contact").createRow(1).createCell(0).setCellValue("TC_001");
		String TC = wb.getSheet("Contact").getRow(1).getCell(0).getStringCellValue();
		
		
		//wb.getSheet("Contact").getRow(1).getCell(2).getStringCellValue();
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData1.xlsx");
		wb.write(fos);
		System.out.println("After editing workbook last name:-"+lastName1);
		System.out.println("After editing workbook Contact:-"+cont);
		System.out.println("After editing workbook TC:-"+TC);*/
		String lastName = wb.getSheet("Contact").getRow(5).getCell(2).getStringCellValue();
		System.out.println(lastName);
		
		wb.close();
		

	}

}
