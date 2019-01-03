package com.test.automation.AutomationProject.homepage;

import org.testng.annotations.Test;

import com.test.automation.AutomationProject.testbase.TestBase;
import com.test.automation.AutomationProject.uiactions.HomePage;


import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;


public class TC001_VerifyLoginWithInvalidCredentials extends TestBase {
  public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());
	@Test
  public void verifyLoginWithInvalidCredentials() 
	{
	  log.info("-----Starting verifyLoginWithInvalidCredentials test-----" );
	  HomePage hpage = new HomePage(driver);
	  hpage.loginToApplication("tuomation@gmail.com", "password");
	  Assert.assertEquals("Authentication failed.", hpage.getInvalidLoginText());
	  log.info("-----Ending verifyLoginWithInvalidCredentials test-----" );
  }
  @BeforeMethod
  public void beforeMethod() {
	 
	  init();
  }

  
@AfterMethod
  public void afterMethod() {
  }

}
