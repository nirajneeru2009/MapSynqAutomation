Feature: Create new mapSYNQ account 

@FunctionalTest
Scenario: Create new mapSYNQ account using valid data

Given User already navigated to url
When User clicks on Register link
Then Directs user to Register page
Then User enters valid details and click on create profile button
Then System registers new user successfully 