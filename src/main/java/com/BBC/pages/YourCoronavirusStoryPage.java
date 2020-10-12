package com.BBC.pages;

import com.BBC.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static java.lang.String.format;

public class YourCoronavirusStoryPage extends BasePage {

    private static final String HOW_TO_SHARE_WITH_BBC_LINK =
            "//div[@aria-labelledby='nw-c-Getintouchwithus__title']//h3[. = '%s']";

    public void goToShareWithBBCPage(String howToShare) {
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(findElement(By.xpath(
                format(HOW_TO_SHARE_WITH_BBC_LINK, howToShare)))).click().build().perform();
    }
}
