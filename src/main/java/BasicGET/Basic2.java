package BasicGET;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Basic2 {
	
	@Test
	public void getREasponseDataType() {
		RestAssured.baseURI="https://jsonplaceholder.typicode.com/users";
		RequestSpecification httprequest=RestAssured.given();
		
		Response response=httprequest.get("1");
		 // Reader header of a give name. In this line we will get
		 // Header named Content-Type
		String contentType=response.contentType();
		System.out.println("ContentType of NBody =>"+contentType);
		 // Reader header of a give name. In this line we will get
		 // Header named Server
		String serverType=response.header("server");
		System.out.println("server Type of Body =>"+serverType);
		 // Reader header of a give name. In this line we will get
		 // Header named Content-Encoding
		String acceptLanguage=response.header("Content-Encoding");
		System.out.println("Content Encoding =>"+acceptLanguage);
	}

}
