Feature: This feature simulates the creation of a new hotel entry


  Scenario: Create entry

    Given a user is on the hotel booker platform
    And the user is logged in
    When the following hotel details are entered and created:
      | Name    | Hilton                            |
      | Address | 23 Penrith Close, Bromley BR4 5YT |
      | Owner   | Novotel Group                     |
      | Tel     | 0207665432                        |
      | Email   | novotel@novotel.com               |
    Then the page is updated with the following
      | Hilton                            |
      | 23 Penrith Close, Bromley BR4 5YT |
      | Novotel Group                     |
      | 0207665432                        |
      | novotel@novotel.com               |