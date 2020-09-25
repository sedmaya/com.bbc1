package com.bbc1.junit.steps;

import com.bbc1.junit.pages.HomePage;
import com.bbc1.junit.pages.NewsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NewsPageSteps {
    HomePage homePage = new HomePage();
    NewsPage newsPage = new NewsPage();

    @Given("A user opens the BBC website")
    public void goToTheBBC() {
        homePage.openBBCHomePage();
    }

    @When("A user clicks on a News Tab")
    public void goToTheNewsPage() {
        homePage.goToNewsPage();
    }

    @Then("A user should see a headline news title {string}")
    public void verifyHeadlineNewsTitle(String title) {
        AssertionsForClassTypes.assertThat(newsPage.actualHeadlineNewsTitle().equals(title))
                .overridingErrorMessage("The title is not correct.")
                .isTrue();
    }


    @And("A user should see {int} secondary news titles")
    public void secondaryNewsQuantity(int expectedSecondaryNewsTitles) {
        Assertions.assertThat(newsPage.getSecondaryNewsTitlesList())
                .as("The secondary news titles list size is not as expected")
                .hasSize(expectedSecondaryNewsTitles);
    }

    @And("The list of secondary news contains following titles")
    public void secondaryNewsTitles(List<String> expectedSecondaryNewsTitles) {
        Assertions.assertThat(newsPage.getSecondaryNewsTitlesList())
                .extracting(WebElement::getText)
                .as("The secondary news titles are not as expected")
                .containsAll(expectedSecondaryNewsTitles);
    }
}
