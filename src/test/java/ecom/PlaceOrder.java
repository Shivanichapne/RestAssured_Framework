package ecom;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PlaceOrder extends BaseData{
	
	
	@Test
	public void placeOrderTest ()
	{
		
		
		HashMap<String, String> hm = new HashMap<String, String>();
		
		hm.put("country", "India");
		hm.put("productOrderedId", prdId);
	
		
		List<HashMap<String, String>> value = new ArrayList<HashMap<String,String>>();
		
		value.add(hm);
		
		
		HashMap<String, Object > mainObject = new HashMap<String, Object>();
		
		mainObject.put("orders", value);
		
		RestAssured.baseURI = "https://www.rahulshettyacademy.com";
		
		given()
		
		.header("Content-Type", "application/json")
		
		.header("Authorization", tokenId)
		
		.log().all()
		
		.body(mainObject)
		
		.log().all()
		
		.when()
		
		.post("/api/ecom/order/create-order")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		
		
	}


}
