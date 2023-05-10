package com.automation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.base.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ExcelDataProvider;

public class LoginTestStockMarket extends BaseClass {
		
	@Test
	public void loginApp() {
		logger = report.createTest("Login Stock Market");
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.cancel();
		logger.info("Login Test");
		login.loginStock(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		logger.pass("Incorrect user details");
	}

}
