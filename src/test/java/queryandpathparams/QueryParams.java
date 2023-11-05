package queryandpathparams;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class QueryParams {
	
	@Test
	public void passQuery()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
		Response resp = given()
		
		.queryParam("page", "2")
		
		.queryParam("page1", "3")
		
		.queryParam("page2", "4")
		
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
