package JiraIssues;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PostWithRequestBodyString 
{
@Test
public void PostReqWithBody()
{

	RestAssured.baseURI="https://sanjira123.atlassian.net/rest/api/2/issue";
	 
	 //Add Request
	 RestAssured.authentication=RestAssured.preemptive().basic("thiagarajansangeetha@gmail.com", "INFtLe6m4lqpsGSZtSEsD882");
	  
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
	  Response res=PreReq.post();
	   
	  System.out.println(res.statusCode());
	  
	  res.prettyPrint();
	
}
}