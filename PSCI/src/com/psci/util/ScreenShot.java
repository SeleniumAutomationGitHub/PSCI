package com.psci.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class ScreenShot {
	
	   static String dateTime;
	
	public static void failedScreenShot(String imgFileName, String imgType, String formatDateTime ) throws Exception
	{
		//To take the timestamp of taking the sreenshot
		dateTime = screenShotDateTime(formatDateTime);
		
		//To take the screenshot and store in fileName variable 
		//File fileName = ((TakesScreenshot)InitilizerDriverBrowser.driver).getScreenshotAs(OutputType.FILE);
		
		TakesScreenshot ts = (TakesScreenshot)InitilizerDriverBrowser.driver;
		File fileName = ts.getScreenshotAs(OutputType.FILE);
		
		//To copy the screenshot from fileName variable and paste in the given path 
		FileUtils.copyFile(fileName, new File(".\\Screenshot\\" + imgFileName + " " + dateTime + "." + imgType));
	}
	
	   
	  
	public static String screenShotDateTime(String formatDateTime) 
	{
		//Assigning the given date format to DateFormat reference variable in yyyy_MMM_dd hh_mm_ss
		DateFormat df = new SimpleDateFormat(formatDateTime);
		Date dt = new Date();
		
		//Taking the current date and time as per the format specified and convert into String
		dateTime = df.format(dt);
		return dateTime;
	}

}
