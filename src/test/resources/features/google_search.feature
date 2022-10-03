@smoke
Feature: Google Search Functionality Title Verification

  User story: As a user, when I am on Google search page
  I should be able to search whatever I want and see relevant information

  Background:
    Given user is on Google search page


  Scenario: Search functionality result title verification
    When user types apple in the google search box and clicks enter
    Then user sees apple - Google Search in in the Google title

    @googleSearch
    Scenario: Search functionality result title verification
      When user types "apple" in the google search box and clicks enter
      Then user sees "apple - Google Search" in in the Google title

