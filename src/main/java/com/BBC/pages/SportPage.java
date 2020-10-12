package com.BBC.pages;

import org.openqa.selenium.By;

import static java.lang.String.format;

public class SportPage extends BasePage {

    private static final String FOOTBALL_NAV_TAB =
            "//ul[@class='sp-c-sport-navigation__inner gs-o-list-inline']//a[.='%s']";

    public void goToFootballPage(String tabName) {
        findElement(By.xpath(format(FOOTBALL_NAV_TAB, tabName))).click();
    }

}
