package com.bbc1.junit.pages;

import com.bbc1.junit.pages.Form.ShareWithBBCForm;
import com.bbc1.junit.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShareWithBBCPage extends BasePage {

    private ShareWithBBCForm formSubmit;
    private static final int FORM_EMPTY_FIELD = 0;
    private static final int FORM_FIELD_TEXT_LENGTH = 9;
    private static final By FORM_COMPLEX_ELEMENT = By.xpath("//div[@class='embed-content-container']");
    private static final String STORY_FIELD_TITLE = "Tell us your story. ";
    private static final String NAME_FIELD_TITLE = "Name";
    private static final String EMAIL_FIELD_TITLE = "Email address";
    private static final By I_AM_OVER_16_CHECKBOX = By.xpath("//span//*[text() = 'I am over 16 years old']");
    private static final By I_ACCEPT_TERMS_CHECKBOX = By.xpath("//span//*[text() = 'Terms of Service']");

    HashMap<String, String> formFieldsData = new HashMap<>();
    List<String> checkboxNamesToBeClicked = new ArrayList<>();

    public WebElement getFormComplexElement() {
        return findElement(FORM_COMPLEX_ELEMENT);
    }

    public void InitForm() {
        formSubmit = new ShareWithBBCForm(getFormComplexElement());
    }

    public boolean isFormValid() {
        return formSubmit.isSubmitButtonEnabled();
    }

    public String getIAmOver16CheckboxTextLabel() {
        return findElement(I_AM_OVER_16_CHECKBOX).getText();
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

    public void fillFormWithUncheckedIAmOver16() {
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
}
