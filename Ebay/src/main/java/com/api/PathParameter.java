package com.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PathParameter {
	
	public static void getUserUsingPathParameter(String userIDtoFetch) {
		String baseURI = "https://gorest.co.in/";
		String userID=userIDtoFetch;
		String endPoint = "/public/v2/users/{id}";
		RequestSpecification request =RestAssured.given();
		Response response =request.baseUri(baseURI).pathParam("id", userID)
				.when().get(endPoint).then().log().all().extract().response();
		System.out.println(response.getBody().asString().contains("Jagadisha Nambeesan"));
	}
	
	public static void postUsing() {
		
		String s= "{\"id\":148152,\"user_id\":7328416,\"title\":\"Vitiosus video terror deleo deripio.\",\"body\":\"Amet supra tyrannus. Tergeo certus tenuis. Architecto atqui solitudo. Cimentarius vilitas certus. Assentator verbera absens. Subito alias tego. Vorago quo delego. Aestivus vilicus volo. Virgo ulciscor amplus. Subito sumo verbum. Umbra dolorum attollo. Iste vere et. Aeger aetas spes. Caveo corrumpo quaerat. Et dolor quo.\"}";
		String baseURI = "https://gorest.co.in/";
		String userID="7328403";
		String endPoint = "/public/v2/users";
		RequestSpecification request =RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body(s.toString());
		Response response = request.baseUri(baseURI).post(endPoint);
		System.out.println(response.statusCode());
	}
	
	public static void main(String[] args) {
		postUsing();
//		getUserUsingPathParameter("0007");
	}

}
