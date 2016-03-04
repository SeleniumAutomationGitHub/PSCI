package com.psci.pageobject;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.psci.util.InitilizeURL;
import com.psci.util.InitilizerDriverBrowser;
import com.psci.util.ScreenShot;
import com.psci.util.WaitDriver;

public class VitreosLoginPage {
	
	PatientRiskAnalyzer pra = new PatientRiskAnalyzer() ;

	@FindBy(id="userName")
	public WebElement userName;
	
	@FindBy(name="pwd")
	private WebElement password;
	
	@FindBy(id="loginDiv")
	private WebElement loginBtn;
	
	@FindBy(how = How.XPATH, using="//*[@id='content']/div[8]/div[1]/div[2]/div[1]/p/span") 
	public WebElement userNameText;
	
	@FindBy(how = How.LINK_TEXT, using="Log out")
	public WebElement logoutLink;
	
	
	
	public void verifyLoginPage(){
		
		try{
			if(InitilizerDriverBrowser.driver.getTitle() !=null)
			{
				Assert.assertEquals(InitilizerDriverBrowser.driver.getTitle(), "Vitreos Healthcare Data Analyzer", "Login Title validation failed");
			}
		}catch(Exception e){
			System.out.println("URL is not correct");
			//e.printStackTrace();
		}
				
	}
		
	public void verifyGmailLoginPage(){
		
		try{
			
			System.out.println(InitilizerDriverBrowser.driver.getTitle());
			
		}catch(Exception e){
			System.out.println("URL is not correct");
			//e.printStackTrace();
		}
				
	}
		
	//Login to application
	public void loginToVitreos(String username, String passwd)
	{
		try{
			Thread.sleep(1000);
			if(username !=null && !username.equals("") && passwd !=null && !passwd.equals(""))
			{
				userName.clear();
				userName.sendKeys(username);
				password.clear();
				password.sendKeys(passwd);
				
				if(loginBtn.isDisplayed() && loginBtn.isEnabled())
				{
					loginBtn.click();
					Thread.sleep(3000);
					Assert.assertEquals(InitilizerDriverBrowser.driver.getTitle(), "Patient risk analyzer", "Failed login page");
					//Assert.assertEquals(userNameText.getText(), username, "Login by wrong user");
					
				}else{
					System.out.println("Login button is not displayed or not enabled.");					
				}
				
			}else{
				System.out.println("Username and password can't be null.");
			}
		} catch (Exception e) {
			Assert.assertEquals(InitilizerDriverBrowser.driver.getTitle(), "Problem loading page", "URL is not able to access");
		}
	}
	
	
	
	
	//Logout from application
	public void logoutFromViterous()
	{
		try
		{
			if(pra.isElementPresent(logoutLink) && logoutLink.isEnabled())
			{
				Thread.sleep(5000);
				logoutLink.click();
				Assert.assertEquals(InitilizerDriverBrowser.driver.getTitle(), "Vitreos Healthcare Data Analyzer", "Logout failed");
			} else{
				Assert.assertEquals(pra.isElementPresent(logoutLink), true, "FAILED because Logout link is not found.");
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

	//Closing the driver after logout	
	public void browserQuit()
	{
		try{
			InitilizerDriverBrowser.driver.quit();
			System.out.println("Browser closed");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
		
}
	

