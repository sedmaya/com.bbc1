package com.bbc1.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.bbc1.pages.PageUtil.PageProvider.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ShareWithBBCPageSteps {

    @Given("A user clicks on a Coronavirus Tab")
    public void aUserClicksOnACoronavirusTab() {
        getNewsPage.goToCoronavirusTab();
    }

    @Given("A user clicks on a Your Coronavirus Stories Tab")
    public void goToYourCoronavirusStoryPage() {
        getCoronavirusPage.goToYourCoronavirusStoryPage();
    }

    @Given("A user clicks on How to share with BBC News link")
    public void goToShareWithBBCPage() {
        getStoryPage.goToShareWithBBCPage();
    }

    @When("A user fills the form but leaves Story field empty")
    public void fillFormWithEmptyStoryField() {
        getShareWithBBCPage.fillFormWithEmptyStoryField();
    }

    @When("A user fills the form but leaves Name field empty")
    public void fillFormWithEmptyNameField() {
        getShareWithBBCPage.fillFormWithEmptyNameField();
    }

    @When("A user fills the form with invalid Email")
    public void fillFormWithInvalidEmail() {
        getShareWithBBCPage.fillFormWithInvalidEmail();
    }

    @When("A user fills the form with unchecked I am over 16 years old checkbox")
    public void fillFormWithUncheckedIAmOver16() {
        getShareWithBBCPage.fillFormWithUncheckedIAmOverSixteen();
    }

    @When("A user fills the form with unchecked Terms of Service checkbox")
    public void fillFormWithUncheckedAcceptTerms() {
        getShareWithBBCPage.fillFormWithUncheckedAcceptTerms();
    }

    @Then("The submit button stays enabled after a user clicks on it")
    public void theSubmitButtonStaysEnabledAfterAUserClicksOnIt() {
        assertThat(getShareWithBBCPage.isFormValid())
                .overridingErrorMessage("The form works incorrectly.")
                .isTrue();
    }
}
