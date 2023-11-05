package specbuilder;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestAndResponseSpecBuilder {

	
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void initReqAndResponseSpec()
	{
//		Defining the common properties for request:
		
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		
		requestSpecBuilder.setBaseUri("https://petstore.swagger.io/v2");
		
		requestSpecBuilder.addHeader("Content-Type", "application/json");
		
		requestSpecBuilder.log(LogDetail.ALL);
		
		requestSpecification = requestSpecBuilder.build();
		
//		Defining the common properties for response:	
		
		ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
		
		responseSpecBuilder.expectStatusCode(200);
		
		responseSpecBuilder.log(LogDetail.ALL);
		
		responseSpecBuilder.expectContentType(ContentType.JSON);
				
		responseSpecification = responseSpecBuilder.build();
	
	}
	
	
	@Test
	public void createUser()
	{
			given(requestSpecification)
			
			.body("{\r\n"
					+ "  \"id\": 0,\r\n"
					+ "  \"username\": \"TestuserOne\",\r\n"
					+ "  \"firstName\": \"UserOne\",\r\n"
					+ "  \"lastName\": \"Aug\",\r\n"
					+ "  \"email\": \"userone@test.com\",\r\n"
					+ "  \"password\": \"Test@1234\",\r\n"
					+ "  \"phone\": \"9876543212\",\r\n"
					+ "  \"userStatus\": 0\r\n"
					+ "}")
			
			.when()
			
			.post("/user")
			
			.then()
			
			.spec(responseSpecification)
			
			.extract()
			
			.response();
			
				
		}
	
}
