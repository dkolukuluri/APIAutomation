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

import com.bmg360.apiautomation.api.BaseTest;
import com.bmg360.apiautomation.apiendpoints.Routes;

import api.utilities.Utilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.hamcrest.Matchers.equalTo;

public class ApiTests extends BaseTest {
	

	
	
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
	public void test_GET_calldetails_perday() {
		
		String randomdate = Utilities.getRandomDate();
		System.out.println("Random date :" + randomdate);
		
        String result = Routes.calldetail_get_url.replace("{calldetail}", randomdate.toString());
		Response response = getWithOutQueryParameters(result);
		
		int statuscode = response.getStatusCode();
		
		System.out.println("Response from  : " + Routes.calldetail_get_url + ":" + statuscode);
		System.out.println("Response from  : " + Routes.calldetail_get_url + ":" + response.asString());
		
		System.out.println("Size of the array : " +Utilities.getArraySize(response));
		Assert.assertEquals(statuscode, 200);
		

	}
}
