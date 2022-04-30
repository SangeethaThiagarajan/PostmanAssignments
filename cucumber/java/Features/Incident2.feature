Feature: Incident Management
Scenario: Get an existing incident

#Setup the Endpoint
Given Setup the endpoint

#setup the authorization
And setup the authorization

#send the req with get method
When send the get request

Then confirm the status code as 200

#print the response
And Print the response
