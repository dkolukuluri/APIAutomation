package com.bmg360.apiautomation.apiendpoints;

public class Requestpayloads {

	public static String pretransfer = "{\r\n" + "    \"phone_number\": \"{phn_number}\",\r\n"
			+ "    \"call_time\": \"1650475523243\",\r\n" + "    \"ivr_duration\": \"pre-transfer\",\r\n"
			+ "    \"transaction_id\": \"2A3B115F-46EE706F\",\r\n"
			+ "    \"call_record_id\": \"C06F-4687733DAC2E\",\r\n" + "    \"platform_client_id\": \"120613\",\r\n"
			+ "    // \"platform_camp_id\": ,\r\n" + "    \"call_source_description\": \"800-673-9986\",\r\n"
			+ "    \"mobile\": \"Landline\",\r\n" + "    //\"campaign_name\": ,\r\n"
			+ "    \"media_type\": \"Offline: Radio\",\r\n" + "    \"region\": \"{state}\",\r\n"
			+ "    \"destination_phone_number\": \"650-440-7366\",\r\n" + "    \"city\": \"{city_nm}\",\r\n"
			+ "    \"promo_line_description\": \"GBCT-79\",\r\n" + "    \"repeat_caller\": \"Yes\"\r\n" + "} ";
	
	
	public static String callrealtime = "{\r\n"
			+ "  \"city\": \"Greer\",\r\n"
			+ "  \"region\": \"US\",\r\n"
			+ "  \"zipcode\": \"29651\",\r\n"
			+ "  \"repeat_caller\": \"No\",\r\n"
			+ "  \"call_record_id\": \"C06F-4687733DAC2E\",\r\n"
			+ "  \"start_time_utc\": \"1650475523243\",\r\n"
			+ "  \"transaction_id\": \"2A3B115F-46EE706F\",\r\n"
			+ "  \"calling_phone_number\": \"864-768-5206\",\r\n"
			+ "  \"bundle_destination_ids\": [\r\n"
			+ "    0\r\n"
			+ "  ],\r\n"
			+ "  \"call_source_description\": \"800-673-9986\",\r\n"
			+ "  \"bundle_destination_ids_from_network\": [\r\n"
			+ "    \"\"\r\n"
			+ "  ],\r\n"
			+ "  \"optimize_rate\": 0,\r\n"
			+ "  \"advertiser_campaign_id_from_network\": \"\",\r\n"
			+ "  \"advertiser_campaign_name\": \"\"\r\n"
			+ "}";
	
	
	public static String posttransfer = "{\r\n"
			+ "  \"phone_number\": \"864-768-5205\",\r\n"
			+ "  \"call_time\": \"1728964912682\",\r\n"
			+ "  \"duration\": \"6279\",\r\n"
			+ "  \"connect_duration\": \"6279\",\r\n"
			+ "  \"ivr_duration\": \"0\",\r\n"
			+ "  \"transaction_id\": \"0464F32F-AA374A87\",\r\n"
			+ "  \"call_record_id\": \"0564-F3E8A4350A06\",\r\n"
			+ "  \"platform_client_id\": \"672013\",\r\n"
			+ "  \"platform_camp_id\": \"rr_9644044\",\r\n"
			+ "  \"hangup_cause\": \"Caller: Hang-up\",\r\n"
			+ "  \"call_source_description\": \"Bundled\",\r\n"
			+ "  \"mobile\": \"mobile\",\r\n"
			+ "  \"advertiser_campaign_name\": \"\",\r\n"
			+ "  \"transfer_from_type\": \"@@Advertiser Direct\",\r\n"
			+ "  \"corrected_at\": \"\",\r\n"
			+ "  \"media_type\": \"Offline: Radio\",\r\n"
			+ "  \"region\": \"CA\",\r\n"
			+ "  \"destination_phone_number\": \"800-675-8995\",\r\n"
			+ "  \"city\": \"Palmdale\",\r\n"
			+ "  \"promo_line_description\": \"NW-BMG-OEP24-W1-87\",\r\n"
			+ "  \"recordong_url\": \"\",\r\n"
			+ "  \"corrects_transaction_id\": \"\",\r\n"
			+ "  \"repeat_caller\": \"No\"\r\n"
			+ "}";
	
	
	public static String apirecord = "{\r\n"
			+ "  \"posted_data\": \"yes\"\r\n"
			+ "}";
	
	
	public static String createclient = "{\r\n"
			+ "  \"client\": \"ThinkNorth\",\r\n"
			+ "  \"company_id\": 25,\r\n"
			+ "  \"username\": \"thinknorth\",\r\n"
			+ "  \"password\": \"thinknorth!45\",\r\n"
			+ "  \"billingemail\": \"accounts@thinknorthusa.com\",\r\n"
			+ "  \"media_card_identifier\": \"\",\r\n"
			+ "  \"authnetprofileid\": \"\",\r\n"
			+ "  \"authnetpaymentprofileid\": \"\",\r\n"
			+ "  \"adID\": \"\",\r\n"
			+ "  \"viewID\": \"173939465\",\r\n"
			+ "  \"conversions\": \"Purchase\",\r\n"
			+ "  \"markup\": 15,\r\n"
			+ "  \"landingPages\": [\r\n"
			+ "    {\r\n"
			+ "      \"url\": \"\",\r\n"
			+ "      \"enabled\": 1,\r\n"
			+ "      \"created_at\": \"2024-10-07 15:31:34\",\r\n"
			+ "      \"updated_at\": \"2024-10-07 15:31:34\"\r\n"
			+ "    }\r\n"
			+ "  ],\r\n"
			+ "  \"acceptedTerms\": true\r\n"
			+ "}";
	
	
	public static String assignclientstoteam ="{\r\n"
			+ "  \"client_id\": 26\r\n"
			+ "}";
	
	
	public static String updateclient = "{\r\n"
			+ "  \"client\": \"ThinkNorth\",\r\n"
			+ "  \"company_id\": 26,\r\n"
			+ "  \"username\": \"thinknorth\",\r\n"
			+ "  \"password\": \"thinknorth!45\",\r\n"
			+ "  \"billingemail\": \"accounts@thinknorthusa.com\",\r\n"
			+ "  \"media_card_identifier\": \"\",\r\n"
			+ "  \"authnetprofileid\": \"\",\r\n"
			+ "  \"authnetpaymentprofileid\": \"\",\r\n"
			+ "  \"adID\": \"\",\r\n"
			+ "  \"viewID\": \"\",\r\n"
			+ "  \"conversions\": \"\",\r\n"
			+ "  \"markup\": 0,\r\n"
			+ "  \"landingPages\": [\r\n"
			+ "    {\r\n"
			+ "      \"url\": \"\",\r\n"
			+ "      \"enabled\": 1,\r\n"
			+ "      \"created_at\": \"\",\r\n"
			+ "      \"updated_at\": \"\"\r\n"
			+ "    }\r\n"
			+ "  ],\r\n"
			+ "  \"acceptedTerms\": true\r\n"
			+ "}";

}
