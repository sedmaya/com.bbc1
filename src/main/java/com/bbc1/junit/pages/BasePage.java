package com.bbc1.junit.pages;

import com.bbc1.junit.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    private static final By SIGN_IN_POPUP = By.id("sign_in");
    private static final By SIGN_IN_POPUP_CLOSE = By.xpath("//div[@id='sign_in']//button[@aria-label='close']");

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
        DriverManager.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static WebElement findElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public static List<WebElement> findElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public void signInPopUpHandler() {
        List<WebElement> signInPopUpElement = new ArrayList<>();
        signInPopUpElement.add(findElement(SIGN_IN_POPUP));
        if (signInPopUpElement.size() > 0) {
            findElement(SIGN_IN_POPUP_CLOSE).click();
        }
    }

}
