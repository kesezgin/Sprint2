@FIDEX10-451 @smoke
Feature: Login Functionality

  Background: Login page
    Given User is on the login page


  #Test Case 1
  @FIDEX10-446
  Scenario Outline: Login with valid credentials
    When User enters email "<email>"
    And User enters password "<password>"
    And User clicks login button
    Then User should be on the homepage

    Examples: Email and Password
      | email                   | password     |
      | salesmanager19@info.com | salesmanager |
      | salesmanager39@info.com | salesmanager |
      | posmanager59@info.com   | posmanager   |
      | posmanager79@info.com   | posmanager   |

  #Test Case 2
  @FIDEX10-447
  Scenario Outline: Login with invalid credentials
    When User enters email "<email>"
    And User enters password "<password>"
    And User clicks login button
    Then User should see the error message

    Examples: Email and Password
      | email                    | password          |
      | salesmanager199@info.com | salesmanager      |
      | salesmanager19@info.com  | Supersalesmanager |
      | posmanager199@info.com   | posmanager        |
      | posmanager19@info.com    | Superposmanager   |

  #Test Case 3
  #"Please fill out this field" message should be displayed if the password or username is empty"
  @FIDEX10-448
  Scenario Outline: Login with empty email or password
    When User enters email "<email>"
    And User enters password "<password>"
    And User clicks login button
    Then User should see the "Please fill out this field." error message

    Examples: Email and Password
      | email                   | password     |
      |                         | salesmanager |
      |                         | posmanager   |
      | salesmanager19@info.com |              |
      | posmanager79@info.com   |              |

  #Test Case 4
  @FIDEX10-449
  Scenario: User should see the password in bullet signs by default
    When User enters password "password"
    Then user should see it in bullet signs by default


  #Test Case 5
  @FIDEX10-450
  Scenario Outline: User should be able to use "Enter" key of the keyboard on the login page
    When User enters email "<email>"
    And User enters password "<password>"
    And User hits the Enter key
    Then User should be on the homepage
    Examples: Email and Password
      | email                   | password     |
      | salesmanager19@info.com | salesmanager |
      | posmanager39@info.com   | posmanager   |
