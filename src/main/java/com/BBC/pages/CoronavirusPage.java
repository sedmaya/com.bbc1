package com.BBC.pages;

import org.openqa.selenium.By;

import static java.lang.String.format;

public class CoronavirusPage extends BasePage {

    private static final String CORONAVIRUS_STORY_TAB = "//nav[@class='nw-c-nav__wide-secondary']//span[.='%s']";

    public void goToYourCoronavirusStoryPage(String tabName) {
        findElement(By.xpath(format(CORONAVIRUS_STORY_TAB, tabName))).click();
    }
}
