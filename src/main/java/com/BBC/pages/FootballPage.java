package com.BBC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class FootballPage extends BasePage {

    private static final String SCORES_AND_FIXTURES_TAB = "//ul[@id='sp-nav-secondary']//a[@data-stat-title='%s']";

    public void goToScoresPage(String tabName) {
        WebElement element = findElement(By.xpath(format(SCORES_AND_FIXTURES_TAB, tabName)));
        waitForElementIsClickable(element);
        element.click();
    }
}
