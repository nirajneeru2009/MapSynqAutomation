Feature: View incident location

@FunctionalTest
Scenario: Select an incident and view incident location on map

Given User already navigated to url in mobile browser
When User clicks on traffic road conditions button
Then Directs user to traffic road conditions page
Then User select an incident
Then Display incident location on map