package com.BBC.steps;

import com.BBC.pages.PagesHelpers.Score;
import com.BBC.pages.PagesHelpers.ScoreBoard;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.data.MapEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.BBC.pages.PageUtil.PageProvider.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ScoresPageSteps {
    private List<Map.Entry<String, Integer>> expectedTeamsScores;

    @Given("A user clicks the {string} Tab")
    public void goToTheFootballPage(String footballTab) {
        getSportPage.goToFootballPage(footballTab);
    }

    @Given("A user clicks on the {string} subTab")
    public void goToTheScoresPage(String scoresTab) {
        getFootballPage.goToScoresPage(scoresTab);
    }

    @When("A user enters a {string} into a search bar")
    public void searchSpecificChampionship(String searchedChampionship) {
        getScoresAndFixturesPage.enterRequestIntoSearchBar(searchedChampionship);
    }

    @And("A user clicks a {string}")
    public void filterByMonth(String pickedMonth) {
        getScoresAndFixturesPage.clickResultsMonthAndYear(pickedMonth);
    }

    @Then("A user should see game result as {string} {int} {int} {string}")
    public void verifyScore(String homeTeam, int homeScore, int awayScore, String awayTeam) {
        expectedTeamsScores = new ArrayList<>();
        expectedTeamsScores.add(MapEntry.entry(homeTeam, homeScore));
        expectedTeamsScores.add(MapEntry.entry(awayTeam, awayScore));
        checkActualEqualsExpected(getScoresAndFixturesPage.actualScoresXpath(homeTeam, awayTeam));
    }

    @And("A user clicks on a {string} and {string} link")
    public void aUserClicksOnTeamsLink(String homeTeam, String awayTeam) {
        getScoresAndFixturesPage.clickTeamScoreboard(homeTeam, awayTeam);
    }

    @Then("A user should see the same result")
    public void isScoreTheSame() {
        checkActualEqualsExpected(getScoresVerificationPage.actualScoresXpath());
    }

    private void checkActualEqualsExpected(String actualScoresListXpath) {
        ScoreBoard scoreBoard = new ScoreBoard(actualScoresListXpath);
        Score actualScore = scoreBoard.getScore(
                expectedTeamsScores.get(0).getKey(), expectedTeamsScores.get(1).getKey());
        Score expectedScore = new Score(expectedTeamsScores.get(0).getValue(),
                expectedTeamsScores.get(1).getValue());
        assertThat(actualScore.equals(expectedScore))
                .overridingErrorMessage("The score is not correct.")
                .isTrue();
    }

}

