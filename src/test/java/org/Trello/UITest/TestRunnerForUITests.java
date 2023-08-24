package org.Trello.UITest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/featuresUI",
        glue = {"org.Trello.UITest.stepDefinitionsUI"},
        plugin = {"pretty", "html:target/cucumber-reports/UI-tests/report.html"},
        monochrome = true
)
public class TestRunnerForUITests {
}
