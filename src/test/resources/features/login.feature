Feature: OrangeHRM Login

  @Login
  Scenario Outline: Login scenarios
    Given user opens login page
    When user logs in with "<username>" and "<password>"
    Then dashboard should be visible

    Examples:
      | username | password |
      | Admin    | admin123 |
