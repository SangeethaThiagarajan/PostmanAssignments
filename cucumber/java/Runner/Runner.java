package Runner;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonFormat.Features;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"src/test/java/Features/"}
/*,tags = "@DemoRun"*/
,glue = {"Steps"})

//(src/test/java/Features/incident.feature) for exact feature file point out 
public class Runner extends AbstractTestNGCucumberTests
{

}
