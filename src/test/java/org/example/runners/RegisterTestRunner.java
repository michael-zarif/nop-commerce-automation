package org.example.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// Define Features, Step Definitions, tags and report plugins
@CucumberOptions
        (
                features = "src/main/resources/features",
                glue = "org/example/stepDefinitions",
                tags = "@register",
                plugin = {"pretty",
                        "html:target/cucumber.html",
                        "json:target/cucumber.json",
                        "junit:target/cucumber.xml",
                        "rerun:target/rerun.txt"
                }
        )

public class RegisterTestRunner extends AbstractTestNGCucumberTests {
}
