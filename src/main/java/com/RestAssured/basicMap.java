package com.RestAssured;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class basicMap {
	
	@Test(description="test case number assertion")
	public void testAssertion() {
		RestAssured.given().get("https://jsonplaceholder.typicode.com/users")
		.then().assertThat().body("id[0]", equalTo(1)).body("username[2]", equalTo("Samantha"));
	}
	
	@Test(description="test case multiple number")
	public void testHasNumber() {
	RestAssured.given().get("https://jsonplaceholder.typicode.com/users")
		.then().assertThat().body("address.zipcode", hasItems(92998-3874, 90566-7771));
		
		/*Response response = RestAssured.given()
				.log().all().when().get("https://jsonplaceholder.typicode.com/users").then().log().all().extract().response();

		System.out.println(response.jsonPath().get("address.zipcode"));*/
	}

}
