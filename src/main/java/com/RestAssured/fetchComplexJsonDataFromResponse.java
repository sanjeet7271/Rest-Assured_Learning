package com.RestAssured;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class fetchComplexJsonDataFromResponse {
	
	 public static Response getRequest(String endpoint) {
	
		 @SuppressWarnings("nls")
		Response response=RestAssured.given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
	                        when().get(endpoint).
	                        then().contentType(ContentType.JSON).extract().response();
		 
		 return response;
	    }
	 
	@SuppressWarnings("nls")
	public static void main(String[] args) {
		
		 Response response = getRequest("https://jsonplaceholder.typicode.com/users");

	        List<String> jsonResponse = response.jsonPath().getList("$");

	        System.out.println(jsonResponse.size());
	        //	1. match all username data 
	        String usernames=response.jsonPath().getString("username");
	        System.out.println(usernames);
	        //2. map first username from json
	        String username1 = response.jsonPath().getString("username[0]");
	        System.out.println(username1);
	        //3. map all username from json method 2
	        List<String> jsonResponse1 = response.jsonPath().getList("username");
	        System.out.println(jsonResponse1);
	        //map first username from json
	        System.out.println(jsonResponse1.get(1));
	        //
	        Map<String, String> company = response.jsonPath().getMap("company");
	        System.out.println(company.get("name"));
	        
	        //
	        Map<String, String> company1 = response.jsonPath().getMap("company[0]");
	        System.out.println(company1.get("name"));

	}

}
