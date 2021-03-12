package com.rrr.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ReRunFailedTests_TestLevel implements IRetryAnalyzer{

	int numberOfTimesExecuted = 1;
	int numberOfRetries = 3;
	
	@Override
	public boolean retry(ITestResult result) {

		if(numberOfTimesExecuted < numberOfRetries) {
			numberOfTimesExecuted++;
			return true;
		}
		
		return false;
	}

}
