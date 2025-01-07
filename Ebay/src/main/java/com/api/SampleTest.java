package com.api;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTest {

	public static void main(String[] args) {
		
			JSONObject requestParams = new JSONObject();
//			requestParams.put("email", "amitp@dewsolutions.in");
//			requestParams.put("status", "Approved");
//			requestParams.put("subscriber_id", "dewapps");
			String myJson = "{\"phoneNumber\":\"353837986524\", \"messageContent\":\"test\"}";
			RestAssured.baseURI = "https://foregoing-aquatic-conifer.glitch.me";
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type", "application/json"); // Add the Json to the body of the request
			request.body(myJson.toString());
			Response response = request.post("/account_status");
			System.out.println("The status received: " + response.statusLine());
			System.out.println("The status received: " + response.statusCode());
//			System.out.println(RestAssured.given().body(myJson.toString()).post("/account_status").getStatusLine());
//			RestAssured.given().header("Content-Type", "application/json").body(myJson.toString()).when().post("/account_status").
//			then().assertThat().statusLine("HTTP/1.1 201 Created");
			
			
	}
}
