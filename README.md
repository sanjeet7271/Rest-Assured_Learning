## Components of an HTTP request
**ANS** 
1. An HTTP method (Get, Put, Post, Delete, Patch, and Head) that defines the action.
2. A URI (Uniform Resource Identifier) is the resource’s identifier on the server.
3. An HTTP Version, e.g. HTTP v1.1.
4. The Request Header carries metadata (as key-value pairs) for the HTTP Request message. Client (or browser) type, client-supported formats, message body formats, cache settings, and other information are examples of metadata.
5. The Request Body represents the data sent by the client to the API.


## Some commonly used authentication methods in API testing
**ANS**
1. Session/cookies based authentication
2. Basic authentication
3. Digestive authentication
4. OAuth


## HTTP Methods
      GET: Used for retrieving data from a specified resource.
      POST: Used for submitting data to be processed to a specified resource.
      PUT: Used for updating a resource or creating a new resource if it doesn’t exist.
      DELETE: Used for requesting the removal of a resource.
      PATCH: Used for applying partial modifications to a resource.
      OPTIONS: Used for describing the communication options for the target resource.
      HEAD: Similar to GET, retrieving only the headers, not the actual data.

## Explain Rest-assured Code
                        RestAssured.baseURI = resource.getBaseURI();
                        			response = RestAssured.given().relaxedHTTPSValidation().headers("Authorization",AccessTokens.AUTHORISATION).header("User-Token",AccessTokens.USER_TOKEN).pathParam("login", "gose").log().all().when().get(request+"{login}").then().extract().response();


## 'baseURL' and 'basePath' methods in REST Assured
            1. 'baseURI'(String baseUri) Method: Specifies the base path for the API.
            2. ‘basePath’(String basePath) Method: Specifies the base path for the API.
                     given()
                      .baseUri("https://api.example.com")
                      .basePath("/v1")
                  .when()
                      .get("/resource")
                  .then()
                .statusCode(200);
## Parameters in Rest-assured
      1. Query Parameter: We can use query parameters to control the data returned in endpoint resources. It appears at the end of the URL after the question mark (?) and helps us to control the set of items and properties in responses, and the order of the items returned.
      For ex: https://api.github.com/user/repos?sort=created&direction=desc
      2. Path Parameters: Path parameters are variables in a URL path. They are used to point to a specific resource within a collection. We can define multiple PATH parameters and each of them is represented by a curly brace {}.
      for Ex: https://api.github.com/users/:username/repos

## Filters
      Filters can be used to implement custom authentication schemes, session management, logging, etc. To create a filter you need to implement the io.restassured.filter.Filter interface
      given().filter(new MyFilter())

