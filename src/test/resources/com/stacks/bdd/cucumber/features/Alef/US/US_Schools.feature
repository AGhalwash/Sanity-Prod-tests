
Feature: ALEF - Us schools sanity tests


  Scenario: Us - Check search for school
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    When I search for "Polk County Middle School"
    Then I find "Polk County Middle School"

  Scenario: Us - Check school details page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    When I select "Polk County Middle School"
    Then School details page appears

  Scenario: Us - Check edit schools page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    When I click on edit button
    Then Edit school page appears

  Scenario: Us - Check delete schools pop up
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    When I click on delete button for schools
    Then Delete school pop up message appear

  Scenario: Us - Check disable schools pop up
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    When I click on disable button for schools
    Then Disable school pop up message appear