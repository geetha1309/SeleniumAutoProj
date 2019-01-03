package com.test.automation.AutomationProject.customlistener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Retry implements IRetryAnalyzer {
	
	private int retryCount = 0;
	private int maxretryCount = 2;

	public boolean retry(ITestResult arg0) {
		// TODO Auto-generated method stub
		if(retryCount < maxretryCount)
		{
		 log("Retrying test:"+arg0.getName()+"with status"+getResultStatusName(arg0.getStatus())+"for the"+(retryCount+1)+"time");
		 retryCount++;
		 return true;
		
		 
		}
		return false;
		
	}

	private void log(String data) {
		// TODO Auto-generated method stub
		Reporter.log(data);
		
	}

	private String getResultStatusName(int status) {
		// TODO Auto-generated method stub
		String resultName = null;
		if(status==1)
			resultName = "SUCCESS";
		if(status==2)
			resultName = "FAILURE";
		if(status==3)
			resultName = "SKIP";
		
		return resultName;
	}

	
	
}
