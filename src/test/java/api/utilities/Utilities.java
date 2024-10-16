package api.utilities;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

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
		int size = jsonPath.getList("").size(); // Empty string "" targets the root array

		// Output the size of the array
		return size;
	}

	public static int GenerateRandomNumbers() {

		Random rand;
		rand = new Random();
		int randInt = rand.nextInt(50) + 1;

		return randInt;
	}

	// Method to validate JSON response using JSONPath
	public static List<String> getlistofids(String jsonResponse, String key) {
		// Use RestAssured's JsonPath to extract value based on jsonPath
		// Object actualValue = JsonPath.from(jsonResponse).get(jsonPath);

		List<String> ids = new ArrayList<String>();

		JSONArray jsonArray = new JSONArray(jsonResponse);

		int arraySize = jsonArray.length();
		for (int i = 0; i < arraySize; i++) {
			// Step 3: Get the first JSONObject from the array
			JSONObject firstObject = jsonArray.getJSONObject(i);
			// Step 4: Retrieve the "test_id" from the first
			Object firstTestId = firstObject.get(key);
			ids.add(firstTestId.toString());
			System.out.println("actual value : " + firstTestId.toString());
		}
		System.out.println("list of ids : " + ids);
		// Return whether the actual value matches the expected value
		return ids;
	}

	public static HashMap<String, List<String>> gethashmapofids(String jsonResponse, String key, String value) {
		List<String> ids = new ArrayList<String>();

        // Step 1: Convert the string into a JSONArray
        JSONArray jsonArray = new JSONArray(jsonResponse);
 
        // Step 2: Create a HashMap to store team_id and list of user_ids
        HashMap<String, List<String>> teamUserMap = new HashMap<>();
 
        // Step 3: Iterate through the JSONArray
        for (int i = 0; i < jsonArray.length(); i++) {
            // Get each JSONObject from the array
            JSONObject jsonObject = jsonArray.getJSONObject(i);
 
            // Extract the team_id and user_id
            String teamId = String.valueOf(jsonObject.getInt("team_id"));
            String userId = String.valueOf(jsonObject.getInt("user_id"));
 
            // If the team_id is already present in the map, add the user_id to the list
            if (!teamUserMap.containsKey(teamId)) {
                teamUserMap.put(teamId, new ArrayList<>()); // create a new list for this team_id
            }
 
            // Add the user_id to the list for this team_id
            teamUserMap.get(teamId).add(userId);
        }
 
        // Step 4: Print the resulting HashMap
        System.out.println("Team ID to List of User IDs:");
        for (String teamId : teamUserMap.keySet()) {
            System.out.println("Team ID: " + teamId + ", User IDs: " + teamUserMap.get(teamId));
        }
		return teamUserMap;
    }
}
	
