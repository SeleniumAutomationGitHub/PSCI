package com.psci.util;

import org.openqa.selenium.WebElement;

import com.psci.pageobject.PatientRiskAnalyzer;



public class WaitDriver {
	
	
	public static void implicitWait(WebElement element) throws Exception
	{
		for(int i = 0; i < 60; i++)
		{
			try
			{
				Thread.sleep(3000);
				if(PatientRiskAnalyzer.isElementPresent(element)){
					break;
				}
					
			}catch(Exception e){
				Thread.sleep(1000);
				//e.printStackTrace();
			}
		}
	}
	
	
	public static void explicitWait(WebElement element) throws Exception
	{		
			try
			{
				while(element.isDisplayed())
				{
					break;
				}
			}catch(Exception e){
				Thread.sleep(1000);
				//e.printStackTrace();
			}
	}
	
}
