package com.bbc1.pages;

import com.bbc1.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class YourCoronavirusStoryPage extends BasePage {

    private static final By HOW_TO_SHARE_WITH_BBC_LINK = By.xpath("//div[@aria-labelledby='nw-c-Getintouchwithus__title']//h3[. = 'How to share with BBC News']");

    public ShareWithBBCPage goToShareWithBBCPage() {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(findElement(HOW_TO_SHARE_WITH_BBC_LINK)).click().build().perform();
        return new ShareWithBBCPage();
    }
}
