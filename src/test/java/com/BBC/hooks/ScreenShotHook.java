package com.BBC.hooks;

import com.BBC.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShotHook {
    private static final String PNG_FILE_EXTENSION = "image/png";

    @After
    public void takeScreenShot(Scenario scenario) {
        scenario.write(DriverManager.getDriver().getCurrentUrl());
        byte[] screenShot = ((TakesScreenshot) DriverManager.getDriver()).
                getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenShot, PNG_FILE_EXTENSION, scenario.getName());
    }
}
