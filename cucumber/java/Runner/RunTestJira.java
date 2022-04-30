package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/Jira.feature",
				 glue = {"StepsJiraIssues","hooks"},
				 monochrome = true)

public class RunTestJira extends AbstractTestNGCucumberTests{

}

