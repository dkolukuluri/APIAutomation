package com.bmg360.apiautomation.api;



import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class BaseTest {

    protected RequestSpecification requestSpec;
    protected ResponseSpecification responseSpec;

    String staging_authtoken = "Bearer IBc7eKkoRDzHXXfCH58iXLjrnlEbz9klXeMkL8emc813f6c0";
    String production_authtoken = "Bearer pphEaszfBiJuOhvXerLycXAsfVLeuca7FsGNiqCv9518ad24";
    
    
    public BaseTest() {
        // Initialize the request specification
        requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://impact.2nd.co") // Set the base URI for the API
            .addHeader("Content-Type", "application/json") // Common headers
            .addHeader("Authorization", production_authtoken )
            .build();

        // Initialize the response specification
        responseSpec = new ResponseSpecBuilder()
            .expectContentType("application/json") // Expect JSON responses
            .expectStatusCode(200) // Default status code
            .build();
        
    }
        
   public Response getWithQueryParameters(String endpoint, Map<String, ?> queryParams) {
            return RestAssured.given()
                    .spec(requestSpec)
                    .queryParams(queryParams)
                    .when()
                    .get(endpoint)
                    .then()
                    .spec(responseSpec)
                    .extract().response();
        }  
 
   public Response getWithOutQueryParameters(String endpoint) {
       return RestAssured.given()
               .spec(requestSpec)
               .when()
               .get(endpoint)
               .then()
               .spec(responseSpec)
               .extract().response();
   }       
   
   
   
   
    }

