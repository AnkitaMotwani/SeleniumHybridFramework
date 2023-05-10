package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties property;
	
	public ConfigDataProvider() {
		
		File src = new File("./Configration/config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			property = new Properties();
			property.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load config"+e.getMessage());
			e.printStackTrace();
		}
		
	}
	public String getDataFromConfig(String keyToSearch) {
		return property.getProperty(keyToSearch);
		
	}
	
	public String getBrowser() {
		
		return property.getProperty("browser");
	}
	public String getStagingURL() {
		
		return property.getProperty("stockUrl");
	}
	
}
