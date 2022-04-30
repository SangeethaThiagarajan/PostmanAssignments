Feature: Change Request



Scenario Outline: Post -Create a Record in Change Request

Given Setup the endpoint              
And setup the authorization         
When send the Post request with Category as '<category>' ,and short_description as '<short_description>'      
Then confirm the status code  as 201
And Print the response 

Examples:
|category|short_description|
|Software|To add With Description1|
|Hardware|To add With Description2|

Scenario: Get all Change Request

Given Setup the endpoint
And setup the authorization
When send the get request
Then confirm the status code1 as 200
And Print the response