package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class POST_CreateUser {

	@Test
	public void createUser()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response resp = given()
		
		.header("Content-Type", "application/json")
		
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"TESTING\",\r\n"
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

}
