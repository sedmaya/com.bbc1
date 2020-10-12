package com.BBC.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.BBC.pages.PageUtil.PageProvider.*;
import static org.assertj.core.api.Assertions.assertThat;


public class ShareWithBBCSteps {

    @Given("A user clicks a {string} Tab")
    public void aUserClicksOnACoronavirusTab(String navTab) {
        getNewsPage.goToCoronavirusPage(navTab);
    }

    @Given("A user clicks on a {string} subTab")
    public void goToYourCoronavirusStoryPage(String tabName) {
        getCoronavirusPage.goToYourCoronavirusStoryPage(tabName);
    }

    @Given("A user clicks on {string} link")
    public void goToShareWithBBCPage(String howToShare) {
        getStoryPage.goToShareWithBBCPage(howToShare);
    }

    @When("A user fills the form with empty or invalid required fields")
    public void fillForm(Map<String, String> map) {
        Map<String, String> fieldsToBeFilled = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue() != null ? entry.getValue() : "";
            fieldsToBeFilled.put(key, value);
        }
        getShareWithBBCPage.fillFormsInputs(fieldsToBeFilled);
    }

    @And("selects checkboxes")
    public void selectCheckboxes(Map<String, String> map) {
        List<String> checkBoxNamesList = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue() != null ? entry.getValue() : "";
            if (value.equals("checked")) {
                checkBoxNamesList.add(entry.getKey());
            }
        }
        getShareWithBBCPage.clickOnCheckBox(checkBoxNamesList);
    }

    @And("A user hits the Submit button")
    public void setFormSubmit() {
        getShareWithBBCPage.submitForm();
    }

    @Then("The Submit button stays enabled after a user clicks on it")
    public void theSubmitButtonStaysEnabledAfterAUserClicksOnIt() {
        assertThat(getShareWithBBCPage.isSubmitButtonEnabled())
                .overridingErrorMessage("The form works incorrectly.")
                .isTrue();
    }
}
