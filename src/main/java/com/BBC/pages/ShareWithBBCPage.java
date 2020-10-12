package com.BBC.pages;

import com.BBC.pages.PagesHelpers.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class ShareWithBBCPage extends BasePage {

    private static final String FORM_COMPLEX_ELEMENT =
            "//div[@class='embed-content-container']";
    private static final ShareWithBBCForm formSubmit =
            new ShareWithBBCForm(By.xpath(FORM_COMPLEX_ELEMENT));
    private static final String CHECKBOX_TO_BE_CLICKED =
            "//span//*[text() = '%s']//preceding::input[1]";

    private static final String SUBMIT_BUTTON_NAME = "Submit";

    public boolean isSubmitButtonEnabled() {
        return formSubmit.isButtonEnabled(SUBMIT_BUTTON_NAME);
    }

    public void submitForm() {
        formSubmit.clickOnButton(SUBMIT_BUTTON_NAME);
    }

    public void fillFormsInputs(Map<String, String> placeholderValues) {
        formSubmit.fillFormsInputs(placeholderValues);
    }

    public void clickOnCheckBox(List<String> checkboxNamesToBeClicked) {
        formSubmit.clickCheckBoxes(checkboxNamesToBeClicked);
    }

    private static class ShareWithBBCForm extends BaseForm {

        public ShareWithBBCForm(By formComplexElement) {
            super(formComplexElement);
        }

        public void clickCheckBoxes(List<String> checkboxLabelsToBeClicked) {
            for (String checkBoxLabel : checkboxLabelsToBeClicked) {
                WebElement checkBox = formComplexElement().findElement(
                        By.xpath(format(CHECKBOX_TO_BE_CLICKED, checkBoxLabel)));
                checkBox.click();
            }
        }
    }
}
