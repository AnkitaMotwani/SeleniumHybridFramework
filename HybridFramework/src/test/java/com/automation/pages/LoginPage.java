package com.automation.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	
	@FindBy(xpath = "//button[@id='wzrk-cancel' and text()='No thanks']")WebElement cancelButton;
	@FindBy(xpath="//a[text()='Hello, Login']")WebElement loginLink;
	@FindBy(xpath="//a[@class='btn_signin dropdown-toggle linkSignIn active']")WebElement login;
	@FindBy(xpath = "//*[@id=\"ACCT_FB_LOGIN\"]")WebElement googleLogin;
	@FindBy(name="email")WebElement emailId;
	@FindBy(id="pass")WebElement pswrd;
	@FindBy(name = "login")WebElement loginFacebook;
	@FindBy(id="error_box")WebElement loginError;
	public void cancel() {
		cancelButton.click();
	}
	public void loginStock(String email, String password) {
		loginLink.click();
		login.click();
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		driver.switchTo().frame("myframe");
		googleLogin.click();
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		for (String childWindowHandle : driver.getWindowHandles()) {
			  //If window handle is not main then perform action on child element 
			  if(!childWindowHandle.equals(parentWindow)){
			  driver.switchTo().window(childWindowHandle);
			  emailId.clear();
			  emailId.sendKeys(email);
			  pswrd.clear();
			  pswrd.sendKeys(password);
			  loginFacebook.click();
			  System.out.println(loginError.getText());
			  
			  }
			} 
			driver.switchTo().window(parentWindow);
  }
}

	