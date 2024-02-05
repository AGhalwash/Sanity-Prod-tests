Feature: ALEF - Moe schools sanity tests


  Scenario: Moe - Check search for school
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    When I search for "Al Tafawwoq School"
    Then I find "Al Tafawwoq School"


  Scenario: Moe - Check school details page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    When I select "Al Tafawwoq School"
    Then School details page appears

  Scenario: Moe - Check edit schools page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    When I click on edit button
    Then Edit school page appears

  Scenario: Moe - Check delete schools pop up
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    When I click on delete button for schools
    Then Delete school pop up message appear

  Scenario: Moe - Check disable schools pop up
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    When I click on disable button for schools
    Then Disable school pop up message appear