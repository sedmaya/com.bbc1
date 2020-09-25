Feature: As a user I want to get a correct news titles on a News page

  Background:
    Given A user opens the BBC website
    When A user clicks on a News Tab
    And A user closes a Sign in PopUp

  Scenario: First news title in searched category should has a correct name

    And A user sees a headline's category name
    Then A user enters a headline's category name into a search bar
    And A user should see a correct name of the very first article "D-Block Europe"









