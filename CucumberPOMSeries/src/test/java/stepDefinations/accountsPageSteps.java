package stepDefinations;

import java.util.List;

import java.util.Map;

import com.Pages.AccountsPage;
import com.Pages.LoginPage;
import com.QA.factory.DriverFactory;

import org.junit.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class accountsPageSteps {

	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver()); //For LoginPage Driver 
	private AccountsPage accountsPage;
	
	@Given("User has already Logged into the Page")
	public void user_has_already_logged_into_the_page(DataTable credTable) throws InterruptedException {
		
		List<Map<String,String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
	    
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		Thread.sleep(1000);
		accountsPage = loginpage.doLogin(userName, password);
		
	}

	@Given("User is on Accounts Page")
	public void user_is_on_accounts_page() {
	  String title = accountsPage.getAccountPageTitle();
	  System.out.println(title);
	  
	}
	
	/*
	 * @When("User gets the title of the page") public void
	 * user_gets_the_title_of_the_page() {
	 * 
	 * }
	 */
	 

	@Then("User gets Accounts Section")
	public void user_gets_accounts_section(DataTable sectionDataTable) {
		
		List<String> expAccountSectionList = sectionDataTable.asList();
		System.out.println("Expected Account section List :" + expAccountSectionList);
		
		List<String> actualAccountSectionList = accountsPage.getAccountSectionList();
		System.out.println("Actual Account Section list is :" + actualAccountSectionList);
		
		Assert.assertTrue(expAccountSectionList.containsAll(actualAccountSectionList));
	    
	}

	@Then("Account section count should be {int}")
	public void account_section_count_should_be(Integer expectedSectionCount) {
		
	   Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
	}

}
