package com.bbc1.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.bbc1.pages.PageUtil.PageProvider.getNewsPage;
import static com.bbc1.pages.PageUtil.PageProvider.getsSearchResultPage;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchResultsSteps {

    @And("A user closes a Sign in PopUp")
    public void closeSignInPopUp() {
        getNewsPage.signInPopUpHandler();
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
    public void actualFieldArticleName(String expectedFirstArticleTitle) {
        assertThat(getsSearchResultPage.actualFieldArticleName().equals(expectedFirstArticleTitle))
                .overridingErrorMessage("The title is not correct.")
                .isTrue();
    }


}
