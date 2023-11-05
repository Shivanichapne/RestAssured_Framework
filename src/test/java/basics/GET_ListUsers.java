package basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GET_ListUsers {
	
	
	@Test
	public void getUserDetails() {
		
		RestAssured.baseURI = "https://reqres.in";
		
		Response response = given()
			
			.when()
			
			.get("/api/users?page=2")
			
			.then()
			
			.extract()
			
			.response();
		
		System.out.println(response);
		
		String stringResponse = response.asPrettyString();
		
		System.out.println(stringResponse);
		
		
		
		
	}

	

}
