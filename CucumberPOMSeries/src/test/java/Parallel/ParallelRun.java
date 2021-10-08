package Parallel;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

// For TestNG Parallel Running of Scripts
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/Parallel"},
		glue = {"Parallel","AppHooks"},
		plugin = {"pretty"},
		monochrome = true,
		publish = true 
				)

public class ParallelRun extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
		
	}
	

	
	
}
