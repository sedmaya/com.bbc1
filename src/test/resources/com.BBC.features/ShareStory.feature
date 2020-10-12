Feature: As a user I want to be able resubmit the form when invalid data entered

  Background:
    Given A user opens the BBC website
    Given A user clicks on the "News" Tab
    Given A user closes a "sign_in" PopUp
    Given A user clicks a "Coronavirus" Tab
    Given A user clicks on a "Your Coronavirus Stories" subTab
    Given A user clicks on "How to share with BBC News" link


  Scenario Outline: The submit button should be enabled after a user clicks on it with empty/invalid required field
    When A user fills the form with empty or invalid required fields
      | Tell us your story. | <story> |
      | Name                | <name>  |
      | Email address       | <email> |
    And selects checkboxes
      | I am over 16 years old | <age check>   |
      | Terms of Service       | <terms check> |
    And A user hits the Submit button
    Then The Submit button stays enabled after a user clicks on it
    Examples:
      | story                   | name    | email              | age check | terms check |
      |                         | Zinaida |                    | checked   | checked     |
      | Hello! This is my story |         |                    | checked   | checked     |
      | Hello! This is my story | Zinaida | @BiGmir.gov.dotNet | checked   | checked     |
      | Hello! This is my story | Zinaida |                    |           | checked     |
      | Hello! This is my story | Zinaida |                    | checked   |             |