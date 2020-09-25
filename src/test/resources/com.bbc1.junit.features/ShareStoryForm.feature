Feature: As a user I want to see if the form is submittable when invalid data entered

  Background:
    Given A user opens the BBC website
    Given A user clicks on a News Tab
    Given A user closes a Sign in PopUp
    Given A user clicks on a Coronavirus Tab
    Given A user clicks on a Your Coronavirus Stories Tab
    Given A user clicks on How to share with BBC News link

  Scenario: The submit button should be enabled if a user clicks on it with empty Story field
    When A user fills the form but leaves Story field empty
    Then The submit button stays enabled after a user clicks on it

  Scenario: The submit button should be enabled if a user clicks on it with empty Name field
    When A user fills the form but leaves Name field empty
    Then The submit button stays enabled after a user clicks on it

  Scenario: The submit button should be enabled if a user clicks on it with invalid Email field
    When A user fills the form with invalid Email
    Then The submit button stays enabled after a user clicks on it

  Scenario: The submit button should be enabled if a user clicks on it with unchecked Over 16 checkbox
    When A user fills the form with unchecked I am over 16 years old checkbox
    Then The submit button stays enabled after a user clicks on it

  Scenario: The submit button should be enabled if a user clicks on it with unchecked Accept terms checkbox
    When A user fills the form with unchecked Terms of Service checkbox
    Then The submit button stays enabled after a user clicks on it


