package dataextraction;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.given;


public class GetOutputParameters {
	
	
	@Test 
	public void getUserDetails(){
		
		RestAssured.baseURI ="https://reqres.in";
		
		Response response = given()
		
		.when()
		
		.get("/api/users/2")
		
		.then()
		
		.extract()
		
		.response();
		
		System.out.println(response);
		
		String stringResponse = response.asPrettyString(); // to fetch the response in properly
		
		System.out.println(stringResponse);
		
		int statuscode = response.getStatusCode(); // to fetch the status code of the response
		
		System.out.println("Status code is :"+statuscode);
		
		Assert.assertEquals(statuscode, 200);
		
		long timeTaken = response.getTime();// to fetch the time taken to get the response
		
		System.out.println(timeTaken);
		
		Headers allheaderContent = response.getHeaders();

		List<Header> listOfHeaders = allheaderContent.asList();

		System.out.println(listOfHeaders);

		String value = response.getHeader("Content-Type");

		System.out.println(value);


		String statusline = response.getStatusLine();// this method provides the status line of the communication that comprises of http call, handshake mechanism used and status code with message

		System.out.println("status line is :"+statusline);


		String responseContent = response.getContentType();// this method to fetch the content type of the response received

		System.out.println(responseContent);
	}
	
	
	
	

}
