package com.bmg360.apiautomation.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import api.utilities.ConfigManager;

public class BaseTest {

	protected RequestSpecification requestSpec;
	protected ResponseSpecification responseSpec;
	

	public BaseTest() {
		// Initialize the request specification
		System.out.println("URL :" + ConfigManager.getApiUrl());
		System.out.println("Auth token " + ConfigManager.getAuthtoken().substring(1, ConfigManager.getAuthtoken().length()-2));
		requestSpec = new RequestSpecBuilder().setBaseUri(ConfigManager.getApiUrl()) // Set the base URI for the API
				.addHeader("Content-Type", "application/json") // Common headers
				.addHeader("Authorization", ConfigManager.getAuthtoken().substring(1, ConfigManager.getAuthtoken().length()-2)).build();

		// Initialize the response specification
		responseSpec = new ResponseSpecBuilder()
				// .expectContentType("application/json") // Expect JSON responses
				// .expectStatusCode(200) // Default status code
				.build();

	}

	public Response getWithQueryParameters(String endpoint, Map<String, ?> queryParams) {
		return RestAssured.given().spec(requestSpec).queryParams(queryParams).when().get(endpoint).then()
				.spec(responseSpec).extract().response();
	}

	public Response getWithOutQueryParameters(String endpoint) {
		return RestAssured.given().spec(requestSpec).when().get(endpoint).then().spec(responseSpec).extract()
				.response();
	}
	
	// Generic POST method
	public  Response genericPost(String endpoint, String jsonPayload) { 
		System.out.println("url :" + endpoint);
		return RestAssured.given().spec(requestSpec).body(jsonPayload).when().post(endpoint).then() .extract().response();
		}
	}
		


