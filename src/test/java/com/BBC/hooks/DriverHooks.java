package com.BBC.hooks;

import com.BBC.driver.DriverManager;
import com.BBC.driver.DriverName;
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
