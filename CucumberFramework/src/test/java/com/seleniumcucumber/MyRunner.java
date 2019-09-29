package com.seleniumcucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        monochrome = true,
        strict = false,
        features = {"src/test/resources"},
        glue = {"com.seleniumcucumber"},
        plugin = {
                "pretty",
                "html:target/reports/cucumber-html",
                "json:target/json/cucumber.json"
        },
        tags = {
                "@beginnersGuide"
        }
)
public class MyRunner {

}
