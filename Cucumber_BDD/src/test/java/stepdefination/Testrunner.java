package stepdefination;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",   // run only login.feature
    glue = {"stepdefination"},
    plugin = {
        "pretty",
        "html:target/htmlreport.html",
        "json:target/jsonreport.json",
        "junit:target/junitreport.xml"
    }
)
public class Testrunner {
}
 