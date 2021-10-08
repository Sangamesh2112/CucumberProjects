Feature: Search a Product 

Background: 
Given User is Already on the page


Scenario: Verify Page title 
Given User on Flipkart page
When User gets the title of the Page 
Then The page title should be "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"

@Regression
Scenario: Add Product to Cart 
Given User on Flipkart page	
When User Enters "APPLE iPhone 12 (Blue, 64 GB)" into Search bar 
Then Search Results Should be displayed
When User Selects the "APPLE iPhone 12 (Blue, 64 GB)"
And User Adds to the cart
Then Navigate to Cart page and Verify the Amount is Displayed 

 
