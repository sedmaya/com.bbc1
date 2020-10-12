Feature: As a user I want to get a correct football championships scores

  Background:
    Given A user opens the BBC website
    Given A user clicks on the "Sport" Tab
    Given A user closes a "sign_in" PopUp
    Given A user clicks the "Football" Tab
    Given A user clicks on the "Scores & Fixtures" subTab

  Scenario Outline: A correct score should be displayed for picked championship
    When A user enters a "<searchedChampionship>" into a search bar
    And A user clicks a "<period>"
    And A user should see game result as "<homeTeam>" <homeScore> <awayScore> "<awayTeam>"
    And A user clicks on a "<homeTeam>" and "<awayTeam>" link
    Then A user should see the same result

    Examples:
      | searchedChampionship     | period  | homeTeam             | homeScore | awayScore | awayTeam          |
      | Women's Champions League | 2020-08 | VfL Wolfsburg Ladies | 1         | 3         | Lyon Féminines    |
      | Champions League         | 2020-09 | FC Red Bull Salzburg | 3         | 1         | Maccabi Tel-Aviv  |
      | Championship             | 2020-06 | Cardiff City         | 0         | 0         | Charlton Athletic |
      | AFC Wimbledon            | 2020-09 | Fleetwood Town       | 0         | 1         | AFC Wimbledon     |
      | Scottish Premiership     | 2020-08 | Kilmarnock           | 4         | 0         | Dundee United     |









