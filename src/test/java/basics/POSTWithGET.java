package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class POSTWithGET {
	
	@Test
	public void createUser()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response resp = given()
		
		.header("Content-Type", "application/json")
		
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"TESTINGThree\",\r\n"
				+ "  \"firstName\": \"test\",\r\n"
				+ "  \"lastName\": \"user\",\r\n"
				+ "  \"email\": \"testuser@gmail.com\",\r\n"
				+ "  \"password\": \"mnbv@1234\",\r\n"
				+ "  \"phone\": \"1234567890\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}")
		
		.when()
		
		.post("/user")
		
		.then()
		
		.extract()
		
		.response();
		
	String stringOutput	= resp.asPrettyString();
	
	
	System.out.println(stringOutput);
		
		
	}
	@Test
	public void getUserDetails()
	{
RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response resp = given()
		
		.when()
		
		.get("/user/TESTINGThree")
		
		.then()
		
		.extract()
		
		.response();
				
		
		String value = resp.asPrettyString();
		
		System.out.println(value);
				
	}

}
