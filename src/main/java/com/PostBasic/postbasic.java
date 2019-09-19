package com.PostBasic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class postbasic {
	@SuppressWarnings("nls")
	@Test
	public void testEqualToFunction() {
			RestAssured.given()
			.param("id", "")
			.param("name", "abc")
			.param("username", "values")
			.param("email", "asd@gmail.com")
			.param("phone", "13233211212").log().all()
		.when()
			.post("https://jsonplaceholder.typicode.com/users")
		.then()
			.log().all();
			
	}

}
