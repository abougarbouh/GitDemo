import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions")

public class cucumberTestNGRuner extends AbstractTestNGCucumberTests {
}
