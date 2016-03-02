package com.psci.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitilizerDriverBrowser {
	
	public static WebDriver driver;
	public static FirefoxProfile profile;
	
	public static FirefoxProfile settingSSL(){
		
		profile = new FirefoxProfile();
		profile.setPreference("security.ssl3.dhe_rsa_aes_128_sha", false);
		profile.setPreference("security.ssl3.dhe_rsa_aes_256_sha", false);
		return profile;
	}

	//@Parameters("Browser")
	//@Test
	public static WebDriver launchBrowser(String browser)
	{
		try
		{
			InitilizerDriverBrowser.profile = InitilizerDriverBrowser.settingSSL();
			
			if(browser.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver(profile);
			}
				
			else if("ie".equalsIgnoreCase(browser))
			{
				System.setProperty("webdriver.ie.driver", "D:/Projects/Automation/Workspace/PSCI/drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
				
			else if("CHROME".equalsIgnoreCase(browser))
			{
				System.setProperty("webdriver.chrome.driver", "D:\\Projects\\Automation\\Workspace\\PSCI\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} 
			
			else
			{
				driver = new FirefoxDriver();
			}
			
		} catch(Exception e){
			return null;
		}
			return driver;
	}
	
	

		
}
