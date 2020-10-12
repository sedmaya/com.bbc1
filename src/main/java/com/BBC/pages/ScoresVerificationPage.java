package com.BBC.pages;

public class ScoresVerificationPage extends BasePage {

    private static final String SCORES_CONTAINERS
            = "//ancestor::section[contains(@class, 'header')]";

    public String actualScoresXpath(){
        return TEAMS_SCOREBOARD_CONTAINER + SCORES_CONTAINERS + SCORES_NUMBERS;
    }
}
