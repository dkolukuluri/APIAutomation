package com.bmg360.apiautomation.apiendpoints;

public class Routes {
	
	
	public static String base_url ="https://impact-staging.2nd.co";
	
	// Pre-transfer Management Post method
	
	public static String pretransfer_post_url = "/api/pretransfer";
	
	// Post transfer Management Post Method
	public static String posttransfer_post_url = "/api/posttransfer";
	
	//Real-Time call Management Post Method
	public static String realtimecall_post_url = "/api/callrealtime";
	
	//Concurrency Management Get Method
	public static String concurrency_get_url = "/api/concurrentcallers";
	
	public static String concurrencycaller_get_url = "/api/concurrentcallers/{concurrentcaller}";
	
	//Call Detail Management Get Method
	public static String calldetails_get_url = "/api/calldetails";
	
	public static String calldetail_get_url = "/api/calldetails/{calldetail}";
	
	//Data Recording
	public static String datarecording_get_url = "/api/record";
	
	public static String datarecording_post_url = "/api/record";
	
	//Lead Management for BP
	public static String leadmanagement_post_url = "/api/bplead";
	
	//Twilio Integration
	public static String twiliocallrealtime_post_url = "/api/twilio/callrealtime";
	
	public static String twiliotext_post_url = "/api/twilio/sms";
	
	public static String user_get_url = "/api/user";
	
	//Client and Payment Management
	public static String clientPayment_post_url = "/api/client/payment_method";
	
	public static String dailybudget_post_url = "/api/budgets/daily_budget";
	
	public static String storebudget_post_url = "/api/budgets/store";
	
	public static String createpaymentmethod_post_url = "/api/client/create_payment_method";
		
	public static String updatepaymentmethod_post_url = "/api/client/update_payment_method";
	
	public static String client_get_url = "/api/client";
	
	public static String client_post_url = "/api/client";
	
	public static String clientdetails_get_url = "/api/client/{client}";
	
	public static String clientdetails_put_url = "/api/client/{client}";
	
	public static String clientdetails_delete_url = "/api/client/{client}";
	
	// Ad Platform Management
	
	public static String facebook_get_url = "/api/facebook";
	
	public static String facebookdetails_get_url = "/api/facebook/{facebook}";
	
	public static String google_get_url = "/api/google";
	
	public static String googledetails_get_url = "/api/google/{google}";
	
	
	//Team Management 
	public static String teammanagement_get_url = "/api/team/{team}/user/{user}"; 
	  
	public static String teammanagement_post_url = "/api/team/{team}/clients"; 
	
	public static String teammanagement_delete_url = "/api/team{team}/clients{client}"; 
	
	//Transaction and Budget Management
	public static String transactions_get_url = "/api/transactions/{transaction}";
	
	public static String budgets_get_url = "/api/budgets";
	
	
	
}
