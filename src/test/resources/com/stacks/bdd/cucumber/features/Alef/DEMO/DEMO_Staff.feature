
Feature: ALEF - Demo schools sanity tests


  Scenario: Demo - Check search for school
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    When I search for "0 Multi Subject DO not touch"
    Then I find "0 Multi Subject DO not touch"


  Scenario: Demo - Check school details page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    When I select "0 Multi Subject DO not touch"
    Then School details page appears

  Scenario: Demo - Check edit schools page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    When I click on edit button
    Then Edit school page appears

  Scenario: Demo - Check delete schools page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    When I click on delete button for schools
    Then Delete school pop up message appear

  Scenario: Demo - Check disable schools page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    When I click on disable button for schools
    Then Disable school pop up message appear







