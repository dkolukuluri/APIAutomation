package com.bmg360.apiautomation.apiendpoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Randomcodegenerator {

	public class RandomCityGenerator {
		// Map of US state codes to city names
		private static final Map<String, List<String>> US_CITIES_BY_STATE = new HashMap<>();

		static {
			US_CITIES_BY_STATE.put("CA",
					Arrays.asList("Los Angeles", "San Francisco", "San Diego", "Sacramento", "San Jose"));
			US_CITIES_BY_STATE.put("NY", Arrays.asList("New York City", "Buffalo", "Rochester", "Albany", "Syracuse"));
			US_CITIES_BY_STATE.put("TX", Arrays.asList("Houston", "Austin", "Dallas", "San Antonio", "Fort Worth"));
			US_CITIES_BY_STATE.put("FL", Arrays.asList("Miami", "Orlando", "Tampa", "Jacksonville", "Tallahassee"));
			US_CITIES_BY_STATE.put("IL", Arrays.asList("Chicago", "Springfield", "Naperville", "Peoria", "Rockford"));
			// Add more state codes and cities here as needed
		}

		// Method to get a random city for a given state code
		public static String getRandomUSCityByState(String stateCode) {
			List<String> cities = US_CITIES_BY_STATE.get(stateCode);
			if (cities == null || cities.isEmpty()) {
				throw new IllegalArgumentException("Invalid or unsupported state code: " + stateCode);
			}

			Random random = new Random();
			int randomIndex = random.nextInt(cities.size());
			return cities.get(randomIndex);
		}

		// Method to get a random state code from the map
		public static String getRandomUSStateCode() {
			Random random = new Random();
			List<String> stateCodes = new ArrayList<>(US_CITIES_BY_STATE.keySet());
			return stateCodes.get(random.nextInt(stateCodes.size()));
		}

	


	public static String generateRandomUSPhoneNumber() {
		Random random = new Random();

		int areaCode = 100 + random.nextInt(900);
		int centralOfficeCode = 100 + random.nextInt(900); 
		int lineNumber = 1000 + random.nextInt(9000); 
		return String.format("%03d-%03d-%04d", areaCode, centralOfficeCode, lineNumber);
	}
}
	
}
