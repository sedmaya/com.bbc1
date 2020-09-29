Feature: As a user I want to get a correct news titles on a News page

  Background:
    Given A user opens the BBC website
    When A user clicks on a News Tab

  Scenario: A headline news title should be properly named
    Then A user should see a headline news title "Covid deaths cross 'agonising' 1m milestone"

  Scenario: Secondary news titles should be properly displayed
    Then The list of secondary news contains following titles
      | How will Trump try to dominate this time?           |
      | Do voters care about Trump taxes?                   |
      | Where has been hit hardest by coronavirus?          |
      | TV crew finds new evidence in Estonia ship disaster |
      | India gang rape victim's death sparks outrage       |

