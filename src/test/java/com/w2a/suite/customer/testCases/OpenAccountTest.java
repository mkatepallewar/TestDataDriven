package com.w2a.suite.customer.testCases;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.utilities.Constants;
import com.w2a.utilities.DataProviders;
import com.w2a.utilities.DataUtil;
import com.w2a.utilities.ExcelReader;

public class OpenAccountTest {
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "customerDP")
	public void addCustomerTest(Hashtable<String, String> data) {
		
	}


}
