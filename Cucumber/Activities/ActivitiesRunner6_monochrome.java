import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "features",
    glue = {"StepDefinitions"},
    tags = "@activity6",
    plugin= {"pretty",
    		"html:Reports/HTML_Report.html",
    		"junit:Reports/XML_Report.xml",
    		"json:Reports/JSON_Report.json"},
    monochrome = true
)

public class ActivitiesRunner6_monochrome {
    //empty
}