package com.bbc1.pages;

import com.bbc1.pages.Form.BaseForm;
import com.bbc1.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class ShareWithBBCPage extends BasePage {

    private static final int FORM_EMPTY_FIELD = 0;
    private static final int FORM_FIELD_TEXT_LENGTH = 9;
    private static final By FORM_COMPLEX_ELEMENT = By.xpath("//div[@class='embed-content-container']");
    private static ShareWithBBCForm formSubmit = new ShareWithBBCForm(FORM_COMPLEX_ELEMENT);
    private static final String STORY_FIELD_TITLE = "Tell us your story. ";
    private static final String NAME_FIELD_TITLE = "Name";
    private static final String EMAIL_FIELD_TITLE = "Email address";
    private static final By I_AM_OVER_SIXTEEN_CHECKBOX = By.xpath("//span//*[text() = 'I am over 16 years old']");
    private static final By I_ACCEPT_TERMS_CHECKBOX = By.xpath("//span//*[text() = 'Terms of Service']");

    private Map<String, String> formFieldsData = new HashMap<>();
    private List<String> checkboxNamesToBeClicked = new ArrayList<>();

    public boolean isFormValid() {
        return formSubmit.isSubmitButtonEnabled();
    }

    public String getIAmOver16CheckboxTextLabel() {
        return findElement(I_AM_OVER_SIXTEEN_CHECKBOX).getText();
    }

    public String getIAcceptTermsTextLabel() {
        return findElement(I_ACCEPT_TERMS_CHECKBOX).getText();
    }

    public void fillFormWithEmptyStoryField() {
        formFieldsData.put(STORY_FIELD_TITLE, StringUtils.generateRandomStringWithSetLength(FORM_EMPTY_FIELD));
        formFieldsData.put(NAME_FIELD_TITLE, StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        checkboxNamesToBeClicked.add(getIAmOver16CheckboxTextLabel());
        checkboxNamesToBeClicked.add(getIAcceptTermsTextLabel());
        setFormSubmit();
    }

    public void fillFormWithEmptyNameField() {
        formFieldsData.put(STORY_FIELD_TITLE, StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        formFieldsData.put(NAME_FIELD_TITLE, StringUtils.generateRandomStringWithSetLength(FORM_EMPTY_FIELD));
        checkboxNamesToBeClicked.add(getIAmOver16CheckboxTextLabel());
        checkboxNamesToBeClicked.add(getIAcceptTermsTextLabel());
        setFormSubmit();
    }

    public void fillFormWithInvalidEmail() {
        formFieldsData.put(STORY_FIELD_TITLE, StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        formFieldsData.put(NAME_FIELD_TITLE, StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        formFieldsData.put(EMAIL_FIELD_TITLE, StringUtils.generateRandomInvalidEmailWithSetLength(FORM_FIELD_TEXT_LENGTH));
        checkboxNamesToBeClicked.add(getIAmOver16CheckboxTextLabel());
        checkboxNamesToBeClicked.add(getIAcceptTermsTextLabel());
        setFormSubmit();
    }

    public void fillFormWithUncheckedAcceptTerms() {
        formFieldsData.put(STORY_FIELD_TITLE, StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        formFieldsData.put(NAME_FIELD_TITLE, StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        checkboxNamesToBeClicked.add(getIAmOver16CheckboxTextLabel());
        setFormSubmit();
    }

    public void fillFormWithUncheckedIAmOverSixteen() {
        formFieldsData.put(STORY_FIELD_TITLE, StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        formFieldsData.put(NAME_FIELD_TITLE, StringUtils.generateRandomStringWithSetLength(FORM_FIELD_TEXT_LENGTH));
        checkboxNamesToBeClicked.add(getIAcceptTermsTextLabel());
        setFormSubmit();
    }

    public void setFormSubmit() {
        formSubmit.fillShareWithBBCInputs(formFieldsData);
        formSubmit.clickCheckBoxes(checkboxNamesToBeClicked);
        formSubmit.clickSubmitStoryButton();
    }

    static class ShareWithBBCForm extends BaseForm {

        private static final String CHECKBOX_TO_BE_CLICKED = "//span//*[text() = '%s']//preceding::input[1]";

        public ShareWithBBCForm(By formComplexElement) {
            super(formComplexElement);
        }

        public void clickCheckBoxes(List<String> checkboxLabelsToBeClicked) {
            for (String checkBoxLabel : checkboxLabelsToBeClicked) {
                WebElement checkBox = formComplexElement().findElement(By.xpath(format(CHECKBOX_TO_BE_CLICKED, checkBoxLabel)));
                checkBox.click();
            }
        }
    }
}
