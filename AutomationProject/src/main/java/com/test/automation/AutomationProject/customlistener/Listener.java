package com.test.automation.AutomationProject.customlistener;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.test.automation.AutomationProject.testbase.TestBase;

public class Listener extends TestBase implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		String methodName = arg0.getName();
		System.out.println(methodName);
		if (!arg0.isSuccess())
		{
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String reportDir = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/automation/AutomationProject/";
			File destFile = new File((String)reportDir+"/failure_screenshots/"+methodName+"_"+formatter.format(cal.getTime())+".png");
			try {
				FileUtils.copyFile(srcFile, destFile);
				Reporter.log("<a href = '"+destFile.getAbsolutePath()+"'> <img src = '"+destFile.getAbsolutePath()+"' height = '100' width = '100'/></a>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		Reporter.log("Test started running:"+arg0.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		String methodName = arg0.getName();
		System.out.println(methodName);
		Reporter.log("Test is Successful:"+arg0.getMethod().getMethodName());
		if (arg0.isSuccess())
		{
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String reportDir = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/automation/AutomationProject/";
			File destFile = new File((String)reportDir+"/success_screenshots/"+methodName+"_"+formatter.format(cal.getTime())+".png");
			
			try {
				FileUtils.copyFile(srcFile, destFile);
				Reporter.log("<a href = '"+destFile.getAbsolutePath()+"'> <img src = '"+destFile.getAbsolutePath()+"' height = '100' width = '100'/></a>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	

}

