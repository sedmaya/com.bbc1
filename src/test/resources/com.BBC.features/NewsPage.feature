Feature: As a user I want to get a correct news titles on a News page

  Background:
    Given A user opens the BBC website
    When A user clicks on the "News" Tab
    And  A user closes a "sign_in" PopUp

  Scenario: A headline news title should be properly named
    Then A user should see a headline news title "Trump pick testifies in tense Supreme Court hearing"


  Scenario: Secondary news titles should be properly displayed
    Then The list of secondary news contains following titles
      | PM holding press conference on Covid alert tiers  3 minutes ago |
      | Italian teenager could be first millennial saint                |
      | BTS in trouble in China over Korean War comments                |
      | Black man led by police on horseback sues for $1m               |
      | A brand new hand, from my brother                               |

  Scenario: First news title in searched category should has a correct name
    Then A user sees a headline's category name
    And A user enters a headline's category name into a search bar
    And A user should see a correct name of the very first article "Woman arrested at US-Canada border for poison mailed to White House"






