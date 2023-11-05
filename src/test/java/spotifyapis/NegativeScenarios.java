package spotifyapis;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class NegativeScenarios {
	
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void initReqAndResponseSpec()
	{
//		Defining the common properties for request:
		
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		
		requestSpecBuilder.setBaseUri("https://api.spotify.com/v1");
		
		requestSpecBuilder.addHeader("Content-Type", "application/json");
		
		requestSpecBuilder.addHeader("Authorization", "Bearer BQALPDoKFtSwqzp_Kx9pEY2imvW0b8ZXdLPZd-FftGJmtIIphaEO4lg0BP4nx7UgEVC6Xe7xK_pA0vubicp5gyWbUKd8QdZ8RiwUcYbXn7FpeZ0MXYcpYkRB8Y8RJZJRQJ-1sWHX1sVxprTZIR1cC3C3KqUEX_JieU0WRK7DmZGvQxuUKSzWZxadXWqh_sBAcx2Iz_hzlDrkien2zxQVGhCiTOguQfXIEL-DHEjqkksHEYKGkR35bSF3KzHq6Q6onqF4AebS7ZxTXcO0");
		
		requestSpecBuilder.log(LogDetail.ALL);
		
		requestSpecification = requestSpecBuilder.build();
		
//		Defining the common properties for response:	
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		
		responseSpecBuilder.log(LogDetail.ALL);
		
		responseSpecBuilder.expectContentType(ContentType.JSON);
				
		responseSpecification = responseSpecBuilder.build();
	
	}
	
	@Test(priority = 1)
	public void shouldNotBeAbleToCreatePlaylist()
	{

		given()
		
		.spec(requestSpecification)
		
		.body("{\r\n"
				+ "    \"name\": \"\",\r\n"
				+ "    \"description\": \"Evening songs mashup\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		
		.when()
		
		.post("/users/31oo5cxnykkangftexprunha4icy/playlists")
		
		.then()
		
		.spec(responseSpecification)
		
		.assertThat()
		
		.statusCode(400);
		
		}
	
	
	@Test(priority = 2)
	public void shouldNotBeAbleToAuthorize()
	{
RestAssured.baseURI= "https://api.spotify.com/v1";
		
		given()
		
		.log().all()
		
		.header("Authorization", "Bearer BQB9_kWVWNbCZm2_-dkmHMZBYPtEBG8NbbYVzu9Oln_FUMCw8o4i0h-FfGOLAVI6KapTzHnERKLnf9Xt1VLHg0Wf-aLk4O5-sQCl7gyQNctyaYDDq331re7YCgBtyRPz2BNgecREJbc2ytYN_UKidNevQpWFAdFnQxvhpRkmZrqwNnxqCXgJRaJGEih4bklnhToeRW5--Jz086vS9-tUppw1cZ9lDOa_gmX0LrCPYylcDzlqkMCtBXgCLTH0c7QrIAQQYc")
		
		.header("Content-Type", "application/json")

		.body("{\r\n"
				+ "    \"name\": \"Invalid Playlist\",\r\n"
				+ "    \"description\": \"Evening songs mashup\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		
		.when()
		
		.post("/users/31oo5cxnykkangftexprunha4icy/playlists")
		
		.then()
		
		.spec(responseSpecification)
		
		.assertThat()
		
		.statusCode(401);
		
	}

}
