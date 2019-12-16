package com.w2a.rough;

import com.w2a.utilities.Constants;
import com.w2a.utilities.ExcelReader;

public class ReadingExcelData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\BankManagerSuite.xlsx");
		int rows=excel.getRowCount(Constants.DATA_SHEET);
		System.out.println("Total rows are :" +rows);
		
		String testName="AddCustomertest";
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
		
		for (int rNum=dataStartRowNum;rNum<(dataStartRowNum+testRows);rNum++) {
			for(int cNum=0;cNum<testCols;cNum++) {
				System.out.println(excel.getCellData(Constants.DATA_SHEET, cNum, rNum));
			}
		}
	}

}
