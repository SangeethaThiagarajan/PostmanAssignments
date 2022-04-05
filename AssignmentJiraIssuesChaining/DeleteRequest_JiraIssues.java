package AssignmentJiraIssuesChaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequest_JiraIssues extends BaseClass_Chaining_JiraIssues
{
	
	@Test(dependsOnMethods = "AssignmentJiraIssuesChaining.UpdateRequest_JiraIssues.Update_JiraIssues")
	public void Delete_JiraIssues()
	{
		Response res= RestAssured.given().log().all().delete("issue/"+id);

		res.prettyPrint();
		
		
		
	}

}
