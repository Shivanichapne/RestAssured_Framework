package dataextraction;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class DataExtractFromResponse {

	
	@Test
	public void getDataFromResponse()
	{
		RestAssured.baseURI = "https://reqres.in";
		
		Response response = given()
			
			.when()
			
			.get("/api/users/2")
			
			.then()
			
			.extract()
			
			.response();
			
//fetching the data
			
		
		JsonPath jp = response.jsonPath();
			
		String firstname = jp.getString("data.first_name");
		
		System.out.println(firstname);
		
		
		String text= jp.getString("support.text");
		
		System.out.println(text);
	}


}
