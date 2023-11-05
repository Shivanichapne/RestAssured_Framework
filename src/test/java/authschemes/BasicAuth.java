package authschemes;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class BasicAuth {

	@Test
	public void basicAuthTest()
	
	{
		RestAssured.baseURI = "https://postman-echo.com";
		
		given()
		
 //   	.header("Authorization", "Basic cG9zdG1hbjpwYXNzd29yZA==")
		
		.auth()
		
		.basic("postman", "password")
		
		.log().all()
		
		.when()
		
		.get("/basic-auth")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
	}
	
	
	
	
}