## How to Parse JSON Response
                                    {
                                        id: 1,
                                        name: "Leanne Graham",
                                        username: "Bret",
                                        email: "Sincere@april.biz",
                                        address: {
                                            street: "Kulas Light",
                                            suite: "Apt. 556",
                                            city: "Gwenborough",
                                            zipcode: "92998-3874",
                                            geo: {
                                                lat: "-37.3159",
                                                lng: "81.1496"
                                            }
                                        },
                                        phone: "1-770-736-8031 x56442",
                                        website: "hildegard.org",
                                        company: {
                                            name: "Romaguera-Crona",
                                            catchPhrase: "Multi-layered client-server neural-net",
                                            bs: "harness real-time e-markets"
                                        }
                                    }


                              import io.restassured.RestAssured;
                              import io.restassured.http.ContentType;
                              import io.restassured.parsing.Parser;
                              import io.restassured.response.Response;
                              import java.util.List;
                              import static io.restassured.RestAssured.given;
                              
                              public class RestTest {
                              
                                  public static Response doGetRequest(String endpoint) {
                                      RestAssured.defaultParser = Parser.JSON;
                              
                                      return
                                          given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                                              when().get(endpoint).
                                              then().contentType(ContentType.JSON).extract().response();
                                  }
                              
                                  public static void main(String[] args) {
                                      Response response = doGetRequest("https://jsonplaceholder.typicode.com/users");
                                      List<String> jsonResponse = response.jsonPath().getList("$");
                                      System.out.println(jsonResponse.size());
                                  }
                              }

                  1.) The $ notation which means the root element
                  2.) Parsing JSON Arrays and Lists: if we wanted to get the username of all entries, we could use
                  
                        String usernames = response.jsonPath().getString("username");
                        System.out.println(usernames);
                  3.) If we then want to get the username of the first entry we could use:
                              String usernames = response.jsonPath().getString("username[0]");
                  4.) Using a List we can use:
                        List<String> jsonResponse = response.jsonPath().getList("username");
                        System.out.println(jsonResponse.get(0));
                  5.) Parsing JSON ArrayList and HashMap Looking at the above JSON structure, the company is a map. If we only had one record, we could use:
                        Response response = doGetRequest("https://jsonplaceholder.typicode.com/users/1");
                        Map<String, String> company = response.jsonPath().getMap("company");
                        System.out.println(company.get("name"));

                  6.) But if the response returns an array and we want to extract the first company name, we could use:
                        Response response = doGetRequest("https://jsonplaceholder.typicode.com/users/");
                        Map<String, String> company = response.jsonPath().getMap("company[0]");
                        System.out.println(company.get("name"));
                  7.) we will write code to test user creation api.
                        Response response = given()
                                        .auth()
                                        .preemptive()
                                        .basic("MY_USERNAME", "MY_PASSWORD")
                                        .header("Accept", ContentType.JSON.getAcceptHeader())
                                        .contentType(ContentType.JSON)
                                        .body(validRequest)
                                        .post(path)
                                        .then().extract().response();
                                Assertions.assertEquals(201, createUser.getStatusCode());
                        
                                String username = response.jsonPath().get("username");
                                String email = response.jsonPath().get("email");
                                String name = response.jsonPath().get("name");
                                String id = response.jsonPath().get("id");

## What are different authentication types used in API's?

            🌟 Top 10 authentication types: 
            
            1️⃣ API Key Authentication:
            Each API request must include an API key, a unique identifier associated with the client making the request.
            Simple to implement but may lack the granularity of access control.
            
            2️⃣ Bearer Token Authentication (OAuth 2.0):
            Clients include an access token in the authorisation header of the HTTP request.
            Commonly used with OAuth 2.0, providing a standardised way to grant limited access to an HTTP service.
            
            3️⃣ Basic Authentication:
            Requires the client to include a username and password in the request header.
            Credentials are often Base64-encoded, but this method is not considered secure without additional encryption (e.g., using HTTPS).
            
            4️⃣ Digest Authentication:
            Similar to Basic Authentication but more secure as it sends hashed values rather than plain text passwords.
            Helps protect against certain types of attacks, but may still have vulnerabilities.
            
            5️⃣ OAuth 1.0:
            An older version of OAuth that uses a signature method to authenticate requests.
            Less commonly used in comparison to OAuth 2.0.
            
            6️⃣ JSON Web Tokens (JWT):
            A compact, URL-safe means of representing claims to be transferred between two parties.
            Often used for token-based authentication and includes information about the user and the permissions granted.
            
            7️⃣ OpenID Connect:
            An authentication layer on top of OAuth 2.0 that adds identity information to the token.
            Supports authentication and single sign-on (SSO) scenarios.
            
            8️⃣ Client Certificate Authentication:
            Involves the use of digital certificates on the client side for authentication.
            Provides a strong form of authentication but may be more complex to set up.
            
            9️⃣ API Tokens:
            Similar to API keys, but typically have a longer lifespan and are associated with a specific user or application.
            Used to authenticate the user or application making the API request.
            
            🔟 HMAC (Hash-based Message Authentication Code):
            Involves using a secret key to generate a hash value that is included in the request.
            Helps ensure the integrity and authenticity of the message.
