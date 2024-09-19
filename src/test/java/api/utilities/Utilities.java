package api.utilities;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

public class Utilities {

	// Generic validation method using JSONPath
	public static void validateJsonResponse(Response response, String jsonPath, Object expectedValue) {
		// Use the response body to assert based on the JSONPath and expected value
		response.then().body(jsonPath, equalTo(expectedValue));
	}

	// Method to get a random date in YYYY-MM-DD format within the current year up
	// to today
	public static String getRandomDate() {
		// Get today's date
		LocalDate today = LocalDate.now();

		// Get the first day of the current year (January 1st)
		LocalDate startOfYear = LocalDate.of(today.getYear(), 1, 1);

		// Generate a random number of days between the start of the year and today
		long randomDays = ThreadLocalRandom.current().nextLong(0, today.toEpochDay() - startOfYear.toEpochDay() + 1);

		// Add the random number of days to the start of the year
		LocalDate randomDate = startOfYear.plusDays(randomDays);

		// Define the date format (YYYY-MM-DD)
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// Return the formatted random date as a String
		return randomDate.format(formatter);
		
	}		 
		    public static int getArraySize(Response response) {		        		 
		        // Extract the response body as JsonPath
		        JsonPath jsonPath = response.jsonPath();
		 
		        // Get the size of the JSON array (without a label)
		        int size = jsonPath.getList("").size();  // Empty string "" targets the root array
		 
		        // Output the size of the array
				return size;
		    }
		
		
		
	}

	

