package stepDef;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.api.FetchData;

import genericFunction.GenericFunctions;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ApiStepDef {

	GenericFunctions generticFunctions = new GenericFunctions();
	FetchData fetchData = new FetchData();
	private static final Logger log = LoggerFactory.getLogger(LaunchWebSite.class);
	
	@When("As user I validate API response {string}")
	public void as_I_validate_api_response(String data) throws Exception {
		RestAssured.baseURI = "https://api.coindesk.com/v1/bpi/currentprice.json"; 
		RequestSpecification httpRequest = RestAssured.given(); 
		Response response = httpRequest.get(RestAssured.baseURI);
		System.out.println(response.getBody().asString());
		System.out.println("Validating "+data+" in api response");
		Assert.assertTrue(response.getBody().asString().contains(data));
	}
	
	

}
