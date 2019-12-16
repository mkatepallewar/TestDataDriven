package com.w2a.utilities;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;

public class DataUtil {
	
	public static boolean isSuiteRunnable(String suiteName, ExcelReader excel) {
		
		int rows= excel.getRowCount(Constants.SUITE_SHEET);
		for (int rowNum=2;rowNum<=rows;rowNum++) {
			
			String data=excel.getCellData(Constants.SUITE_SHEET, Constants.SUITENAME_COL, rowNum);
			if (data.equals(suiteName)) {
				String runMode=excel.getCellData(Constants.SUITE_SHEET, Constants.RUNMODE_COL, rowNum);
				if (runMode.equals(Constants.RUNMODE_YES)) {
					return true;
				}else {
					return false;
				}
			}			
		}
		return false;
	}
	
	public static boolean isTestRunnable(String testCaseName, ExcelReader excel) {
		
		int rows= excel.getRowCount(Constants.TESTCASE_SHEET);
		for (int rowNum=2;rowNum<=rows;rowNum++) {
			
			String data=excel.getCellData(Constants.TESTCASE_SHEET, Constants.TESTCASE_COL, rowNum);
			if (data.equals(testCaseName)) {
				String runMode=excel.getCellData(Constants.TESTCASE_SHEET, Constants.RUNMODE_COL, rowNum);
				if (runMode.equals(Constants.RUNMODE_YES)) {
					return true;
				}else {
					return false;
				}
			}			
		}
		return false;
		
	}
	
	@DataProvider
	public static Object[][] getData(String testCase, ExcelReader excel){
		
		int rows=excel.getRowCount(Constants.DATA_SHEET);
		System.out.println("Total rows are :" +rows);
		
		String testName=testCase;
		int testCaseRowNum=1;
		
		//Find the test case start from
		for(testCaseRowNum=1;testCaseRowNum<=rows;testCaseRowNum++) {
			String testCaseName=excel.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);
			if(testCaseName.equalsIgnoreCase(testName)) {
				break;
			}
		}
		System.out.println("Test Case start from row num: "+testCaseRowNum);
		
		//checking total rows in test case
		
		int dataStartRowNum=testCaseRowNum+2;
		int testRows=0;
		while(!excel.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum+testRows).equals("")) {
			testRows++;
			
		}
		System.out.println("Total rows of data are: "+testRows);
		
		//checking total columns in test cases
		
		int dataStartColNum=testCaseRowNum+1;
		int testCols=0;
		while(!excel.getCellData(Constants.DATA_SHEET, testCols, dataStartColNum).equals("")) {
			testCols++;
			
		}
		System.out.println("Total columns of data are: "+testCols);
		
		//printing data
		int i=0;
		Object[][] data=new Object[testRows][1];
		for (int rNum=dataStartRowNum;rNum<(dataStartRowNum+testRows);rNum++) {
			Hashtable<String, String> table=new Hashtable<String, String>();
			
			for(int cNum=0;cNum<testCols;cNum++) {
				String testData=excel.getCellData(Constants.DATA_SHEET, cNum, rNum);
				String colName=excel.getCellData(Constants.DATA_SHEET, cNum, dataStartColNum);
				
				table.put(colName, testData);
			}
			data[i][0]=table;
			i++;
		}
		return data;
	}

}
