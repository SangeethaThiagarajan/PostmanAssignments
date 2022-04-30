package Steps_ChangeRequest;

import java.io.File;
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

public class ChangeRequest1 
{
	Response response;
	String id;
	File file=new File(".data/ChangeRequest.json");
	
	  @Given("Setup the endpoint")
		public void SetEnpointURl()
		{
			RestAssured.baseURI="https://dev113853.service-now.com/api/now/table/change_request/";
		}
		 
	  @And("setup the authorization")
		 public void SetAuthentication() 
		 {
			 RestAssured.authentication=RestAssured.basic("admin", "UjM4VfQz^9f@");
		 }

	  
	  @When("send the Post request with Category as {string} ,and short_description as {string}")
		 public void PostIncident(String category,String short_description) 
		 {
		  response=RestAssured.given().log().all()
				  .contentType(ContentType.JSON)//sending the req format
				  .accept(ContentType.JSON)//To Receive response in the Format
				  .body(file)
		          .post();
		  JsonPath path= response.jsonPath(); 
			id=path.get("sysid");
			 response.prettyPrint();
			 System.out.println("id is"+id);
		 }
	  @And("send the put request with changed description as {string}  and summary as {string}")
		 public void PutRequest(String description,String summary) 
		 {
		  response= RestAssured.given().log().all()
				  .contentType(ContentType.JSON)//sending the req format
				  .accept(ContentType.JSON)//To Receive response in the Format
				  .body("{\"fields\": {\"project\":{\"key\": \"SP\"},\"summary\": \""+summary+"\",\"description\": \""+description+"\",\"issuetype\": {\"name\": \"Bug\"}}}")
//			 System.out.println("id1 is"+id);
//		  System.out.println(id);
		  
		  .put(id);
		  System.out.println(response.getStatusCode());
		  response.prettyPrint();
		 }
		
	  @Then("confirm the status code  as {int}")
      public void ValidateResponseforPost(int code) 
      {
     	 response.then().assertThat().statusCode(code);
		 }
	  
	  @When("send the get request")
		 public void GetIncident() 
		 {
		  response= RestAssured.given().get();
		 }
		 
	  @Then("confirm the status code1 as {int}")
      public void ValidatetheResponseforGet(int code1) 
      {
     	 response.then().assertThat().statusCode(code1);
		 }
	  
	  @And("Print the response")
		 public void printResponse() 
		 {
			 response.prettyPrint();
		}
		 
	
}
