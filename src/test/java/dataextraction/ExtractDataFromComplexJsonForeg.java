package dataextraction;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ExtractDataFromComplexJsonForeg {
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
		
		String lastname = jp.getString("data[2].last_name");
		
		System.out.println(lastname);//Funke
		
		
		String email = jp.getString("data[0].email");
		System.out.println(email); // michael.lawson@reqres.in
		
		String email1 = jp.getString("data[1].email");
		System.out.println(email1);
		
		String email2 = jp.getString("data[2].email");
		System.out.println(email2);
		
		
		String email3 = jp.getString("data[3].email");
		System.out.println(email3);
		
		String email4 = jp.getString("data[4].email");
		System.out.println(email4);
		
		String email5 = jp.getString("data[5].email");
		System.out.println(email5);
		
		
			
		
	}
}
