package assertionsusage;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Example1 {
	
	
	
	@Test
	public void assertWorkspace()
	{
		RestAssured.baseURI = "https://api.getpostman.com";
		
		given()
		
		.header("X-Api-Key", "PMAK-6502740fbe424b1bfc6882ad-08166fa3e0eae4151332dce9e03bbbfef6")
		
		.when()
		
		.get("/workspaces")
		
		.then()
		
		.assertThat()
		
		.statusCode(200)
		
		.contentType(ContentType.JSON)
		
		.header("Connection", "keep-alive")
		
		.body("workspaces[2]", hasKey("id"))// verifying the 2nd index position of workspace array has id as a key or not
		
//		.body("workspaces.name", contains("My Workspace","Team Workspace","My Workspace", "ATT workspaceupdated version", "TestWorkspace", "Test Workspace", "ATTObjectWorkspace", "Manual Workspace", "Latest workspace123", "ATT batch Workspace2", "API Chaining", "Jsonobject", "Jsonobject"))
//	contains method is used to validate all values along with their position if any of the value is not present / position hasn't match then it will mark the test case as failed
		
		.body("workspaces.name", containsInAnyOrder("My Workspace","Team Workspace","My Workspace", "ATT workspaceupdated version", "TestWorkspace", "Test Workspace", "ATTObjectWorkspace", "Manual Workspace", "Latest workspace123", "ATT batch Workspace2", "API Chaining", "Jsonobject", "Jsonobject"))
//containsInAnyOrder will validate only the content values irrespective of their positions inside the array		
		
		.body("workspaces[3]", hasEntry("id", "49a6d85b-b710-4dc5-8cd9-5623707f809a"))
//		has entry method will validate the complete key and value of the specific path
		.body("workspaces[2].name", equalTo("My Workspace"))
//		equalTo method is used to validate the value of the defined path inside the body method
		
		.body("workspaces[2].name", equalToIgnoringCase("My WOrkspace"))
//		//		equalTo method is used to validate the value of the defined path inside the body method irrespective of their cases
		
		.body("workspaces.name", hasItems("My Workspace","Team Workspace","My Workspace"))
		.extract()
		
		.response();
		
	}
	
	
	

}