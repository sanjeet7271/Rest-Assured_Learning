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
