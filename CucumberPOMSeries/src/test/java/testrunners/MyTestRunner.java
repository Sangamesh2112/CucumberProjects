package testrunners;

import org.junit.runner.RunWith;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// For Running the My Accounts Page 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/Resources/appFeatures/MyAccounts.feature"},
		glue = {"stepDefinations","ApHooks"},
		plugin = {"pretty"},
		monochrome = true,
		publish = true 
				
		
		
			)
public class MyTestRunner {

	
}
