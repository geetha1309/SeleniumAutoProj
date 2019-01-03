package com.test.automation.AutomationProject.testbase;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String browser = "Chrome";
	
	public void init() {
		// TODO Auto-generated method stub
		selectBrowser(browser);
		getURL(url);
		String log4jconfpath = "log4j.properties";
		PropertyConfigurator.configure(log4jconfpath);
		
		
		
			
		
	}

	public void getURL(String url) {
		// TODO Auto-generated method stub
		driver.get(url);		
		driver.manage().window().maximize();
	}

	public void selectBrowser(String browser) {
		// TODO Auto-generated method stub
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Driver//chromedriver.exe");
			  driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Driver//geckodriver.exe");
			  driver = new FirefoxDriver();
		}
	}
	
	

}
