package com.psci.util;

public class InitilizeURL {
	
	
	public static void launchURL(String url){
				
		InitilizerDriverBrowser.driver.manage().window().maximize();
		InitilizerDriverBrowser.driver.get(url);
	}
}
