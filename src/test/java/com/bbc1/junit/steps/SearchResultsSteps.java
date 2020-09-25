package com.bbc1.junit.steps;

import com.bbc1.junit.pages.NewsPage;
import com.bbc1.junit.pages.SearchResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsSteps {
    NewsPage newsPage = new NewsPage();
    SearchResultPage searchResultPage = new SearchResultPage();

    @And("A user closes a Sign in PopUp")
    public void closeSignInPopUp() {
        newsPage.signInPopUpHandler();
    }

    @Then("A user sees a headline's category name")
    public void getHeadlineCategoryTitle() {
        newsPage.getHeadlineCategoryTitle();
    }

    @Then("A user enters a headline's category name into a search bar")
    public void enterCategoryIntoSearchBar() {
        newsPage.enterCategoryIntoSearchBar();
    }

    @Then("A user should see a correct name of the very first article {string}")
    public void actualFieldArticleName(String expectedFirstArticleTitle) {
        assertThat(searchResultPage.actualFieldArticleName().equals(expectedFirstArticleTitle))
                .overridingErrorMessage("The title is not correct.")
                .isTrue();
    }


}
