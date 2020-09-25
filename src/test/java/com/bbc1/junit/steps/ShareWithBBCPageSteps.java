package com.bbc1.junit.steps;

import com.bbc1.junit.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class ShareWithBBCPageSteps {
    NewsPage newsPage = new NewsPage();
    CoronavirusPage coronavirusPage = new CoronavirusPage();
    YourCoronavirusStoryPage storyPage = new YourCoronavirusStoryPage();
    ShareWithBBCPage shareWithBBCPage = new ShareWithBBCPage();

    @Given("A user clicks on a Coronavirus Tab")
    public void aUserClicksOnACoronavirusTab() {
        newsPage.goToCoronavirusTab();
    }

    @Given("A user clicks on a Your Coronavirus Stories Tab")
    public void goToYourCoronavirusStoryPage() {
        coronavirusPage.goToYourCoronavirusStoryPage();
    }

    @Given("A user clicks on How to share with BBC News link")
    public void goToShareWithBBCPage() {
        storyPage.goToShareWithBBCPage();
        shareWithBBCPage.InitForm();
    }

    @When("A user fills the form but leaves Story field empty")
    public void fillFormWithEmptyStoryField() {
        shareWithBBCPage.fillFormWithEmptyStoryField();
    }

    @When("A user fills the form but leaves Name field empty")
    public void fillFormWithEmptyNameField() {
        shareWithBBCPage.fillFormWithEmptyNameField();
    }

    @When("A user fills the form with invalid Email")
    public void fillFormWithInvalidEmail() {
        shareWithBBCPage.fillFormWithInvalidEmail();
    }

    @When("A user fills the form with unchecked I am over 16 years old checkbox")
    public void fillFormWithUncheckedIAmOver16() {
        shareWithBBCPage.fillFormWithUncheckedIAmOver16();
    }

    @When("A user fills the form with unchecked Terms of Service checkbox")
    public void fillFormWithUncheckedAcceptTerms() {
        shareWithBBCPage.fillFormWithUncheckedAcceptTerms();
    }

    @Then("The submit button stays enabled after a user clicks on it")
    public void theSubmitButtonStaysEnabledAfterAUserClicksOnIt() {
        assertThat(shareWithBBCPage.isFormValid())
                .overridingErrorMessage("The form works incorrectly.")
                .isTrue();
    }
}
