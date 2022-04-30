package Steps;

import java.security.PublicKey;

import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IncidentManagement 
{
	Response response;
	
	  @Given("Setup the endpoint")
		public void SetEnpointURl()
		{
			RestAssured.baseURI="https://dev113853.service-now.com/api/now/table/incident";
		}
		 
	  @And("setup the authorization")
		 public void SetAuthentication() 
		 {
			 RestAssured.authentication=RestAssured.basic("admin", "UjM4VfQz^9f@");
		 }
		 
	  @When("send the get request")
		 public void GetIncident() 
		 {
		  response= RestAssured.given().queryParam("sysparm_fields", "category,sys_id,number,priority,description")
			        .get();
		 }
		 
	  @Then("confirm the status code as {int}")
         public void ValidatetheResponseforGet(int code1) 
         {
        	 response.then().assertThat().statusCode(code1);
		 }
	  
	  @When("send the Post request with description as {string} ,and short_description as {string}")
		 public void PostIncident(String description,String short_description) 
		 {
		  response=RestAssured.given().log().all()
				  .contentType(ContentType.JSON)//sending the req format
				  .accept(ContentType.JSON)//To Receive response in the Format
				  .body("{\"description\":\""+description+"\",\"short_description\":\""+short_description+"\"}")
		          .post();
		 }
		
	  @Then("confirm the status code  as {int}")
      public void ValidateResponseforPost(int code) 
      {
     	 response.then().assertThat().statusCode(code);
		 }
	  
	  @And("Print the response")
		 public void printResponse() 
		 {
			 response.prettyPrint();
		}
		 
	
}
