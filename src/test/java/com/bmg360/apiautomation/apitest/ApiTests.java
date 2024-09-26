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
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import com.bmg360.apiautomation.apiendpoints.Routes;

import com.bmg360.apiautomation.api.BaseTest;
import api.utilities.DatabaseUtils;
import api.utilities.Utilities;

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

	@Epic("BMG360 API Validations")
	@Feature("API Validations")
	@Story("Get Concurrent calls")
	@Severity(SeverityLevel.NORMAL)
	@Test

	public void test_GET_concurrentcalls() {

		Response response = getWithOutQueryParameters(Routes.concurrency_get_url);

		int statuscode = response.getStatusCode();
		System.out.println("Response from  : " + Routes.concurrency_get_url + ":" + statuscode);
		System.out.println("Response from  : " + Routes.concurrency_get_url + ":" + response.asString());
		Assert.assertEquals(statuscode, 200);
	}

	@Test
	public void test_GET_record() {

		Response response = getWithOutQueryParameters(Routes.datarecording_get_url);

		int statuscode = response.getStatusCode();
		System.out.println("Response from  : " + Routes.datarecording_get_url + ":" + statuscode);
		System.out.println("Response from  : " + Routes.datarecording_get_url + ":" + response.asString());
		Assert.assertEquals(statuscode, 200);
	}

	@Test
	public void test_GET_calldetails() {

		Response response = getWithOutQueryParameters(Routes.calldetails_get_url);

		int statuscode = response.getStatusCode();
		System.out.println("Response from  : " + Routes.calldetails_get_url + ":" + statuscode);
		System.out.println("Response from  : " + Routes.calldetails_get_url + ":" + response.asString());
		Assert.assertEquals(statuscode, 200);
	}

	@Test
	public void test_GET_user() {

		Response response = getWithOutQueryParameters(Routes.user_get_url);

		int statuscode = response.getStatusCode();
		System.out.println("Response from  : " + Routes.user_get_url + ":" + statuscode);
		System.out.println("Response from  : " + Routes.user_get_url + ":" + response.asString());
		Assert.assertEquals(statuscode, 200);
	}

	@Test
	public void test_GET_client() {

		Response response = getWithOutQueryParameters(Routes.client_get_url);

		int statuscode = response.getStatusCode();
		System.out.println("Response from  : " + Routes.client_get_url + ":" + statuscode);
		System.out.println("Response from  : " + Routes.client_get_url + ":" + response.asString());
		Assert.assertEquals(statuscode, 200);
	}

	@Test
	public void test_GET_calldetails_perday() {

		String randomdate = Utilities.getRandomDate();
		System.out.println("Random date :" + randomdate);

		String result = Routes.calldetail_get_url.replace("{calldetail}", randomdate.toString());
		Response response = getWithOutQueryParameters(result);

		int statuscode = response.getStatusCode();

		System.out.println("Response from  : " + Routes.calldetail_get_url + ":" + statuscode);
		System.out.println("Response from  : " + Routes.calldetail_get_url + ":" + response.asString());

		System.out.println("Size of the array : " + Utilities.getArraySize(response));
		Assert.assertEquals(statuscode, 200);
	}

	@Test
	public void test_GET_concurrentcallers() {

		int randomnumber = Utilities.GenerateRandomNumbers();
		System.out.println("Random integer: " + randomnumber);

		String str = Integer.toString(randomnumber);

		String result = Routes.concurrencycaller_get_url.replace("{concurrentcaller}", str);
		Response response = getWithOutQueryParameters(result);

		int statuscode = response.getStatusCode();
		System.out.println("Response from  : " + Routes.concurrencycaller_get_url + ":" + statuscode);
		System.out.println("Response from  : " + Routes.concurrencycaller_get_url + ":" + response.asString());

		Assert.assertEquals(statuscode, 200);
	}

	/*
	 * @Test public void test_GET_transactions() throws Exception {
	 * 
	 * String query =
	 * "select id, payable_type, payable_id, wallet_id, type, amount, case when confirmed =1 then 'true' else 'false' end confirmed, meta, uuid, created_at, updated_at from vapor.transactions where payable_id = 31;"
	 * ; String resultfromdb = dbutils.getresult_fromdb(query);
	 * utils.getlistofids(resultfromdb, "payable_id");
	 * 
	 * }
	 */
	
	
	@Test
	public void test_GET_user_id_team_id() throws Exception {

		String query = "select team_id, user_id from vapor.team_user where user_id  in (select user_id from vapor.teams) order  by team_id, user_id;";
		String resultfromdb = dbutils.getresult_fromdb(query);
		utils.gethashmapofids(resultfromdb, "team_id","user_id");

	}
	
	
	@Test
	public void test_GET_client_details() throws Exception {

		
		  int randomnumber = Utilities.GenerateRandomNumbers();
		  System.out.println("Random integer: " + randomnumber);
		  
		  String str = Integer.toString(randomnumber);
		  
		  String result = Routes.clientdetails_get_url.replace("{client}", str);
		  Response response = getWithOutQueryParameters(result);
		  
		  int statuscode = response.getStatusCode();
		  System.out.println("Response from  : " + Routes.clientdetails_get_url + ":" +
		  statuscode); System.out.println("Response from  : " +
		  Routes.clientdetails_get_url + ":" + response.asString());
		  
		  Assert.assertEquals(statuscode, 200);
		 
	}

}
