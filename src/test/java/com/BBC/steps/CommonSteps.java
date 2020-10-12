package com.BBC.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.BBC.pages.PageUtil.PageProvider.getHomePage;
import static com.BBC.pages.PageUtil.PageProvider.getNewsPage;

public class CommonSteps {

    @Given("A user opens the BBC website")
    public void goToTheBBC() {
        getHomePage.openBBCHomePage();
    }

    @When("A user clicks on the {string} Tab")
    public void goToThePage(String tab) {
        getHomePage.goToPage(tab);
    }

    @And("A user closes a {string} PopUp")
    public void closeSignInPopUp(String popUpName) {
        getNewsPage.popUpHandler(popUpName);
    }
}
