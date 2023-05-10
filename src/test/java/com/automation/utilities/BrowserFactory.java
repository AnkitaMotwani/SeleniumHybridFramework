package com.automation.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver startWebApplication(WebDriver driver, String browserName, String appURL) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=http://localhost:58586");
//			driver.manage().timeouts().pageLoadTimeout(30, Duration.SECONDS);
			
			
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			
		}
		else if(browserName.equalsIgnoreCase("IE")) {
			
		}
		else {
			System.out.println("we do not support this browser");
		}
	driver.manage().window().maximize();
	driver.get(appURL);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	return driver;
	}
   public static void quitBrowser(WebDriver driver) {
	 driver.quit();
 }
}
