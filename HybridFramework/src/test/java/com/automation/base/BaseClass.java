package com.automation.base;

import java.io.File;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ConfigDataProvider;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void setUpSuite() {
	 excel = new ExcelDataProvider();
	 config = new ConfigDataProvider();
	 ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/stockmarket_"+Helper.getCurrentDateTime()+".html"));
	 report = new ExtentReports();
	 report.attachReporter(extent);
	
	}
	
	@BeforeClass
	public void setUp() {
		
		driver = BrowserFactory.startWebApplication(driver, config.getBrowser(),config.getStagingURL());
	}
	
	@AfterClass
	public void tearDown() {
		
		BrowserFactory.quitBrowser(driver);
	}
	@AfterMethod
	public void screenShot(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
//		Helper.takeScreenSot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.takeScreenSot(driver)).build());
	   }
		else if(result.getStatus()==ITestResult.SUCCESS) {
//			Helper.takeScreenSot(driver);
			logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.takeScreenSot(driver)).build());
		   }
		report.flush();
	}
	

}
