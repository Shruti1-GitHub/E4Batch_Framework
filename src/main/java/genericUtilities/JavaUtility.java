package genericUtilities;

import java.util.Date;

public class JavaUtility {
	
	
	public String getSystemDate()
	{
		
		Date d= new Date();
		 String[] date = d.toString().split(" ");
		 String currentdate = date[2]+"-"+date[1]+"-"+date[5]+"-"+date[3].replace(":", "_");
		
		 return currentdate;
		
	}

}
