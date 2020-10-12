package com.BBC.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.BBC.pages.PageUtil.PageProvider.*;
import static org.assertj.core.api.Assertions.assertThat;

public class NewsPageSteps {

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

    @Then("A user sees a headline's category name")
    public void getHeadlineCategoryTitle() {
        getNewsPage.getHeadlineCategoryTitle();
    }

    @Then("A user enters a headline's category name into a search bar")
    public void enterCategoryIntoSearchBar() {
        getNewsPage.enterCategoryIntoSearchBar();
    }

    @Then("A user should see a correct name of the very first article {string}")
    public void actualFirstArticleName(String expectedFirstArticleTitle) {
        assertThat(getsSearchResultPage.actualFirstArticleName().equals(expectedFirstArticleTitle))
                .overridingErrorMessage("The title is not correct.")
                .isTrue();
    }

}
