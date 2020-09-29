package com.bbc1.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.bbc1.pages.PageUtil.PageProvider.getHomePage;
import static com.bbc1.pages.PageUtil.PageProvider.getNewsPage;

public class NewsPageSteps {

    @Given("A user opens the BBC website")
    public void goToTheBBC() {
        getHomePage.openBBCHomePage();
    }

    @When("A user clicks on a News Tab")
    public void goToTheNewsPage() {
        getHomePage.goToNewsPage();
    }

    @Then("A user should see a headline news title {string}")
    public void verifyHeadlineNewsTitle(String title) {
        AssertionsForClassTypes.assertThat(getNewsPage.actualHeadlineNewsTitle().equals(title))
                .overridingErrorMessage("The title is not correct.")
                .isTrue();
    }

    @And("The list of secondary news contains following titles")
    public void secondaryNewsTitles(List<String> expectedSecondaryNewsTitles) {
        Assertions.assertThat(getNewsPage.getSecondaryNewsTitlesList())
                .extracting(WebElement::getText)
                .as("The secondary news titles are not as expected")
                .containsAll(expectedSecondaryNewsTitles);
    }

}
