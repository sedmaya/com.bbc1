package com.bbc1.junit.hooks;

import com.bbc1.junit.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {

    @Before
    public void setUp() {
        DriverManager.getDriver("");
    }

    @After
    public void cleanDriver() {
        DriverManager.quitDriver();
    }
}
