package steps;

import static io.restassured.RestAssured.given;

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

public class CreateIssue extends baseAPI
{
	Response response;
	String id;
	
	@Given("enable logs")
	public void setUp(){ 
		request = given().log().all();
	}
	  
	  @When("send the Post request with (.*)$ ,and (.*)$")
		 public void PostIssue(String description,String summary) 
		 {
		  response=request
				  .contentType(ContentType.JSON)//sending the req format
				  .accept(ContentType.JSON)//To Receive response in the Format
				  .body("{\"fields\": {\"project\":{\"key\": \"SP\"},\"summary\": \""+summary+"\",\"description\": \""+description+"\",\"issuetype\": {\"name\": \"Bug\"}}}")
		          .post("issue");
		  request.when().contentType(ContentType.JSON);
		 JsonPath path= response.jsonPath(); 
		 id=path.get("id");
		 }
	  
	  @And("send the put request with changed (.*)$ , and (.*)$")
		 public void PutRequest(String description,String summary) 
		 {
		  response= request
				  .contentType(ContentType.JSON)//sending the req format
				  .accept(ContentType.JSON)//To Receive response in the Format
				  .body("{\"fields\": {\"project\":{\"key\": \"SP\"},\"summary\": \""+summary+"\",\"description\": \""+description+"\",\"issuetype\": {\"name\": \"Bug\"}}}")
//			 System.out.println("id1 is"+id);
//		  System.out.println(id);
		
		  .put("issue/"+id);
		 }
		

	  @Then("confirm the status code  as {int}")
      public void ValidateResponse(int code) 
      {
		 
     	 response.then().assertThat().statusCode(code);
     	 
		 }
	  
	  @And("get all issues in Jira")
	  public void GetallRequest()
	  {
		  response= request.get();
	  }
	
	  
	  @And("Print the response")
		 public void printResponse() 
		 {
			 response.prettyPrint();
		}
		 
	 
	
}
