Feature: Account Page Feature


Background: 
Given User has already Logged into the Page
| username | password |
| dec2020secondbatch@gmail.com | Selenium@12345 |


Scenario: Accounts Page title 
Given User is on Accounts Page 
When user gets the title of the page 
Then Page title should be "My account - My Store"

Scenario:  Accounts Section Count 
Given User is on Accounts Page 
Then User gets Accounts Section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And Account section count should be 6


