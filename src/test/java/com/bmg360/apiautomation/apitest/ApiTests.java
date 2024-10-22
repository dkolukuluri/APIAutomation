package com.bmg360.apiautomation.apitest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import com.bmg360.apiautomation.apiendpoints.Randomcodegenerator.RandomCityGenerator;
import com.bmg360.apiautomation.apiendpoints.Requestpayloads;
import com.bmg360.apiautomation.apiendpoints.Routes;

import com.bmg360.apiautomation.api.BaseTest;
import api.utilities.DatabaseUtils;
import api.utilities.Utilities;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.hamcrest.Matchers.equalTo;

public class ApiTests extends BaseTest {

	DatabaseUtils dbutils = new DatabaseUtils();
	Utilities utils = new Utilities();
	SoftAssert softAssert = new SoftAssert();

	@Epic("API Health Check - Staging Environment")
	@Feature("API Health Check")
	@Story("API Health Check")
	@Severity(SeverityLevel.CRITICAL)


	
	  @Test
	  
	  public void test_GET_concurrentcalls() {	  
	  Response response = getWithOutQueryParameters(Routes.concurrency_get_url);	  
	  String statuscode = String.valueOf(response.getStatusCode());
	  Assert.assertEquals(statuscode, "200"); }
	  
	  @Test public void test_GET_record() {	  
	  Response response = getWithOutQueryParameters(Routes.datarecording_get_url);	  
	  String statuscode = String.valueOf(response.getStatusCode());
	  Assert.assertEquals(statuscode, "401"); }
	  
	    
	  @Test public void test_GET_user() {	  
	  Response response = getWithOutQueryParameters(Routes.user_get_url);	  
	  String statuscode = String.valueOf(response.getStatusCode());
	  Assert.assertEquals(statuscode, "200"); }
	  
	  @Test public void test_GET_client() {	  
	  Response response = getWithOutQueryParameters(Routes.client_get_url);
	  String statuscode = String.valueOf(response.getStatusCode());
	  Assert.assertEquals(statuscode, "200"); }
	  
	  @Test public void test_GET_calldetails_perday() {	  
	  String randomdate = Utilities.getRandomDate();
	  String result = Routes.calldetail_get_url.replace("{calldetail}", randomdate.toString()); 
	  Response response = getWithOutQueryParameters(result);	  
	  String statuscode = String.valueOf(response.getStatusCode());
	  Assert.assertEquals(statuscode, "200"); }
	  
	  @Test public void test_GET_concurrentcallers() {	  
	  int randomnumber = Utilities.GenerateRandomNumbers();
	  System.out.println("Random integer: " + randomnumber);	  
	  String str = Integer.toString(randomnumber);	  
	  String result = Routes.concurrencycaller_get_url.replace("{concurrentcaller}", str); 
	  Response response = getWithOutQueryParameters(result);	  
	  String statuscode = String.valueOf(response.getStatusCode());
	  Assert.assertEquals(statuscode, "200"); }
	  
	  @Test public void test_GET_transactions() {		  
		  int randomnumber = Utilities.GenerateRandomNumbers();
		  String str = Integer.toString(randomnumber);	  
		  String result = Routes.transactions_get_url.replace("{transaction}", str); 
		  Response response = getWithOutQueryParameters(result);	  
		  String statuscode = String.valueOf(response.getStatusCode());
		  Assert.assertEquals(statuscode, "200"); 
	  }
	 
	  @Test public void test_GET_userid_teamid() {
		  int team = 5;
		  int user = 3;
		  String teamId = Integer.toString(team);
		  String userId = Integer.toString(user);
		  String result = Routes.teammanagement_get_url.replace("{team}", teamId).replace("{user}", userId);
		  Response response = getWithOutQueryParameters(result); 
		  String statuscode = String.valueOf(response.getStatusCode());
		  Assert.assertEquals(statuscode, "200"); 		  
		  
	  }
	  
	  
	  @Test public void test_GET_clientdetails() {
		  int client = 9;
		  String clientid = Integer.toString(client);
		  String result = Routes.clientdetails_get_url.replace("{client}", clientid);
		  Response response = getWithOutQueryParameters(result); 
		  String statuscode = String.valueOf(response.getStatusCode());
		  Assert.assertEquals(statuscode, "200"); 		  
		  
	  }
	  
	  @Test   public void test_pretransfer_post_url() { String state =
			  RandomCityGenerator.getRandomUSStateCode(); String city_nm =
			  RandomCityGenerator.getRandomUSCityByState(state); String phone_number =
			  RandomCityGenerator.generateRandomUSPhoneNumber();			  
			  String url = Routes.pretransfer_post_url; 
			  String body = Requestpayloads.pretransfer.replace("{state}",state).replace("{city_nm}",
			  city_nm).replace("{phn_number}",phone_number);			  
			  Response response = genericPost(url,body);
			  
			  String statuscode = String.valueOf(response.getStatusCode());
			  Assert.assertEquals(statuscode, "204");
			  
			  }
	  
	  @Test   public void test_callrealtime_post_url() { 	  
			  String url = Routes.realtimecall_post_url; 
			  String body = Requestpayloads.callrealtime;			  
			  Response response = genericPost(url,body);			  
			  String statuscode = String.valueOf(response.getStatusCode());
			  Assert.assertEquals(statuscode, "200");
			  
			  }
	  
	  @Test   public void test_posttransfer_post_url() { 	  
		  String url = Routes.posttransfer_post_url; 
		  String body = Requestpayloads.posttransfer;			  
		  Response response = genericPost(url,body);			  
		  String statuscode = String.valueOf(response.getStatusCode());
		  Assert.assertEquals(statuscode, "204");
		  
		  }
	  
	  @Test   public void test_postrecord_post_url() { 	  
		  String url = Routes.datarecording_post_url; 
		  String body = Requestpayloads.apirecord;			  
		  Response response = genericPost(url,body);			  
		  String statuscode = String.valueOf(response.getStatusCode());
		  Assert.assertEquals(statuscode, "201");
		  
		  }
	
	  
	  @Test   public void test_client_post_url() { 	  
		  String url = Routes.client_post_url; 
		  String body = Requestpayloads.createclient;			  
		  Response response = genericPost(url,body);			  
		  String statuscode = String.valueOf(response.getStatusCode());
		  Assert.assertEquals(statuscode, "200");
		  
		  }

}

