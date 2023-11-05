package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilders {
	
	public static RequestSpecification reqSpec()
	{
	return new RequestSpecBuilder()
		
		.setBaseUri("https://api.spotify.com")
		
		.setBasePath("/v1")
		
		.addHeader("Authorization", "Bearer BQDC1czk_SlGgRz2wKE_6WdCm1IjJ4P_pDP4xZdpzOeDxlC04C6-bVWVEHg3NM89Cb1Z9w8y6HPbMDd5aC3r8RKO5imjwQl8KT9E0oFPwE1xcV86LQBB8a5LXs8Y1o1cN0UACclGEMU0UMVkgCG53u3LWQD-d4ffsDIFURItbu1ZusdaGfqrEKoBbAUvdfZdlJ_xylwprc8OvQR2pLLEHDbl2SLTRglpwmfRZwHFkIamG7QBmqU5VkGQhMIDkvzBQbk8f0HEUpakE3YS")
				
		.addHeader("Content-Type", "application/json")
		
		.log(LogDetail.ALL)
		
		.build();
			
	}
	
	
	public static ResponseSpecification resSpec()
	{
		return new ResponseSpecBuilder()
		
		.log(LogDetail.ALL)
		
		.expectContentType(ContentType.JSON)
				
		.build();
	}

}