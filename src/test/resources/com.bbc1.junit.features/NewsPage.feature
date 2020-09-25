Feature: As a user I want to get a correct news titles on a News page

  Background:
    Given A user opens the BBC website
    When A user clicks on a News Tab

  Scenario: A headline news title should be properly named
    Then A user should see a headline news title "Paris stabbing attack 'an act of terrorism'"

  Scenario: Secondary news titles should be properly displayed
    Then A user should see 5 secondary news titles
    And The list of secondary news contains following titles
      | Global virus deaths could reach two million - WHO |
      | Ginsburg becomes first US woman to lie in state   |
      | Ginsburg's trainer honours her with push-ups      |
      | Attenborough breaks Aniston's Instagram record    |
      | Freshers on their 'last night of freedom'         |

