package Runner;

import io.cucumber.messages.internal.com.fasterxml.jackson.annotation.JsonFormat.Features;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features={"src/test/java/Features/ChangeRequest.feature"}
/*,tags = "@DemoRun"*/
,glue ={"Steps_ChangeRequest"})

public class Runner1 extends AbstractTestNGCucumberTests
{

}
