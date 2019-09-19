package com.VerifyObjects;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;import io.restassured.http.ContentType;

public class VerificationObjects {

	//@Test
	public void verifyObjects() {
			RestAssured.given().contentType(ContentType.JSON).
				get("https://jsonplaceholder.typicode.com/users")
				.then().log().all();
	}
	@Test
	public void verifyObjects1() {
		RestAssured.given()
		.get("https://jsonplaceholder.typicode.com/users/")
	.then()
		.body("id", hasItem(1))
		.content("id", hasItem(1));
	}
}
