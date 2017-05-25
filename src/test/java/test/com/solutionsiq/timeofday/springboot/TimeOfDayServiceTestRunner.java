package test.com.solutionsiq.timeofday.springboot;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
//      dryRun   = false,
//      strict = true,
//      tags     = "",
        monochrome = false,
        features = { "src/test/java/test/com/solutionsiq/timeofday/springboot" },
        glue     = { "test.com.solutionsiq.timeofday.springboot" },
        plugin   = { "pretty", "html:target/cucumber-reports/cucumber-html-report", "json:target/cucumber-reports/cucumber-json-report.json" }
)

public class TimeOfDayServiceTestRunner {
}