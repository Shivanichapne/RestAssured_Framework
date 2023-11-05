package queryandpathparams;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class MultiQueryParam {
	
	@Test
	public void useQueryParamsMethod()
	{
RestAssured.baseURI = "https://reqres.in/";
		
		Response resp = given()
		
		.queryParams("page", "2", "page2", "3", "page4", "5")
		
		
		.log().all()
		
		.when()
		
		.get("/api/users")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		
	String	stringResp = resp.asPrettyString();
	
	System.out.println(stringResp);
	}

}
