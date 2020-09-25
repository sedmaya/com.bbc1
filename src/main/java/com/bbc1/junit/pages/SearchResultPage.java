package com.bbc1.junit.pages;

import org.openqa.selenium.By;

public class SearchResultPage extends BasePage {

    private static final By SEARCHED_FIRST_MAIN_NEWS_TITLE = By.xpath("(//a[@class='css-vh7bxp-PromoLink ett16tt7'])[1]/span");

    public String actualFieldArticleName() {
        return findElement(SEARCHED_FIRST_MAIN_NEWS_TITLE).getText();
    }
}
