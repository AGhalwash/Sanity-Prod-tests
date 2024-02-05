
Feature: ALEF - Demo staff sanity tests


  Scenario: Demo - Check search for staff
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "staff" section
    When I search for "Test-prin"
    Then I find "Test-prin"

  Scenario: Demo - Check edit staff page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "staff" section
    And I search for "Test-prin"
    When I click on edit button
    Then Edit school staff page appear










