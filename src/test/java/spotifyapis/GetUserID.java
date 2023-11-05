package spotifyapis;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class GetUserID {
	
	
	@Test
	public void getUserID()
	{
		RestAssured.baseURI = "https://api.spotify.com/v1";
		
		given()
		
		.header("Authorization", "Bearer BQCn6wU5pTFI1Ssn3tt-1wpOtwSZGFWb1SyvD_U_hfMOuiYi4BTbtkkpJeEUVbgYuRIaMSOxvDH90ht8tp8B9yvAEPztMT3SYZSIJkul-a1qN0cBiUfzmDnqibT47hR4MEMMCSHCeLX3pKdV4iS-n0-SWE-O8ePwnFHsOe-6_dbHyTIYyjyxNzWygxDapbUOugeYqLrE4vDys1mVjkivI2ucF_rm9p1WlcummBREvlXHNf3tifk2edQAT8UzxqhUXF3UFfFXr3A2OH7Y")
		
		.log().all()
		
		.when()
		
		.get("me")
		
		.then()
		
		.log().body()
		
		.extract()
		
		.response();
		
	}

}
