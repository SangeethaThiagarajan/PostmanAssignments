package AssignmentJiraIssuesChaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateRequest_JiraIssues extends BaseClass_Chaining_JiraIssues
{
   @Test(dependsOnMethods = "AssignmentJiraIssuesChaining.CreateRequest_JiraIssues.CreateJiraIssue")
  public void Update_JiraIssues()
  {
	  RequestSpecification res=  RestAssured.given().log().all().contentType(ContentType.JSON).accept(ContentType.JSON)
	   .body("{\r\n"
	   		+ "    \"fields\": {\r\n"
	   		+ "        \"project\": {\r\n"
	   		+ "            \"key\": \"SP\"\r\n"
	   		+ "        },\r\n"
	   		+ "        \"summary\": \"Issue 1\",\r\n"
	   		+ "        \"description\": \"Creating of an issue123679y79\",\r\n"
	   		+ "        \"issuetype\": {\r\n"
	   		+ "            \"name\": \"Bug12\"\r\n"
	   		+ "        }\r\n"
	   		+ "    }\r\n"
	   		+ "}");
	   
	   Response response= res.put("issue/"+id);
	   
	   System.out.println("id is "+id);
		   
		  response.prettyPrint();
  }
	
	
}
