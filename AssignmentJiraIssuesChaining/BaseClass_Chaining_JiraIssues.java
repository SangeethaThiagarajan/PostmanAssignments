package AssignmentJiraIssuesChaining;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class BaseClass_Chaining_JiraIssues {
	public static String id;

	@BeforeMethod
	public void BaseMethod()
	{
		 RestAssured.baseURI="https://sanjira123.atlassian.net/rest/api/2/";
		    
		 RestAssured.authentication=RestAssured.preemptive().basic("thiagarajansangeetha@gmail.com","vfsiXpP4rg9YNXrXl73R15CE");
		    
		
	}
}
