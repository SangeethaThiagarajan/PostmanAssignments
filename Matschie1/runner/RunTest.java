package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/Jira.feature",
				 glue = {"stepsJira","hooks"},
				 monochrome = true)

public class RunTest extends AbstractTestNGCucumberTests{

}

