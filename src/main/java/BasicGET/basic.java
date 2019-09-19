package BasicGET;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class basic {
	@Test
	public void getUserDetails() {
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/users";
		// Get the RequestSpecification of the request that you want to sent
		// to the server. The server is specified by the BaseURI that we have
		// specified in the above step.
		RequestSpecification httprequest=RestAssured.given();
		// Make a GET request call directly by using RequestSpecification.get() method.
		 // Make sure you specify the resource name.
		Response response=httprequest.request(Method.GET,"/1");
		 // Response.asString method will directly return the content of the body
		 // as String.	
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is ===>"+responseBody);
	}
}
