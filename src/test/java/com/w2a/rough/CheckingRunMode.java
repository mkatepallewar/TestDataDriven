package com.w2a.rough;

import com.w2a.utilities.DataUtil;
import com.w2a.utilities.ExcelReader;


public class CheckingRunMode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String suiteName="BankManagerSuite";
		boolean suiteRunMode=DataUtil.isSuiteRunnable(suiteName);
		System.out.println(suiteRunMode);
		
		
		String testCaseName="OpenAccountTest";
		boolean testRunmode=DataUtil.isTestRunnable(testCaseName, new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\"+suiteName+".xlsx"));
		System.out.println(testRunmode);
		
	}

}
