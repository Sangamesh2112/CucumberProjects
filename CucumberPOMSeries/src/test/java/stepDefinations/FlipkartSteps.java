package stepDefinations;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.Pages.LoginPage;
import com.Pages.flipcartPage;
import com.QA.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartSteps {

	
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private flipcartPage flipcartpages;
	
	
	// 1st Scenario
	@Given("User is Already on the page")
	public void user_is_already_on_the_page() throws InterruptedException {

		DriverFactory.getDriver().get("https://www.flipkart.com/");
		Thread.sleep(1000);
	} 

	@Given("User on Flipkart page")
	public void user_on_flipkart_page() throws InterruptedException {
		
		DriverFactory.getDriver().findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		System.out.println("Yes User is on FlipKart page");

	}

	@When("User gets the title of the Page")
	public void user_gets_the_title_of_the_page() {
		String pagetitle = loginpage.getLoginPageTitle();
		System.out.println("The Pagetitle is " + pagetitle);

	}

	@Then("The page title should be {string}")
	public void the_page_title_should_be(String ExpectedTitle) {

		String ActualTitle = loginpage.getLoginPageTitle();
		Assert.assertTrue(ActualTitle.equals(ExpectedTitle));
	}

	//2nd Scenario

	  @Given("verify the search bar is displayed") 
	  public void verify_the_search_bar_is_displayed() throws InterruptedException 
	  {
		  DriverFactory.getDriver().findElement(By.xpath("/html/body/div[2]/div/div/button")).click(); //Closes the Login pop up
		  System.out.println("Search Field Verifying");
		  DriverFactory.getDriver().findElement(By.name("q")).isDisplayed();     
	 // flipcartpages.verifySearchBar(); 
	  }
	 
	 
	@When("User Enters {string} into Search bar")
	public void user_enters_into_search_bar(String ProductName) throws InterruptedException {
	
		
		DriverFactory.getDriver().findElement(By.name("q")).sendKeys(ProductName,Keys.ENTER);
		 // flipcartpages.SearchProduct(); 
		Thread.sleep(2000); 
		
	}

	@Then("Search Results Should be displayed")
	public void search_results_should_be_displayed() {
		//flipcartpages.verifyProductDisplayed();
		
		boolean displayed = DriverFactory.getDriver().findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/"
				+ "div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]")).isDisplayed();   // Verifies that the Search Product is Displayed or not 
		System.out.println("The product with the name APPLE iPhone 12 (Blue, 64 GB) is Displayed:" +displayed);
	}

	@When("User Selects the {string}")
	public void user_selects_the(String Productname) throws InterruptedException {
		
		//flipcartpages.selectProduct();
		DriverFactory.getDriver().findElement(By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]"
				+ "/div/div/div/a/div[2]/div[1]/div[1]")).click();
		
		Thread.sleep(1000);

	}

	@When("User Adds to the cart")
	public void user_adds_to_the_cart() throws InterruptedException {
		
		String ParentWindow=DriverFactory.getDriver().getWindowHandle();
		System.out.println("Parent Window id is: "+ParentWindow);
		Set<String> Windows	=DriverFactory.getDriver().getWindowHandles();
		int count=Windows.size();
		System.out.println("the No of Windows are :"+count);
		
		for(String childWindow:Windows)
		{
			if(!ParentWindow.equalsIgnoreCase(childWindow))
			{
				DriverFactory.getDriver().switchTo().window(childWindow);
				Thread.sleep(2000);
			}
		}
		DriverFactory.getDriver().findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		Thread.sleep(2000);
		 // flipcartpages.switchtoChildWindow(); flipcartpages.addtoKart();
		System.out.println("Added to the cart");

	}

	@Then("Navigate to Cart page and Verify the Amount is Displayed")
	public void navigate_to_cart_page_and_verify_the_Amount_is_displayed() throws InterruptedException {
		//flipcartpages.verifyPrices();
		
		System.out.println("Product is Displayed in Cart Page");
		Thread.sleep(2000);
		String Price = DriverFactory.getDriver().findElement(By.xpath("//*[@id='container']/div/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/span[1]")).getText();
		String TotalAmount = DriverFactory.getDriver().findElement(By.xpath("//*[@id='container']/div/div[2]/div/div/div[2]/div[1]/div/div/div/div[4]/div/span/div/div/span")).getText();
	
		System.out.println("The price of the Product is :" +Price);
		System.out.println("The total amount of the cart :"+TotalAmount);
		  Assert.assertEquals(Price, TotalAmount);
		  System.out.println("Verified the Amounts");
	}

}
