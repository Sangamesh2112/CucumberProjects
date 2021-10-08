package testrunners;

import org.junit.runner.RunWith;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/appFeatures/FlipKartAutomating.feature"},
			glue = {"stepDefinations","AppHooks"},
			plugin = {"pretty","html:target/result.html"},
		/* tags = "@Regression", */ 
			monochrome = true,
			publish = true 
				)
public class FlipKartRunner {

	
}
