Feature: Passing multiple parameters to the step

  @dataTable
  Scenario: User searches for multiple items
    Given user is on Google search page
    Then User should be able to search for following:
      | java         |
      | selenium     |
      | cucumber bdd |
      | data driven  |
      | wooden spoon |




# CTRL+ALT+L
