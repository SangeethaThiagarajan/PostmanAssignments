package services;

import static org.hamcrest.Matchers.containsString;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JiraTests extends BaseRequest{
	
	
	@Test
	public void getIncidents(){
		RestAssured.baseURI="https://sanjira123.atlassian.net/rest/api/3/search";
		  RestAssured.authentication=RestAssured.preemptive().basic("thiagarajansangeetha@gmail.com", "M3U2vnlaOmDcbWxul1FKECBD");
			
		RestAssured.given().log().all()
			.contentType(ContentType.JSON)
			.get()
			.then()
			.assertThat()
			.statusCode(200)
			.body(containsString("number"),containsString("id"))
			/*.extract().response()
			.prettyPrint()*/;	
	}
}
