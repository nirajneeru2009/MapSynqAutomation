Feature: Info panel live tolls 

@FunctionalTest
Scenario: Check toll details from info panel - live tolls

Given User already navigated to url
Then User clicks on Live button
Then User clicks Tolls button on Live panel
Then User clicks on a toll
Then Display toll popup with correct toll name