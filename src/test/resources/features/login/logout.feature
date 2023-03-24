@FIDEX10-465 @smoke
Feature: Logout Functionality

  #Test Case 1
  @FIDEX10-464
  Scenario: Verify User can log out successfully
    When User log in to the Homepage
    And User clicks log out button
    Then User logs lands on login page
    When User navigates back
    Then User should see the Session Expired Message

