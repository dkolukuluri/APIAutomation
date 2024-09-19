package com.bmg360.apiautomation.apipayload;

public class Callrealtime {
	
	String city;
	String region;
	String zipcode;
	Boolean repeat_caller;
	String call_record_id;
	long start_time_utc;
	String transaction_id;
	String calling_phone_number;
	String bundled_destination_ids_from_network;
	int optimize_rate;
	String advertiser_campaign_id_from_network;
	String advertiser_campaign_name;

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Boolean getRepeat_caller() {
		return repeat_caller;
	}
	public void setRepeat_caller(Boolean boolean1) {
		this.repeat_caller = boolean1;
	}
	public String getCall_record_id() {
		return call_record_id;
	}
	public void setCall_record_id(String call_record_id) {
		this.call_record_id = call_record_id;
	}
	public long getStart_time_utc() {
		return start_time_utc;
	}
	public void setStart_time_utc(long start_time_utc) {
		this.start_time_utc = start_time_utc;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getCalling_phone_number() {
		return calling_phone_number;
	}
	public void setCalling_phone_number(String calling_phone_number) {
		this.calling_phone_number = calling_phone_number;
	}
	public String getBundled_destination_ids_from_network() {
		return bundled_destination_ids_from_network;
	}
	public void setBundled_destination_ids_from_network(String bundled_destination_ids_from_network) {
		this.bundled_destination_ids_from_network = bundled_destination_ids_from_network;
	}
	public int getOptimize_rate() {
		return optimize_rate;
	}
	public void setOptimize_rate(int optimize_rate) {
		this.optimize_rate = optimize_rate;
	}
	public String getAdvertiser_campaign_id_from_network() {
		return advertiser_campaign_id_from_network;
	}
	public void setAdvertiser_campaign_id_from_network(String advertiser_campaign_id_from_network) {
		this.advertiser_campaign_id_from_network = advertiser_campaign_id_from_network;
	}
	public String getAdvertiser_campaign_name() {
		return advertiser_campaign_name;
	}
	public void setAdvertiser_campaign_name(String advertiser_campaign_name) {
		this.advertiser_campaign_name = advertiser_campaign_name;
	}

	
	
	
}
