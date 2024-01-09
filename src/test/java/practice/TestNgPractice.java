package practice;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPractice {
	@Test(priority=1,dependsOnMethods="createCustmor")
	public void modifyCustmor()
	{
		System.out.println("Modify");
	}

	@Test(priority=2)
	public void createCustmor()
	{
		//AssertJUnit.fail();
		System.out.println("Create");
	}

	@Test(priority=3,invocationCount=4)
	public void deleteCustmor()
	{
		System.out.println("Delete");
	}

}
