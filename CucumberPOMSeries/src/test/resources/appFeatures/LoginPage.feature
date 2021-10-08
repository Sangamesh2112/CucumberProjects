Feature: Login Page Feature


Scenario: Login Page title 
Given user is on Login Page 
When user gets the title of the page 
Then Page title should be "Login - My Store"


Scenario: Forgot Password Link
Given user is on Login Page
Then forgot your password link should be displayed 


Scenario: Login with Correct Credentials 
Given user is on page
When user enters username as "dec2020secondbatch@gmail.com" 
And user enters password as "Selenium@12345"
And user clicks on Login button
Then User gets the Title page 
And Page title should be "My account - My Store"