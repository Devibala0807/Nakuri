package com.listener;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.baseclass.Base_Class;


public class ExtentReport_Test extends Base_Class {
	
	public static ExtentTest extentest;
	
	@BeforeSuite
	private void extentTestReportStartup() {
       Base_Class base = new Base_Class() {
	};
	base.extentReportStart(null);
	}
	@AfterSuite
	private void extentReportEnd() {
		Base_Class base = new Base_Class() {

	};
	base.extentReportTearDown(null);
	}

}
