import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "features",
    glue = {"StepDefinitions"},
    tags = "@activity5"
)

public class ActivitiesRunner {
    //empty
}