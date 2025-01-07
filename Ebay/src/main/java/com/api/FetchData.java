package com.api;
import static org.junit.Assert.*;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FetchData {
	
	FetchAPIURL fetchAPIURL = new FetchAPIURL();
	
	
	public String fetchCreateAccountDataFromAPI()
	{
		RestAssured.baseURI = fetchAPIURL.getAPIEndPoints()+"/v1/bpi/currentprice.json"; 
		RequestSpecification httpRequest = RestAssured.given(); 
		Response response = httpRequest.get(RestAssured.baseURI);
		System.out.println(response.getBody().asString());
		return response.getBody().asString();
	}
	
	


}
