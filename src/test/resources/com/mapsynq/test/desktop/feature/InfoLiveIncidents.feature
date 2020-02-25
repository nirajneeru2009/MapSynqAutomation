Feature: Display live incident details

@FunctionalTest
Scenario: Select an incident from Info panel incident list

Given User already navigated to url
Then User clicks on Live button
Then User clicks Incidents button on Live panel
Then User clicks on an incident
Then Display popup with correct incident details