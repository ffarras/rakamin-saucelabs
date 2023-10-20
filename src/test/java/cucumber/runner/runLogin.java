package cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Feature files renamed based on test orders (01, 02)
        features = "src/test/java/cucumber/features",
        glue = "cucumber.stepDef",
        tags = "@TDD",
        plugin = {"html:src/test/java/cucumber/HTML_report.html"}
)
public class runLogin {
}
