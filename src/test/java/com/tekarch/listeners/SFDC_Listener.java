/**
 * 
 */
package com.tekarch.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.teckarck.constants.FileConstants;
import com.tekarch.utils.CommonUtils;
import com.tekarck.testCases.BaseTest;

/**
 * 
 */
public class SFDC_Listener implements ITestListener{
	
	
	 ExtentReports extent=new ExtentReports();
	 ExtentSparkReporter spark;
	 ExtentTest test;
	
	
	@BeforeSuite
	@Override
	public void onStart(ITestContext context) {
//		extent=new ExtentReports();
		
		spark=new ExtentSparkReporter(FileConstants.TEST_REPORT_FILE_PATH);
		spark.config().setDocumentTitle("Sales Force Application");
		spark.config().setReportName("Functional Testing");
		spark.config().setTheme(Theme.STANDARD);
		
		extent.attachReporter(spark);
		extent.setSystemInfo("Application", "Sales Force Application");
		extent.setSystemInfo("Environment", "QA Environment");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("Tester Name", "Anusha");
		
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test=extent.createTest(result.getName());
		
		test.info(BaseTest.getDriver().getClass().getName());
		
		test.log(Status.PASS, result.getName());
		
		test.pass(MarkupHelper.createLabel(result.getName()+"  Passed", ExtentColor.GREEN));
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());
		test.info(BaseTest.getDriver().getClass().getName());
		test.log(Status.FAIL, result.getName());
		test.fail(MarkupHelper.createLabel(result.getName()+"  Failed", ExtentColor.RED));
		
		try {
			
//			test.addScreenCaptureFromPath(BaseTest.getScreenShot(result.getName()));
			test.addScreenCaptureFromPath(CommonUtils.getScreenShot(result.getName()));
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	
	public void onTestSkipped(ITestResult result) {
        test=extent.createTest(result.getName());
		
		test.info(BaseTest.getDriver().getClass().getName());
		
		test.log(Status.SKIP, result.getName());
		
		test.pass(MarkupHelper.createLabel(result.getName()+"  Skipped", ExtentColor.YELLOW));
	}
	
	
	@AfterSuite
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
