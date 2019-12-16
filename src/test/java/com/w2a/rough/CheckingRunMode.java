package com.w2a.rough;

import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.TestUtil;

public class CheckingRunMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String suiteName="BankManagerSuite";
		boolean suiteRunMode=TestUtil.isSuiteRunnable(suiteName, new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\Suite.xlsx"));
		System.out.println(suiteRunMode);
		
		
		String testCaseName="OpenAccountTest";
		boolean testRunmode=TestUtil.isTestRunnable(testCaseName, new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\"+suiteName+".xlsx"));
		System.out.println(testRunmode);
		
		
		
	}

}