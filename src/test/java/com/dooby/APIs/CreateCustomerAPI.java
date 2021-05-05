package com.dooby.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.dooby.APITestingFrameworksetUp.BaseTest;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseTest {

	public static Response sendPostRequestToCreateCustomerwithValidAuthKey(Hashtable<String, String> data) {

		String key = config.getProperty("validSecretKey");

		Response response = given().auth().basic(key, "").formParam("name", data.get("name"))
				.formParam("email", data.get("email")).formParam("description", data.get("description"))
				.post(config.getProperty("customerAPIEndpoint"));
		
		System.out.println(config.getProperty("customerAPIEndpoint"));
		
		return response;
	}

	public static Response sendPostRequestToCreateCustomerwithInValidAuthKey(Hashtable<String, String> data) {
		
		String key = config.getProperty("InvalidSecretKey");

		Response response = given().auth().basic(key, "").formParam("name", data.get("name"))
				.formParam("email", data.get("email")).formParam("description", data.get("description"))
				.post(config.getProperty("customerAPIEndpoint"));
		
		return response;

	}

}
