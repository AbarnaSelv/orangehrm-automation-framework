Feature: Add Employee

  @PIM
  Scenario Outline: Add employee with data
    Given user is logged in as "Admin" and "admin123"
    When user navigates to PIM add employee
    And user adds employee with "<first>" "<last>"
    Then employee should be added

    Examples:
      | first   | last    |
      | Vadivu  | Selvam  |
      | Selvam    | Ganapathi   |
