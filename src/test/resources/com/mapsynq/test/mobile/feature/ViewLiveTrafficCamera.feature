Feature: View live traffic camera image

@FunctionalTest
Scenario: Select a traffic camera and view live image

Given User already navigated to url in mobile browser
When User clicks on traffic camera button
Then Directs user to traffic cameras page
Then User clicks on a traffic camera
Then Systems displays live image