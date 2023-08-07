package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "C:\\Users\\harsh\\eclipse-workspace\\FlightBooking\\src\\main\\resources",
		glue={"StepDefinition"},
		monochrome = true,
		dryRun = false,
		tags = "@assessment"
		)

public class TestRunner extends AbstractTestNGCucumberTests {

}