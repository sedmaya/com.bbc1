package com.bbc1.pages.Form;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static com.bbc1.pages.BasePage.findElement;
import static java.lang.String.format;

public abstract class BaseForm {

    private By formComplexElement;
    private static final By SUBMIT_BUTTON = By.xpath("//button[text()='Submit']");
    private static final String FORM_PLACEHOLDER_NAME = "//*[@placeholder= '%s']";

    public BaseForm(By formComplexElement) {
        this.formComplexElement = formComplexElement;
    }

    protected WebElement formComplexElement() {
        return findElement(formComplexElement);
    }

    private WebElement submitButton() {
        return findElement(SUBMIT_BUTTON);
    }

    public void fillShareWithBBCInputs(Map<String, String> placeholderValues) {
        for (Map.Entry<String, String> keyValue : placeholderValues.entrySet()) {
            WebElement fieldName = findPlaceholderChild(keyValue.getKey());
            fieldName.sendKeys(keyValue.getValue(), Keys.ENTER);
        }
    }

    private WebElement findPlaceholderChild(String placeholderName) {
        return formComplexElement().findElement(By.xpath(format(FORM_PLACEHOLDER_NAME, placeholderName)));
    }

    public boolean isSubmitButtonEnabled() {
        return submitButton().isEnabled();
    }

    public void clickSubmitStoryButton() {
        submitButton().click();
    }
}


