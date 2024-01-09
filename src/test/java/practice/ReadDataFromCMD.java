package practice;

import org.testng.annotations.Test;

public class ReadDataFromCMD {
	
	@Test
	public void testdata()
	{
		
		String Username = System.getProperty("Username");
		String pwd = System.getProperty("pwd");
		
		System.out.println(Username);
		System.out.println(pwd);
	}
	@Test
	public void sample()
	{
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
	}

}
