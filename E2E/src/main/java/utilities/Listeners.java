package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.*;

import Facebook.FacBkTest;

import org.apache.logging.log4j.*;

import resource.ExtentReporter;

public class Listeners extends base implements ITestListener {

	
	ExtentReports extent = ExtentReporter.getreport();//we are directly calling the getreport method from extentreporter class
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
							
	}
	public void onFinish(ITestContext arg0) {
		extent.flush();
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		//ExtentTest test = new ExtentReports();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void onTestSuccess(ITestResult arg0) {
		test.log(Status.PASS, "TEST IS PASSED SUCCESSFULLY");
		
	}


	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Screenshot
		//extentTest.get().fail(result.getThrowable());
		test.fail(result.getThrowable()); // to see the logs in the extent report
		
		WebDriver driver =null;
		String testMethodName =result.getMethod().getMethodName();
		
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{
			
		}
		try {
			String path = getscreenshot(testMethodName,driver);
			test.addScreenCaptureFromPath(path,testMethodName); // to add screenshot to the extent report
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	



}
