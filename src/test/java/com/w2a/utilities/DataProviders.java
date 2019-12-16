package com.w2a.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "bankManagerDP")
	public static Object[][] getDataSuite1(Method m){
		ExcelReader excel=new ExcelReader(Constants.SUITE1_XL_PATH);
		
		String testCase=m.getName();
		System.out.println(excel);
		System.out.println(testCase);
		return DataUtil.getData(testCase, excel);
	}
	
	@DataProvider(name = "customerDP")
	public static Object[][] getDataSuite2(Method m){
		ExcelReader excel=new ExcelReader(Constants.SUITE2_XL_PATH);
		
		String testCase=m.getName();
		return DataUtil.getData(testCase, excel);
	}


}
