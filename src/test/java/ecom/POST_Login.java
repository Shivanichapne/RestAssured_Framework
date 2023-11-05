package ecom;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class POST_Login extends BaseData {
	
	@Test
	public void loginToApp()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
	Response	resp = given()
		
		.header("Content-Type", "application/json")
		
		.body("{\r\n"
				+ "  \"userEmail\": \"shivanichapne@gmail.com\",\r\n"
				+ "  \"userPassword\": \"Shivani@23\"\r\n"
				+ "}")
		.log().all()
		
		.when()
		
		.post("api/ecom/auth/login")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
	
	
	JsonPath jp = resp.jsonPath();
	
	tokenId = jp.getString("token");
		
	userId = jp.getString("userId");
	}

}
