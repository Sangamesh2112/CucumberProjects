package stepDefinations;

import org.junit.Assert;


import com.Pages.LoginPage;
import com.QA.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private static String title;
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	
	
	
	  @Given("user is on Login Page") 
	  public void user_is_on_Login_page() throws InterruptedException {
	  DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account"); 
	  Thread.sleep(2000); 
	  }
	 

	@When("user gets the title of the page")
	public void user_gets_the_Title_of_the_page() throws InterruptedException {
		 title = loginpage.getLoginPageTitle();
		 Thread.sleep(2000);
		System.out.println("Page title is : " +title);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) throws InterruptedException {
		
		 title = loginpage.getLoginPageTitle();
		 Thread.sleep(2000);
		Assert.assertTrue(title.contains(expectedTitle));
		Thread.sleep(2000);
	   
	}

	@Then("forgot your password link should be displayed")
	public  void forgot_your_password_link_should_be_displayed() throws InterruptedException {
		
	   Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	   Thread.sleep(1000);
	}

	
	@Given("user is on page")
	public void user_is_on_page() throws InterruptedException {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		Thread.sleep(1000);
	}
	/*
	 * @Given("user is on Login page") public void user_is_on_login_page() { //
	 * Write code here that turns the phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 */

	@When("user enters username as {string}")
	public void user_enters_username_as(String username) throws InterruptedException {
		loginpage.enterUsername(username);
		Thread.sleep(1000);
	    
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String password) throws InterruptedException {
		loginpage.enterPassword(password);
		Thread.sleep(1000);
	   
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() throws InterruptedException {
	    loginpage.clickOnLogin(); //For Clicking the Login button
	    Thread.sleep(2000);
	}

	
	
}
