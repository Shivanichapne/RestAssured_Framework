package sendingbody;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class MockServerPost {

	
	@Test
	public void mockTest()
	{
		HashMap<String, String> hm1 = new HashMap<String, String>();
		
		hm1.put("id", "1000");
		hm1.put("type", "grains");
		
		HashMap<String, String> hm2 = new HashMap<String, String>();
		
		hm2.put("id", "1001");
		hm2.put("type", "beverage");
		
		List<HashMap<String, String>> mainObject = new ArrayList<HashMap<String,String>>();
		
		mainObject.add(hm1);
		mainObject.add(hm2);
		
		
		
		
		RestAssured.baseURI = "https://11373eed-b49b-48ff-ba24-d24fc6c83dc8.mock.pstmn.io";
		
		given()
		
		.header("Content-Type", "application/json")
		
		.header("x-mock-match-request-body", "true")
		
		.body(mainObject)
		
		.log().all()
		
		.when()
		
		.post("postcall")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		
	}
}
