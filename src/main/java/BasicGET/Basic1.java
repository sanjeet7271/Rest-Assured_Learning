package BasicGET;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Basic1 {
	@Test
	public void getUserDetail() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/users";
		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httprequest=RestAssured.given();
		// Make a GET request call directly by using RequestSpecification.get() method.
		 // Make sure you specify the resource name.
		Response response=httprequest.get("1");
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
}
