package com.api;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FetchData {
	
	FetchAPIURL fetchAPIURL = new FetchAPIURL();
	
	
	public void fetchBitCoidDataFromAPI(String data)
	{
		RestAssured.baseURI = fetchAPIURL.getAPIEndPoints();
		Response response = RestAssured.given().when()
                .get("/currentprice.json")
                .then()
                .statusCode(200)  // Validating the status code
                .extract().response();
		 response.then()
            .body("bpi", notNullValue())
            .body("bpi.USD", notNullValue())
            .body("bpi.GBP", notNullValue())
            .body("bpi.EUR", notNullValue())

           //Validating the filed which we need to validate from BIP
            .body(data, equalTo("British Pound Sterling")); 
	}
	
	


}
