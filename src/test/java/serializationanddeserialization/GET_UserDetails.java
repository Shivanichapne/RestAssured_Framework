package serializationanddeserialization;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.GetUserResponseBody;
import pojo.Support;
import io.restassured.RestAssured;
import pojo.Data;
import pojo.GetUserResponseBody;
import static io.restassured.RestAssured.given;

public class GET_UserDetails {
	
	
	@Test
	public void fetchUserDetails()
	{
		RestAssured.baseURI = "https://reqres.in";
		
			GetUserResponseBody response = given()
			
			.when()
			
			.get("/api/users?page=2")
			
			.then()
			
			.log().all()
			
			.extract()
			
			.response()
			
			.as(GetUserResponseBody.class);// deserialization
		
			
			Integer total_value = response.getTotal();
			
			System.out.println(total_value);
		
			
//			Assignment : WAP to fetch the value of 3rd index position's firstname from data array
	
			List<Data> listOfData = response.getData();
			
			Data dataObject = listOfData.get(3);
			
			String firstname = dataObject.getFirst_name();
			
			System.out.println(firstname);
			
			
//	Assignment: WAP to fetch the value of url from the received response
			
			Support support= response.getSupport();
			
			String text = support.getText();
			
			System.out.println(text);
	}
}
