package page;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class A {
	
	@Test
	public void testA()
	{
		Reporter.log("testA", true);
	}
	@Test
	public void testB()
	{
		Reporter.log("testB", true);
		Assert.fail();
	}
	@AfterMethod
	public void am(ITestResult res)
	{
		String n=res.getName();
		int s=res.getStatus();
		String msg="TestName: "+n+"& Status: "+s;
		Reporter.log(msg, true);
	}

}

