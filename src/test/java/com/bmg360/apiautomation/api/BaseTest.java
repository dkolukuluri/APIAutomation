package com.bmg360.apiautomation.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;

import api.utilities.ConfigManager;
import api.utilities.*;
import api.utilities.EmailSender;
import api.utilities.ResultsParser;

@Listeners(TestresultsListener.class)
public class BaseTest {

	protected RequestSpecification requestSpec;
	protected ResponseSpecification responseSpec;

	public BaseTest() {
		// Initialize the request specification
		System.out.println("URL :" + ConfigManager.getApiUrl());
		System.out.println(
				"Auth token " + ConfigManager.getAuthtoken().substring(1, ConfigManager.getAuthtoken().length() - 2));
		requestSpec = new RequestSpecBuilder().setBaseUri(ConfigManager.getApiUrl()) // Set the base URI for the API
				.addHeader("Content-Type", "application/json") // Common headers
				.addHeader("Authorization",
						ConfigManager.getAuthtoken().substring(1, ConfigManager.getAuthtoken().length() - 2))
				.build();

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
	public Response genericPost(String endpoint, String jsonPayload) {
		System.out.println("url :" + endpoint);
		return RestAssured.given().spec(requestSpec).body(jsonPayload).when().post(endpoint).then().extract()
				.response();
	}

	@AfterSuite           
	public void sendTestReport() throws IOException {
        Map<String, String> results = TestresultsListener.testResults;
        System.out.println("Accessing test results in @AfterSuite:");
       StringBuilder finalString = new StringBuilder();
       for (Map.Entry<String, String> entry : results.entrySet()) {
            String testName = entry.getKey();
            String testResult = entry.getValue();
            // Append each result to the StringBuilder
            finalString.append("<tr><td>"+testName+"</td><td>"+testResult+"</td></tr>");    
        }
       System.out.println("Final result " + finalString);
       String body = EditEmailableReport.editHTMLFile("custom-report.html",finalString);
       //String body = ResultsParser.parseAllureResults("custom-report.html");
		//Send email with the report summary as body
		EmailSender.sendEmail("dkolukuluri@bmg360.com", "updf lnly fabw garf",
				"dkolukuluri@bmg360.com,rcrecco@bmg360.com,jvalencia@bmg360.com  ", "API Health Check Report - 10.23.2024", body);
	}
}
