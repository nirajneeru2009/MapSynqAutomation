Feature: Login in using username and password

@FunctionalTest
Scenario Outline: Sign in using valid username and password

Given User already navigated to url in mobile browser
When User clicks on Login button
Then Directs user to Login page
Then User enters valid "<username>" and "<password>" click on login button
Then User login successfully

Examples:
	| username				     | password |
	| nirajneeru2009@gmail.com	 | test1234 |