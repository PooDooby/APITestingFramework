package com.dooby.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Hashtable;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.dooby.APITestingFrameworksetUp.BaseTest;

import com.dooby.APIs.DeleteCustomerAPI;
import com.dooby.listeners.ExtentListeners;

import io.restassured.response.Response;
import utilities.DataUtil;
import utilities.TestUtil;

public class DeleteCustomerTest extends BaseTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "exceldata")
	public void deleteCustomer(Hashtable<String, String> data) {

		Response response = DeleteCustomerAPI.sendDeleteRequestToCustomerAPIwithValidId(data);
		
		ExtentListeners.testReport.get().info(data.toString());

		response.prettyPrint();
		
		/*
		 * String actual_id = response.jsonPath().get("id").toString();
		 * 
		 * System.out.println("Getting id from the response: " + actual_id);
		 * 
		 * assertEquals(actual_id, data.get("id"), "ID mismatch !!!!");
		 */
		
		/*
		 * JSONObject jObject = new JSONObject(response.asString());
		 * 
		 * assertTrue(jObject.has("id"),"the ID is not Present !!!");
		
		
		String actual_id = jObject.get("id").toString();  */
		
		System.out.println("Presence check for Object key" + TestUtil.jsonHasKey(response.asString(), "object"));
		
		System.out.println("Presence check for Deleted key" + TestUtil.jsonHasKey(response.asString(), "deleted"));
		
		
		assertTrue(TestUtil.jsonHasKey(response.asString(),"id"), "ID mismatch !!");
		
		String actual_id =  TestUtil.getJsonKeyValue(response.asString(), "id");
		
		assertEquals(actual_id, data.get("id"), "The id is not matched !!!!");
		
		System.out.println("Object key value is :" + TestUtil.getJsonKeyValue(response.asString(), "object"));
		
		System.out.println("Deleted key value is :" + TestUtil.getJsonKeyValue(response.asString(), "deleted"));
		
		Assert.assertEquals(response.statusCode(), 200);
		
		System.out.println(response.statusCode());
	}

}
