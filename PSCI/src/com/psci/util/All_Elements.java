package com.psci.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class All_Elements {
	
	public static void verifyAllLinks(){
		
		List<WebElement> allLinks = InitilizerDriverBrowser.driver.findElements(By.tagName("a"));
		for (int i = 0; i < allLinks.size(); i++) 
		{
			System.out.println(allLinks.get(i).getText());
									
		}
	}
	
	
	
	public static void verifyAllFields(String url)
	{
		
		List<WebElement> allFields = InitilizerDriverBrowser.driver.findElements(By.xpath("//html/body/div[2]/div/div/form/div/input")); 
		
		//List<WebElement> allFields = InitilizerDriverBrowser.driver.findElements(By.tagName("input")); //It will give all the list whose tag name is Input including checkbox and radio buttons
		System.out.println("Fields count : " + allFields.size());
		
		for (int i = 0; i < allFields.size(); i++) 
		{
			System.out.println(allFields.get(i).getAttribute("name"));
									
		}
	}
	
	
	
	
	public static void verifyAllCheckbox(String url)
	{
		List<WebElement> allFields = InitilizerDriverBrowser.driver.findElements(By.xpath(".//*[@type='checkbox']")); //It will give the list of only all check boxes
		System.out.println("Fields count : " + allFields.size());
		
		for (int i = 0; i < allFields.size(); i++) 
		{
			System.out.println(allFields.get(i).getAttribute("name"));
									
		}
	}


	public static void main(String[] args) {
		verifyAllCheckbox("http://202.89.104.116:8080/ClaimsAnalyzer/");
		

	}

}

