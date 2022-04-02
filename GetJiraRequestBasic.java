package JiraIssues;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestBasic 
{
 @Test
public void SendGetRequest()
{
	//Endpoint
	 RestAssured.baseURI="https://sanjira123.atlassian.net/rest/api/3/search";
	 
	 //Add Request
	 RestAssured.authentication=RestAssured.preemptive().basic("thiagarajansangeetha@gmail.com", "INFtLe6m4lqpsGSZtSEsD882");
	 RequestSpecification input= RestAssured
			 //Gherkin Condition
			 .given()
			 .log().all().accept(ContentType.JSON);
	 //Save Request 
	 Response response= input.get();
	 
	 //validate Response
	 int Statuscode=response.statusCode();
	 System.out.println(Statuscode);
	 
	 //to print entire body
	 response.prettyPrint();
}
}
