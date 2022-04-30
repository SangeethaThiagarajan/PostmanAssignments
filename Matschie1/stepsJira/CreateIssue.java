package stepsJira;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.security.PublicKey;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
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

public class CreateIssue extends baseAPI
{
	String id;
	
	@Given("enable logs")
	public void setUp(){ 
		request = given().log().all();
	}
	  
	  @When("send the Post request with description as {string} and summary as {string}")
		 public void PostIssue(String description,String summary) 
		 {
		  response=request
				  .contentType(ContentType.JSON)//sending the req format
				  .accept(ContentType.JSON)//To Receive response in the Format
				  .body("{\"fields\": {\"project\":{\"key\": \"SP\"},\"summary\": \""+summary+"\",\"description\": \""+description+"\",\"issuetype\": {\"name\": \"Bug\"}}}")
		          .post("issue");
		  JsonPath path= response.jsonPath(); 
			 id=path.get("id");
			 response.prettyPrint();
			 System.out.println("id is"+id);
		 }
	  
	  @And("send the put request with changed description as {string}  and summary as {string}")
		 public void PutRequest(String description,String summary) 
		 {
		  response= request
				  .contentType(ContentType.JSON)//sending the req format
				  .accept(ContentType.JSON)//To Receive response in the Format
				  .body("{\"fields\": {\"project\":{\"key\": \"SP\"},\"summary\": \""+summary+"\",\"description\": \""+description+"\",\"issuetype\": {\"name\": \"Bug\"}}}")
//			 System.out.println("id1 is"+id);
//		  System.out.println(id);
		
		  .put("issue/"+id);
		  System.out.println(response.getStatusCode());
		  response.prettyPrint();
		 }
		

	  @Then("confirm the status code  as {int}")
      public void ValidateResponse(int code) 
      {
		 
     	 response.then().assertThat().statusCode(code);
     	 
		 }
	  
	  @And("get all issues in Jira")
	  public void GetallRequest()
	  {
		  RestAssured.baseURI="https://sanjira123.atlassian.net/rest/api/3/search/";
		  RestAssured.authentication=RestAssured.preemptive().basic("thiagarajansangeetha@gmail.com", "M3U2vnlaOmDcbWxul1FKECBD");
			 
		  RequestSpecification input= RestAssured
					 //Gherkin Condition
					 .given()
					 .log().all().accept(ContentType.JSON);
			 //Save Request 
			 response= input.get();
			
	  }
	
	  @And("Print the response")
		 public void printResponse() 
		 {
			 response.prettyPrint();
		}
		 
	 
	
}
