Feature: Jira

Scenario Outline: Create an issue

Given Setup the endpoint              
And setup the authorization         
When send the Post request with description as '<descrip>' ,and summary as '<summary>'      
Then confirm the status code  as 201
And send the put request with changed description as '<descrip>' ,and summary as '<summary>'  
Then confirm the status code  as 204
And delete the Updated issue
And Print the response 

Examples:
|descrip|summary|
|Create a Request1|Issue1|
|Create a Request2|Issue2|
|Create a Request3|Issue3|
|Updated Description|Updated Issue|