package com.RestAssured;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class RestAssuredBasicFeatures {
	
	//@Test(description="test case for successful status code")
	@SuppressWarnings("nls")
	public void testStatusCode() {
		RestAssured.given().get("https://jsonplaceholder.typicode.com/users")
		.then()
			.statusCode(200);
	}
	//@Test(description="test case for log all response on console")
	@SuppressWarnings("nls")
	public void testLogging() {
		RestAssured.given().get("https://jsonplaceholder.typicode.com/users")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	//@Test(description="test case for log all response on console")
	@SuppressWarnings("nls")
	public void testParamAndHeader() {
		RestAssured.given()
			.param("keys1", "values1")
			.header("headA","ValueA")
			.get("https://jsonplaceholder.typicode.com/users")
		.then()
			.statusCode(200);
	}
	//@Test(description="test case for EqualTo assertion")
	@SuppressWarnings("nls")
	public void testEqualToFunction() {
		RestAssured.given()
			.param("keys1", "values1")
			.header("headA","ValueA")
		.when()
			.get("https://jsonplaceholder.typicode.com/users/1")
		.then()
			.assertThat().body("name", equalTo("Leanne Graham"));
	}
	
	//@Test(description="test case for hasItems assertion")
	@SuppressWarnings("nls")
	public void testhasItemsFunction() {
		RestAssured.given()
			.get("https://jsonplaceholder.typicode.com/users/")
		.then()
			.body("id", hasItems(1,3,4,5));
	}
	
	//@Test(description="test case without root")
	@SuppressWarnings("nls")
	public void testWithoutRoot() {
			RestAssured.given()
				.get("https://jsonplaceholder.typicode.com/users/1")
			.then()
				.body("address.street", is("Kulas Light"))
				.body("address.suite", is("Apt. 556"))
				.body("address.city", is("Gwenborough"))
				.body("address.zipcode", is("92998-3874"))
				.body("address.geo.lat", is("-37.3159"))
				.body("address.geo.lng", is("81.1496"));
		}
	//put all common path in root// we can also detach the root
	@SuppressWarnings("nls")
	@Test(description="test case with root")
	public void testWithRoot() {
		RestAssured.given()
			.get("https://jsonplaceholder.typicode.com/users/1")
		.then().log().all().assertThat()
			.root("address")
			.body("street", is("Kulas Light"))
			.body("suite", is("Apt. 556"))
			.body("city", is("Gwenborough"))
			.body("zipcode", is("92998-3874"))
			.body("geo.lat", is("-37.3159"))
			.body("geo.lng", is("81.1496"));
	}
}
