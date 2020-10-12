package com.BBC.pages.PagesHelpers;

import com.BBC.pages.PageUtil.PageProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static java.lang.String.format;

public abstract class BaseForm {

    private final By formComplexElement;
    private static final String BUTTON = "//button[text()='%s']";
    private static final String FORM_PLACEHOLDER_NAME = "//*[contains(@placeholder, '%s')]";

    public BaseForm(By formComplexElement) {
        this.formComplexElement = formComplexElement;
    }

    protected WebElement findElement(By by) {
        return PageProvider.findElement(by);
    }

    protected WebElement formComplexElement() {
        return findElement(formComplexElement);
    }

    private WebElement button(String buttonName) {
        return findElement(By.xpath(format(BUTTON, buttonName)));
    }

    public void fillFormsInputs(Map<String, String> placeholderValues) {
        for (Map.Entry<String, String> keyValue : placeholderValues.entrySet()) {
            WebElement fieldName = findPlaceholderChild(keyValue.getKey());
            fieldName.sendKeys(keyValue.getValue(), Keys.ENTER);
        }
    }

    private WebElement findPlaceholderChild(String placeholderName) {
        return formComplexElement().findElement(By.xpath(
                format(FORM_PLACEHOLDER_NAME, placeholderName)));
    }

    public boolean isButtonEnabled(String buttonName) {
        return button(buttonName).isEnabled();
    }

    public void clickOnButton(String buttonName) {
        button(buttonName).click();
    }
}


