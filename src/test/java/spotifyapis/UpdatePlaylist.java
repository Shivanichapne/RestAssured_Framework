package spotifyapis;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class UpdatePlaylist {
	
	
	@Test
	public void changeDetails()
	{
		RestAssured.baseURI = "https://api.spotify.com/v1";
		
		given()
		
		.header("Authorization", "Bearer BQB9_kWVWNbCZm2_-dkmHMZBYPtEBG8NbbYVzu9Oln_FUMJP3piiO-AaCw8o4i0h-FfGOLAVI6KapTzHnERKLnf9Xt1VLHg0Wf-aLk4O5-sQCl7gyQNctyaYDDq331re7YCgBtyRPz2BNgecREJbc2ytYN_UKidNevQpWFAdFnQxvhpRkmZrqwNnxqCXgJRaJGEih4bklnhToeRW5--Jz086vS9-tUppw1cZ9lDOa_gmX0LrCPYylcDzlqkMCtBXgCLTH0c7QrIAQQYc")
		
		.header("Content-Type", "application/json")
		
		.body("{\r\n"
				+ "    \"name\": \"06 oct Morning beats\",\r\n"
				+ "    \"description\": \"this is the test description\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		.when()
		
		.put("playlists/1ddFAbbTwo4TCtp2HJlC3d")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
	}

}
