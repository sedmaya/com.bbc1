package com.BBC.pages;

import org.openqa.selenium.By;

public class SearchResultPage extends BasePage {

    private static final String SEARCHED_FIRST_MAIN_NEWS_TITLE
            = "(//div[contains(@class, 'Container')]//ul[@role = 'list']//span)[1]";

    public String actualFirstArticleName() {
        return findElement(By.xpath(SEARCHED_FIRST_MAIN_NEWS_TITLE)).getText();
    }
}
