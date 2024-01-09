package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import genericUtilities.ExcelUtility;

public class ReadDataFromExcelUitility {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		ExcelUtility excel= new ExcelUtility();
		String Value=excel.ReadDataFromExcelFile("Contact", 5, 1);
		System.out.println(Value);
	}

}
