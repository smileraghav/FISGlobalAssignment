package com.api;

import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateRequest {

//	CoreFunction coreFunction = new CoreFunction();
	FetchAPIURL fetchAPIURL = new FetchAPIURL();

	public void updateStatusAccountValidation() throws Exception {
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", "amitp@dewsolutions.in");
		requestParams.put("status", "Approved");
		requestParams.put("subscriber_id", "dewapps");
		RestAssured.baseURI = fetchAPIURL.getAPIEndPoints();
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json"); // Add the Json to the body of the request
		request.body(requestParams.toString());
		Response response = request.post("/account_status");
		System.out.println("The status received: " + response.statusLine());
	}

	public void updateStatusAccountCreation() throws Exception {
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", "amitp@dewsolutions.in");
		requestParams.put("phoneNumber", "0123456789");
		requestParams.put("status", "signup_completed");
		RestAssured.baseURI = fetchAPIURL.getAPIEndPoints();
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json"); // Add the Json to the body of the request
		request.body(requestParams.toString());
		Response response = request.post("/signup_status");
		System.out.println("The status received: " + response.statusLine());
	}
}
