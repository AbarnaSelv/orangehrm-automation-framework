Feature: Add employees from Excel

  @PIM @Excel
  Scenario: Add multiple employees from excel
    Given user is logged in as "Admin" and "admin123"
    When user adds employees from excel "src/test/resources/testdata/employees.xlsx"
    Then all employees from excel should be added
