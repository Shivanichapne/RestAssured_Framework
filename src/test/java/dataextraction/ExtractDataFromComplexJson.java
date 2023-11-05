package dataextraction;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ExtractDataFromComplexJson {
	
	@Test
	public void getDataFromResponse()
	{
		RestAssured.baseURI = "https://reqres.in";
		
		Response response = given()
			
			.when()
			
			.get("api/users?page=2")
			
			.then()
			
			.extract()
			
			.response();
		
		
		JsonPath jp = response.jsonPath();
		
	String lastname = jp.getString("data[0].last_name");
	
	System.out.println(lastname);//lawson
	}
}
