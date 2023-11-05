package authschemes;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class BearerToken {
	
	
	@Test
	public void listAllRepositories()
	{
		RestAssured.baseURI = "https://api.github.com";
		
		given()
		
		.log().headers()
		
		.headers("Accept", "application/vnd.github+json")
		
		.headers("Authorization", "Bearer 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")
		
		.headers("X-GitHub-Api-Version", "2022-11-28")	
		
		.when()
		
		.get("user/repos")
		
		.then()
		
		.log().body()
		
		.extract()
		
		.response();
	}

}
