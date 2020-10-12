package com.BBC.pages;

import com.BBC.driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.BBC.pages.PageUtil.PageProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public abstract class BasePage {
    private static final Logger LOGGER = LogManager.getLogger(BasePage.class);

    private static final String POPUP_NAME = "%s";
    private static final String POPUP_CLOSE = "//div[@id='%s']//button[@aria-label='close']";
    protected static final String TEAMS_SCOREBOARD_CONTAINER = "//span[contains(., '%s') and following-sibling::*[contains(., '%s')]]/parent::div[@class='sp-c-fixture__wrapper']";
    protected static final String SCORES_NUMBERS = "//span[contains(@class, 'number')]";


    private final long timeout = 30;

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        DriverManager.getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    protected WebElement findElement(By by) {
       return PageProvider.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return PageProvider.findElements(by);
    }

    public void popUpHandler(String popUpName) {
        List<WebElement> popUpElement = new ArrayList<>();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        popUpElement.add(findElement(By.id(format(POPUP_NAME, popUpName))));
        if (popUpElement.size() > 0) {
            findElement(By.xpath(format(POPUP_CLOSE, popUpName))).click();
        }
    }

    protected void retryingFindClick(By by) {
        int attempts = 0;
        while(attempts < 2) {
            try {
                findElement(by).click();
                break;
            } catch(StaleElementReferenceException e) {
                LOGGER.error(e.getMessage(), e);
            }
            attempts++;
        }
    }

    protected void waitForElementIsClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
