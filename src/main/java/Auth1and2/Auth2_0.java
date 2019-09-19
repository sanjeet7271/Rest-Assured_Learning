package Auth1and2;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Auth2_0 {
	Response resp,resp1;
	//@Test
	public void Test1() {
		resp=RestAssured.given()
		.auth()
		.oauth2("8c583ce34ebaf0862d1bfa4c8c09713e3a2d293b")
		.post("http://coop.apps.symfonycasts.com/api/397/chickens-feed");
		
		System.out.println("Code :"+resp.getStatusCode());
		System.out.println(resp.getBody().asString());
	}
	@Test
	public void test2() {
		Response resp=RestAssured.given()
				.formParam("client_id", "RestAutho2.0")
				.formParam("client_secret", "2eee786c212eab3e7bfc1773e8007e5c")
				.formParam("grant_type", "client_credentials")

				.post("http://coop.apps.symfonycasts.com/token");
				
				System.out.println("Code :"+resp.getStatusCode());
				System.out.println(resp.jsonPath().prettify());
				System.out.println(resp.getBody().asString());
				
				
				String accessToken=resp.jsonPath().get("access_token");
				System.out.println(accessToken);
				
			resp1=RestAssured.given()
				.auth()
				.oauth2(accessToken)
				.post("http://coop.apps.symfonycasts.com/api/397/chickens-feed");
				
			Assert.assertEquals(resp1.getStatusCode(), 200);
				
		
	}
}
