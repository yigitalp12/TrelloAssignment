package org.Trello.APITest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/featuresAPI",
        glue = {"org.Trello.APITest.stepDefinitionsAPI"},
        plugin = {"pretty", "html:target/cucumber-reports/API/report.html"},
        monochrome = true
)
public class TestRunnerForAPITests {
}
