
Feature: ALEF - Moe staff sanity tests


  Scenario: Moe - Check search for staff
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "staff" section
    When I search for "Mariam"
    Then I find "Principal 20"

  Scenario: Moe - Check edit staff page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "staff" section
    And I search for "Mariam"
    When I click on edit button
    Then Edit school staff page appear

  Scenario: Moe - Check add staff page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School)"
    And I click on "staff" section
    And I search for "Mariam"
    When I click on add staff button
    Then Add school staff page appear

  Scenario: Moe -  Check disable staff pop up
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "staff" section
    And I search for "Mariam"
    When I click on disable button
    Then Disable staff pop up appear