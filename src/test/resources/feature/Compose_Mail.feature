@Test 
Feature: Compose mail 
Scenario Outline: <TestCase> 
	Given User launches Gmail web application 
	When User clicks on signButton 
	And User enters EmailId in EmailTextField 
	And User clicks on NextButton 
	And User enters Password in PasswordTextField 
	And User clicks on NextButton 
	And user clicks on compose mail 
	And user enters receiver email id 
	And user enters subject 
	And user enters text email 
	And user clicks on send button 
	Then user verify success message  
	
	
	Examples: 
		| TestCase                   |
		| Create email |