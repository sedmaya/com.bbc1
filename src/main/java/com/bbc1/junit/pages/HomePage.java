package com.bbc1.junit.pages;

import com.bbc1.junit.driver.DriverManager;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private static final String BBC_URL = "https://www.bbc.com";
    private static final By NEWS_TAB = By.xpath("//div[@id='orb-nav-links']//a[.='News']");

    public void openBBCHomePage() {
        DriverManager.getDriver().get(BBC_URL);
    }

    public void goToNewsPage() {
        findElement(NEWS_TAB).click();
    }
}
