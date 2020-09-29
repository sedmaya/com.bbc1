package com.bbc1.pages;

import org.openqa.selenium.By;

public class CoronavirusPage extends BasePage {

    private static final By CORONAVIRUS_STORY_TAB = By.xpath("//ul[contains(@class,'secondary')]//a[@class='nw-o-link']");

    public YourCoronavirusStoryPage goToYourCoronavirusStoryPage() {
        findElement(CORONAVIRUS_STORY_TAB).click();
        return new YourCoronavirusStoryPage();
    }
}
