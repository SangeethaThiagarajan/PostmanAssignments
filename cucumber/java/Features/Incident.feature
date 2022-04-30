Feature: Incident Management

Scenario: Get an existing incident

Given Setup the endpoint
And setup the authorization
When send the get request
Then confirm the status code as 200
And Print the response

#@DemoRun
Scenario Outline: Post -Create an incident

Given Setup the endpoint              
And setup the authorization         
When send the Post request with description as '<descrip>' ,and short_description as '<shortdesc>'      
Then confirm the status code  as 201
And Print the response 

Examples:
|descrip|shortdesc|
|Postman Create a Request1|With Description1|
|Postman Create a Request2|With Description2|
|Postman Create a Request3|With Description3|