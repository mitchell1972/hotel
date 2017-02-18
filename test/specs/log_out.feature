Feature: This feature simulates the logout action of a user

  Scenario: logout
    Given a user is on the hotel booker platform
    And the user is logged in
    When the logout menu is clicked
    Then the user is logged out
    And the logout menu is updated toa login menu
