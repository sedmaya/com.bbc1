package com.BBC.pages.PageUtil;

import com.BBC.driver.DriverManager;
import com.BBC.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageProvider {
    public static final HomePage getHomePage = new HomePage();
    public static final NewsPage getNewsPage = new NewsPage();
    public static final SearchResultPage getsSearchResultPage = new SearchResultPage();
    public static final CoronavirusPage getCoronavirusPage = new CoronavirusPage();
    public static final YourCoronavirusStoryPage getStoryPage = new YourCoronavirusStoryPage();
    public static final ShareWithBBCPage getShareWithBBCPage = new ShareWithBBCPage();
    public static final SportPage getSportPage = new SportPage();
    public static final FootballPage getFootballPage = new FootballPage();
    public static final ScoresAndFixturesPage getScoresAndFixturesPage = new ScoresAndFixturesPage();
    public static final ScoresVerificationPage getScoresVerificationPage = new ScoresVerificationPage();

    public static WebElement findElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public static List<WebElement> findElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

}
