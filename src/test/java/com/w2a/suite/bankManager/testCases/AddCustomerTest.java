package com.w2a.suite.bankManager.testCases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.utilities.Constants;
import com.w2a.utilities.DataUtil;
import com.w2a.utilities.ExcelReader;

public class AddCustomerTest {
	
	@Test(dataProvider = "getData")
	public void addCustomerTest(Hashtable<String, String> data) {
		
	}
	
	
	@DataProvider
	public Object[][] getData(){
	
		return DataUtil.getData("AddCustomerTest", new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\BankManagerSuite.xlsx"));
	}

}
