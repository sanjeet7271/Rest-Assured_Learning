package Auth1and2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class twitterOAuth {
	/**
	 * Parameters:consumerKey,consumerSecret, accessToken, secretToken 
	 * 
	 */
	@Test
	public void postTweet() {
		Response response=RestAssured.given()
		.auth()
		.oauth("4TuBGqZGYfLRrYWh7jeLCQYUI",
				"AuRAPL4Q37tr05nhZwwnYCQeVe7Wd9Ih3PJOXv6bCDkI6PbEh3",
				"2527213070-GpfWxXXcmsDo6ZomeZpZNHaQiZir861OFshiRXC",
				"r4AZqkn4olNpLA3XUXrgJK3fGR0hxb2SGNiCtseIji2NV")
		.post("https://api.twitter.com/1.1/statuses/update.json?status=This is my 2nd Tweet via API");
		
		System.out.println("Response code :"+response.getStatusCode());
		System.out.println(response.getBody().jsonPath().prettify());
		JsonPath json=response.jsonPath();
		String tweetId=json.get("id_str");
		System.out.println("My tweet id is :"+tweetId);
		//Making URL for delete the tweet
		String deleteTweet="https://api.twitter.com/1.1/statuses/destroy/"+tweetId+".json";
		Response response1=RestAssured.given()
				.auth()
				.oauth("4TuBGqZGYfLRrYWh7jeLCQYUI",
						"AuRAPL4Q37tr05nhZwwnYCQeVe7Wd9Ih3PJOXv6bCDkI6PbEh3",
						"2527213070-GpfWxXXcmsDo6ZomeZpZNHaQiZir861OFshiRXC",
						"r4AZqkn4olNpLA3XUXrgJK3fGR0hxb2SGNiCtseIji2NV")
				.post(deleteTweet);
		System.out.println("Tweet deleted successfully :"+response1.getStatusCode());
		
	}

}
