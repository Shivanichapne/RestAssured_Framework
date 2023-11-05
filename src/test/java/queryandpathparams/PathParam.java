package queryandpathparams;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PathParam {
	
	@Test(enabled = false)
	public void applyPathParamMethod() {
		RestAssured.baseURI = "https://reqres.in/";

		Response response = given()
				
				.pathParam("numberValue", "2")
				

				.when()

				.get("/api/users/{numberValue}")

				.then()

				.extract()

				.response();
				
		System.out.println(response.asPrettyString());
	}

	
	@Test
	public void applyPathParam2() {
	
			RestAssured.baseURI = "https://reqres.in/";

			Response response = given()
					
					.pathParams("numberValue", "2", "alphabetValue", "3")

					.log().all()// this is used to print the request(header + requesturl) which we are sending
					
					.when()

					.get("/api/users/{numberValue}/{alphabetValue}")

					.then()
					
					.log().all()// this is used to print the response(header + response body) which we are sending
	
					.extract()

					.response();
					
			
		}

}
