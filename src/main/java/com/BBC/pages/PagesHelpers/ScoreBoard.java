package com.BBC.pages.PagesHelpers;

import com.BBC.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;


public class ScoreBoard {
    private final String actualScoresContainers;

    public ScoreBoard(String actualScoresListXpath) {
        actualScoresContainers = actualScoresListXpath;
    }

    public List<WebElement> findElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public Score getScore(String homeTeam, String awayTeam) {
        List<WebElement> score = findElements(By.xpath(format(actualScoresContainers, homeTeam, awayTeam)));
        if (score == null || score.size() != 2) {
            throw new RuntimeException("Teams container not found");
        }
        return new Score(Integer.parseInt(score.get(0).getText()), Integer.parseInt(score.get(1).getText()));
    }
}
