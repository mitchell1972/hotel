Feature: This feature simulates the login action of a user

  Scenario: login
    Given a user is on the hotel booker platform
    When the admin username and password is entered
    Then the user is successfull logged in