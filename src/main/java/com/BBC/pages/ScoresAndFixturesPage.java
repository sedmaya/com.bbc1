package com.BBC.pages;

import com.BBC.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public class ScoresAndFixturesPage extends BasePage {

    private static final String SEARCH_INPUT = "downshift-0-input";
    private static final String SEARCHED_MONTH_YEAR = "//a[contains(@href, '%s')]";


    public String actualScoresXpath(String homeTeam, String awayTeam) {
        return format(TEAMS_SCOREBOARD_CONTAINER, homeTeam, awayTeam) + SCORES_NUMBERS;
    }

    public void enterRequestIntoSearchBar(String searchWords) {
        findElement(By.id(SEARCH_INPUT)).sendKeys(searchWords, Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void clickResultsMonthAndYear(String period) {
        retryingFindClick(By.xpath(format(SEARCHED_MONTH_YEAR, period)));
    }

    public void clickTeamScoreboard(String homeTeam, String awayTeam) {
        WebElement element = findElement(By.xpath(actualScoresXpath(homeTeam, awayTeam)));
        waitForElementIsClickable(element);
        element.click();
    }
}