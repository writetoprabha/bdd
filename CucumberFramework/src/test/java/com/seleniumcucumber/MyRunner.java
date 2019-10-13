package com.seleniumcucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( //we can give various run options for our test execution
        dryRun = false,                                         // * when it is true, it will not run the project. It will just check whether all the steps has corresponding step definitions
        monochrome = true,                                      // * monochrome builds up the formatting. Console logs will be in proper format
        strict = true,                                         // * when true, cucumber will report the error when a step fails. Otherwise, it will simply pass the tests
        features = {"src/test/resources"},                      // * Specifies the path in which features are located. If this is not specified, then we need to maintain the features in the same package where the runner class is located
        glue = {"com.seleniumcucumber.steps"},                  // * Specifies where the step definitions are located. For some projects, they maintain the step definitions in a different repository for easy maintenance. In such cases, we can give the repo URL here
        plugin = {
                "pretty",                                       // * pretty plugin is for formatting the console logs
                "html:target/reports/cucumber-html",            // * to generate html report under target/reports folder with file name cucumber.html
                "json:target/json/cucumber.json"                // * to generate json report under taret/json folder  with file name cucumber.json
        },
        tags = {
                "@Login"                               // * to run only specific tags
        }
)
public class MyRunner {

}
