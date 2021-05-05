package com.dooby.APIs;

import static io.restassured.RestAssured.given;
import java.util.Hashtable;
import com.dooby.APITestingFrameworksetUp.BaseTest;
import io.restassured.response.Response;

public class DeleteCustomerAPI extends BaseTest {

	public static Response sendDeleteRequestToCustomerAPIwithValidId(Hashtable<String, String> data) {

		String key = config.getProperty("validSecretKey");
		System.out.println(data);

		Response response = given().auth().basic(key, "")
				.delete(config.getProperty("customerAPIEndpoint") + "/" + data.get("id"));

		return response;
	}

}
