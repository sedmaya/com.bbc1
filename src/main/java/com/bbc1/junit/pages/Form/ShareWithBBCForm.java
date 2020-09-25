package com.bbc1.junit.pages.Form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;

public class ShareWithBBCForm extends BaseForm {

    private static final String CHECKBOX_TO_BE_CLICKED = "//span//*[text() = '%s']//preceding::input[1]";

    public ShareWithBBCForm(WebElement formComplexElement) {
        super(formComplexElement);
    }

    public void clickCheckBoxes(List<String> checkboxLabelsToBeClicked) {
        for (String checkBoxLabel : checkboxLabelsToBeClicked) {
            WebElement checkBox = formComplexElement.findElement(By.xpath(format(CHECKBOX_TO_BE_CLICKED, checkBoxLabel)));
            checkBox.click();
        }
    }

    public void clickSubmitStoryButton() {
        submitButton().click();
    }
}
