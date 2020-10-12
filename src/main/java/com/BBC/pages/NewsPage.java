package com.BBC.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;

public class NewsPage extends BasePage {

    private static final String HEADLINE_NEWS_TITLE = "//div[contains(@class,'gs-u-display-inline-block@m')]//h3";
    private static final String SECONDARY_NEWS_TITLES = "//div[contains(@class,'secondary-item')]//h3";
    private static final String HEADLINE_NEWS_CATEGORY_LINK = "//div[contains(@class,'gs-u-display-inline-block@m')]//ul//a//span";
    private static final String SEARCH_BAR = "//input[@id='orb-search-q']";
    private static final String CORONAVIRUS_NAV_TAB = "//nav[@class='nw-c-nav__wide']//span[.='%s']";

    public String actualHeadlineNewsTitle() {
        return findElement(By.xpath(HEADLINE_NEWS_TITLE)).getText();
    }

    public List<WebElement> getSecondaryNewsTitlesList() {
        return findElements(By.xpath(SECONDARY_NEWS_TITLES));
    }

    public String getHeadlineCategoryTitle() {
        return findElement(By.xpath(HEADLINE_NEWS_CATEGORY_LINK)).getText();
    }

    public void enterCategoryIntoSearchBar() {
        findElement(By.xpath(SEARCH_BAR)).sendKeys(getHeadlineCategoryTitle(), Keys.ENTER);
    }

    public void goToCoronavirusPage(String navTab) {
        findElement(By.xpath(format(CORONAVIRUS_NAV_TAB, navTab))).click();
    }
}
