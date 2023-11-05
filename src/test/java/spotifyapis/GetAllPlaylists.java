package spotifyapis;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class GetAllPlaylists {
	
	
	@Test
	public void fetchPlaylist()
	{
		RestAssured.baseURI = "https://api.spotify.com/v1";
		
		given()
		
		.header("Authorization", "Bearer BQApAawxbyhc-DVHGz1JMceINYQmGsxcjIXFPbDj3FY5WINoyVqvtcD8FkxtN_W3dzN4dx2iDknbKhuOmz3DuuzzXNblogfxWfriEtpVuBtllIM6kP1FicIzNGfQNLD68dqt596XGEmLPfDtAYFGq2LzVyPSn7KVnml4yPcRjrk8KQXCCXk5GTZLaG7JR4xv3btTibZ0NSysjai6imIO-ZvtmUtxWoC0qxSkdZuCnkwNsTvQiZhRTK9QRdOJT58rjQUFCWcev8Twhiv0")
		
		.when()
		
		.get("users/31oo5cxnykkangftexprunha4icy/playlists")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
	}
	

}


