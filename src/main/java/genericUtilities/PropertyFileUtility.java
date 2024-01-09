package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;




public class PropertyFileUtility {

	
	/**
	 * This method read data from property file
	 * @param key
	 * @return Value
	 * @throws IOException
	 */
	public String ReadDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis= new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p= new Properties();
		p.load(fis);
		
		String Value = p.getProperty(key);
		return Value;
	}
}
