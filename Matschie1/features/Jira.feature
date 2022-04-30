Feature: Jira

Scenario: Create an issue

Given enable logs        
When send the Post request with description as 'description added' and summary as 'summary added'
Then confirm the status code  as 201
And send the put request with changed description as 'description updated'  and summary as 'summary updated'
Then confirm the status code  as 204
And get all issues in Jira
Then confirm the status code  as 200
And Print the response