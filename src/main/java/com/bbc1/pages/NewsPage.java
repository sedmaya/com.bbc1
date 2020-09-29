package com.bbc1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewsPage extends BasePage {

    private static final By HEADLINE_NEWS_TITLE = By.xpath("//div[contains(@class, 'gs-u-display-inline-block@m')]//h3");
    private static final By SECONDARY_NEWS_TITLES = By.xpath("//div[contains(@class,'secondary-item')]//h3");
    private static final By HEADLINE_NEWS_CATEGORY_LINK = By.xpath("//div[contains(@class,'gs-u-display-inline-block@m')]//a[contains(@class, 'nw-c-section-link')]//span[text()]");
    private static final By SEARCH_BAR = By.xpath("//input[@id='orb-search-q']");
    private static final By CORONAVIRUS_NAV_TAB = By.xpath("//nav[@class='nw-c-nav__wide']//span[.='Coronavirus']");

    public String actualHeadlineNewsTitle() {
        return findElement(HEADLINE_NEWS_TITLE).getText();
    }

    public List<WebElement> getSecondaryNewsTitlesList() {
        return findElements(SECONDARY_NEWS_TITLES);
    }

    public String getHeadlineCategoryTitle() {
        return findElement(HEADLINE_NEWS_CATEGORY_LINK).getText();
    }

    public SearchResultPage enterCategoryIntoSearchBar() {
        findElement(SEARCH_BAR).sendKeys(getHeadlineCategoryTitle(), Keys.ENTER);
        return new SearchResultPage();
    }

    public void goToCoronavirusTab() {
        findElement(CORONAVIRUS_NAV_TAB).click();
    }
}
