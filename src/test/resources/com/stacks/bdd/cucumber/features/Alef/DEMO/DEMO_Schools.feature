
Feature: ALEF - Demo sanity tests


  Scenario: Demo - Check pathway search
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I click on first school
    And I click on "classes" section
    And I click on add class button
    When I search by "pathway" in class material dropdown menu
    Then I find pathway options

  Scenario: Demo - Check search for class
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "classes" section
    When I search for "Testing Admin"
    Then I find "Testing Admin"

  Scenario: Demo - Check Class page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "classes" section
    And I search for "Testing Admin"
    When I select "Testing Admin"
    Then Class page appeared


  Scenario: Demo - Check edit class page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "classes" section
    And I search for "Testing Admin"
    When I click on edit button
    Then Edit class page appeared

  Scenario: Demo - Check delete class page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "classes" section
    And I search for "Testing Admin"
    When I click on delete button
    Then Delete pop up message appear




