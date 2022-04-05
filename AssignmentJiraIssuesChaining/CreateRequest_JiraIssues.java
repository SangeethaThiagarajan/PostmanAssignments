package AssignmentJiraIssuesChaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRequest_JiraIssues  extends BaseClass_Chaining_JiraIssues
{
	@Test
	public void CreateJiraIssue()
	{
		RequestSpecification PreReq= RestAssured.given().log().all()
				  .contentType(ContentType.JSON)//sending the req format
				  .accept(ContentType.JSON)//To Receive response in the Format
				  .body("{\r\n"
				  		+ "    \"fields\": {\r\n"
				  		+ "       \"project\":\r\n"
				  		+ "       {\r\n"
				  		+ "          \"key\": \"SP\"\r\n"
				  		+ "       },\r\n"
				  		+ "       \"summary\": \"Issue 1\",\r\n"
				  		+ "       \"description\": \"Updating an issue\",\r\n"
				  		+ "       \"issuetype\": {\r\n"
				  		+ "          \"name\": \"Bug\"\r\n"
				  		+ "       }\r\n"
				  		+ "   }\r\n"
				  		+ "}");
		  Response response1=PreReq.post("issue");
		  
		  JsonPath path= response1.jsonPath();
		  
		  id=path.get("id");
		  
		  System.out.println("id is "+id);
		   
		  System.out.println(response1.statusCode());
		  
		  response1.prettyPrint();
	}
}
