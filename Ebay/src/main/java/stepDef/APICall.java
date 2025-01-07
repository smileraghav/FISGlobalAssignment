package stepDef;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APICall {
	
	public static void main(String[] args) {
		
			RestAssured.baseURI = "https://api.coindesk.com/v1/bpi/currentprice.json"; 
			RequestSpecification httpRequest = RestAssured.given(); 
			Response response = httpRequest.get(RestAssured.baseURI).then()
					.extract().body().path("bpi", "GBP");
			System.out.println(response);
//			System.out.println(response.getBody().asString());
//			System.out.println(response.getBody().jsonPath().get("USD").toString());
//			String s[] = response.getBody().asString().split("bpi");
//			System.out.println(s[1].sub);
//			return response.getBody().asString();
	}

}
