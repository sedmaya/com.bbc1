package com.bbc1.hooks;

import com.bbc1.driver.DriverManager;
import com.bbc1.driver.DriverName;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {

    @Before
    public void setUp() {
        DriverManager.getDriver(DriverName.CHROME);
    }

    @After
    public void cleanDriver() {
        DriverManager.quitDriver();
    }
}
