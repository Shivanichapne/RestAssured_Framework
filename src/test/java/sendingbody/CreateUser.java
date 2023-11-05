package sendingbody;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateUser {
	
	
	@Test
	public void createUser()
	{
		HashMap<String, Object> hm = new HashMap<String, Object>();
		
		hm.put("id", 0);
		hm.put("username", "25Septuser");
		hm.put("firstName", "Sept");
		hm.put("lastName", "Month");
		hm.put("email", "abc@test.com");
		hm.put("password", "Test@1234");
		hm.put("phone", "9876543210");
		hm.put("userStatus", 0);
		
		
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response resp = given()
		
		.header("Content-Type", "application/json")
		
		.body(hm)
		
		.log().all()
		
		.when()
		
		.post("/user")
		
		.then()
		
		.extract()
		
		.response();
		
	String stringOutput	= resp.asPrettyString();
	
	
	System.out.println(stringOutput);
	}

}
