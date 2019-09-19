package BasicGET;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Basic3 {
	@Test
	public void getHeaderType() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/users";
		RequestSpecification httprequest=RestAssured.given();
		
		Response response=httprequest.get("1");
		
		Headers headers=response.headers();
		
		for(Header header:headers) {
			System.out.println("Key : "+header.getName()+" Value : "+header.getValue());
		}
	}
}
