package com.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.baseclass.Base_Class;

public class ITestListenerClass extends Base_Class implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentReport_Test.extentest.pass(result.getMethod()+ ":"+"Test pass",MediaEntityBuilder
				.createScreenCaptureFromPath(takeScreenShot()).build());		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReport_Test.extentest.fail(result.getMethod()+ ":"+"Test fail",MediaEntityBuilder
				.createScreenCaptureFromPath(takeScreenShot()).build());	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}


}
