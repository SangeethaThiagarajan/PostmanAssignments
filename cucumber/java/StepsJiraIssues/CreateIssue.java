package StepsJiraIssues;

import java.security.PublicKey;

import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIssue 
{
	Response response;
	String id;
	
	  @Given("Setup the endpoint")
		public void SetEnpointURl()
		{
			RestAssured.baseURI="https://sanjira123.atlassian.net/rest/api/2/";
		}
		 
	  @And("setup the authorization")
		 public void SetAuthentication() 
		 {
		  RestAssured.authentication=RestAssured.preemptive().basic("thiagarajansangeetha@gmail.com","M3U2vnlaOmDcbWxul1FKECBD");
		 }

	  
	  @When("send the Post request with description as {string} ,and summary as {string}")
		 public void PostIssue(String description,String summary) 
		 {
		  RequestSpecification PreReq= RestAssured.given().log().all()
				  .contentType(ContentType.JSON)//sending the req format
				  .accept(ContentType.JSON)//To Receive response in the Format
				  .body("{\"fields\": {\"project\":{\"key\": \"SP\"},\"summary\": \""+summary+"\",\"description\": \""+description+"\",\"issuetype\": {\"name\": \"Bug\"}}}");
		 
		  response=PreReq.post("issue");
		 PreReq.when().contentType(ContentType.JSON);
		 JsonPath path= response.jsonPath(); 
		 id=path.get("id");
		 }
	  
	  @And("send the put request with changed description as {string} ,and summary as {string}")
		 public void PutRequest(String description,String summary) 
		 {
		  RequestSpecification PreReq= RestAssured.given().log().all()
				  .contentType(ContentType.JSON)//sending the req format
				  .accept(ContentType.JSON)//To Receive response in the Format
				  .body("{\"fields\": {\"project\":{\"key\": \"SP\"},\"summary\": \""+summary+"\",\"description\": \""+description+"\",\"issuetype\": {\"name\": \"Bug\"}}}");
//			 System.out.println("id1 is"+id);
//		  System.out.println(id);
		
		  response=PreReq.put("issue/"+id);
		 }
		

	  @Then("confirm the status code  as {int}")
      public void ValidateResponse(int code) 
      {
		 
     	 response.then().assertThat().statusCode(code);
     	 
		 }
	  
	  @And("delete the Updated issue")
	  public void DeleteRequest()
	  {
		  response= RestAssured.given().log().all().delete("issue/"+id);
	  }
	  
	  @And("Print the response")
		 public void printResponse() 
		 {
			 response.prettyPrint();
		}
		 
	 
	
}
