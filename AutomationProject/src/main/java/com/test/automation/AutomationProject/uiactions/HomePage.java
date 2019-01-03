package com.test.automation.AutomationProject.uiactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.AutomationProject.homepage.TC001_VerifyLoginWithInvalidCredentials;

public class HomePage {
	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
/**
 * @author Dell
 * login properties
 */
	

	@FindBy(linkText="Sign in") WebElement signin;
	@FindBy(id="email") WebElement emailId;
	@FindBy(id="passw") WebElement pwd;
	@FindBy(id="SubmitLogin") WebElement submit;
	@FindBy(xpath =".//*[@id='center_column']/div[1]/ol/li") WebElement errmsg;
	
	

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String emailaddress, String password)
	{
		signin.click();
		log.info("Clicked on Sign in and Object is :"+signin.toString());
		emailId.sendKeys(emailaddress);
		log.info("Entered email address :"+emailaddress+" object is :"+emailId.toString());
		pwd.sendKeys(password);
		log.info("Entered Password :"+password+ "and object is :"+pwd.toString());
		submit.click();
		log.info("Clicked on submit button and object is : "+submit.toString());
	}
	
	public String getInvalidLoginText()
	{
		log.info("Error message is :"+errmsg.getText()+" and object is : "+errmsg.toString());
		return errmsg.getText();
		
	}
	
}
