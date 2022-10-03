Feature: User should be able to login with correct credentials

  Background:
    Given user is in web table login page

  @webAppLogin
  Scenario: Web Table login scenario
    When user enters user name "Test"
    And user enters password "Tester"
    And user click login button
    Then user should see url contains orders

  Scenario: Positive login scenario
    When user enters username "Test", password "Tester" and login
    Then user should see url contains orders


  Scenario: Map data table practice
    When user enters below credentials
      | username | Test   |
      | password | Tester |


