package com.dooby.testcases;


import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.dooby.APITestingFrameworksetUp.BaseTest;
import com.dooby.APIs.CreateCustomerAPI;

import io.restassured.response.Response;
import utilities.DataUtil;

public class CreateCustomerTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "exceldata")
	public void ValidateCreateCustomerAPIwithValidSecretKey(Hashtable<String, String> data) {

		
		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerwithValidAuthKey(data);

		response.prettyPrint();

		assertEquals(response.statusCode(), 200);

		System.out.println(response.statusCode());
	}

	@Test(dataProviderClass = DataUtil.class, dataProvider = "exceldata")
	public void ValidateCreateCustomerAPIwithInValidSecretKey(Hashtable<String, String> data) {

		String key = config.getProperty("InvalidSecretKey");

		Response response = CreateCustomerAPI.sendPostRequestToCreateCustomerwithInValidAuthKey(data);

		response.prettyPrint();

		assertEquals(response.statusCode(), 401);

		System.out.println(response.statusCode());
	}

}
