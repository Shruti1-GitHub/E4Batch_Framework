package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenersImplimentation implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname= result.getMethod().getMethodName();
		System.out.println(methodname +"----------Execution of @Test is Stared-------");
		test=report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stubITestListener.super.onTestSuccess(result);
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname +"------Test Pass--------");
		test.log(Status.PASS, methodname +"------Test Pass--------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname +"------Test Fail--------");
		
		System.out.println(result.getThrowable());
		test.log(Status.FAIL, methodname +"------Test Fail--------");
		test.log(Status.INFO, result.getThrowable());
		
		JavaUtility j= new JavaUtility();
		SeleniumUtility s= new SeleniumUtility();
		
		String ScreenShotName=methodname+":-"+j.getSystemDate();
		try {
			String path=s.captureScreenShot(BaseClass.sdriver, ScreenShotName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname +"------Test Skip--------");
		System.out.println(result.getThrowable());
		test.log(Status.SKIP, methodname +"------Test Skip--------");
		test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("---Execution of Suite File Started-------");
		
		ExtentSparkReporter htmlrep= new ExtentSparkReporter("./ExtentReport/Report"+ new JavaUtility().getSystemDate()+".html");
		htmlrep.config().setDocumentTitle("Execution Repot");
		htmlrep.config().setDocumentTitle("Vtiger Repot");
		htmlrep.config().setTheme(Theme.DARK);
		
		 report= new ExtentReports();
		report.attachReporter(htmlrep);
		report.setSystemInfo("Base Platform", "Window");
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base Env", "Test Env");
		report.setSystemInfo("Reporter Name", "Shruti");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("---Execution of Suite Finished-------");
		report.flush();
	}
	
	

}
