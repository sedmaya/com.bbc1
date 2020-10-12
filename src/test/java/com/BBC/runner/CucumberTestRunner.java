package com.BBC.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/BBC-reports",
                "json:target/BBC-reports/BBCTests.json",
                "junit:target/BBC-reports/BBCTests.xml"},
        monochrome = true,
        glue = {"com.BBC"},
        features = "classpath:com.BBC.features"
)

public class CucumberTestRunner {

}
