package com.BBC.pages;

import com.BBC.driver.DriverManager;
import org.openqa.selenium.By;

import static java.lang.String.format;

public class HomePage extends BasePage {

    private static final String BBC_URL = "https://www.bbc.com";
    private static final String TAB_NAME = "//div[@id='orb-nav-links']//a[.='%s']";


    public void openBBCHomePage() {
        DriverManager.getDriver().get(BBC_URL);
    }

    public void goToPage(String tabName) {
        findElement(By.xpath(format(TAB_NAME, tabName))).click();
    }

}
