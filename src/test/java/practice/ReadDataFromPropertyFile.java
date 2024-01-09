package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//step1: open the document in java readable format
		FileInputStream fis =new FileInputStream("./src/test/resources/CommonData.properties");
		//step 2:= Create object of properties class from java.util package
		Properties p= new Properties();
		//set3: load the file input stream to properties class
		p.load(fis);
		//step4: provide key and read the value
		String uname = p.getProperty("username");
		String pass= p.getProperty("password");
		String url=p.getProperty("url");
		System.out.println("Url:-"+url);
		System.out.println("Username:-"+uname);
		System.out.println("Password:-"+pass);
	}

}
