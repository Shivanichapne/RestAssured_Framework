package spotifyapis;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class AddTrackToPlaylist {
	
	@Test
	public void addSong()
	{

		RestAssured.baseURI = "https://api.spotify.com/v1";
		
		given()
		
		.header("Authorization", "Bearer BQApAawxbyhc-DVHGz1JMceINYQmGsxcjIXFPbDj3FY5WINoyVqvtcD8FkxtN_W3dzN4dx2iDknbKhuOmz3DuuzzXNblogfxWfriEtpVuBtllIM6kP1FicIzNGfQNLD68dqt596XGEmLPfDtAYFGq2LzVyPSn7KVnml4yPcRjrk8KQXCCXk5GTZLaG7JR4xv3btTibZ0NSysjai6imIO-ZvtmUtxWoC0qxSkdZuCnkwNsTvQiZhRTK9QRdOJT58rjQUFCWcev8Twhiv0")
		
		.header("Content-Type", "application/json")
		
		.body("{\r\n"
				+ "    \"uris\": [\r\n"
				+ "        \"spotify:track:5RAZtbW6hkkVG4cMGPO6f2\"\r\n"
				+ "    ],\r\n"
				+ "    \"position\": 0\r\n"
				+ "}")
		.when()
		
		.post("playlists/31oo5cxnykkangftexprunha4icy/tracks")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
	}
	

}
