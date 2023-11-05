package serializationanddeserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.CreateUserRequestBody;
import pojo.CreateUserResponseBody;

public class CreateUserUsingSeriaDeseria {
	@Test
	public void createUser()
	{
		CreateUserRequestBody cs = new CreateUserRequestBody();
		
		cs.setId(0);
		cs.setUsername("Testusername");
		cs.setFirstName("Tom");
		cs.setLastName("Aveston");
		cs.setPassword("Test@1234");
		cs.setPhone("9876543210");
		cs.setEmail("test@test.com");
		cs.setUserStatus(0);
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";

            CreateUserResponseBody responseBody		= given()
		
								.header("Content-Type", "application/json")
		
								.body(cs)
								
								.log().all()
		
								.when()
		
								.post("/user")
		
								.then()
								
								.log().all()
			
								.extract()
		
								.response()
		
								.as(CreateUserResponseBody.class);

			String	message = responseBody.getMessage();

			System.out.println(message);
		
		
	}

}
