package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {

	
	@Test
	public void AssertExample()
	{
		
		SoftAssert as= new SoftAssert();
		System.out.println("Step1");
		System.out.println("Step2");
		
		//Assert.assertEquals("Shruti", "Shruti", "contact name should be");
		
		
		as.assertEquals(false, true);
		System.out.println("Step3");
		System.out.println("Step4");
		as.assertAll();
	}
}
