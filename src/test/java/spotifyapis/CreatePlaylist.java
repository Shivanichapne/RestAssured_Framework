package spotifyapis;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class CreatePlaylist {
	
	@Test
	public void createPlaylistOfUser()
	{
		RestAssured.baseURI= "https://api.spotify.com/v1";
		
		given()
		
		.log().all()
		
		.header("Authorization", "Bearer BQCn6wU5pTFI1Ssn3tt-1wpOtwSZGFWb1SyvD_U_hfMOuiYi4BTbtkkpJeEUVbgYuRIaMSOxvDH90ht8tp8B9yvAEPztMT3SYZSIJkul-a1qN0cBiUfzmDnqibT47hR4MEMMCSHCeLX3pKdV4iS-n0-SWE-O8ePwnFHsOe-6_dbHyTIYyjyxNzWygxDapbUOugeYqLrE4vDys1mVjkivI2ucF_rm9p1WlcummBREvlXHNf3tifk2edQAT8UzxqhUXF3UFfFXr3A2OH7Y")
		
		.header("Content-Type", "application/json")

		.body("{\r\n"
				+ "    \"name\": \"Evening Beats\",\r\n"
				+ "    \"description\": \"Evening songs mashup\",\r\n"
				+ "    \"public\": false\r\n"
				+ "}")
		
		.when()
		
		.post("/users/31oo5cxnykkangftexprunha4icy/playlists")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
	}

}
