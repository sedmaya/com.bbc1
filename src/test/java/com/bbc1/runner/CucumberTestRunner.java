package com.bbc1.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/bbc1-reports",
                "json:target/bbc1-reports/BBCTests.json",
                "junit:target/bbc1-reports/BBCTests.xml"},
        monochrome = true,
        glue = "com.bbc1",
        features = "classpath:com.bbc1.features"
)

public class CucumberTestRunner {

}
