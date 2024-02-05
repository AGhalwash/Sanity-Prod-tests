
Feature: ALEF - Demo grades sanity tests


  Scenario: Demo - Check search for grades
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "grades" section
    When I search for "5678"
    Then I find "5678"

  Scenario: Demo - Check edit grades page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "grades" section
    And I search for "5678"
    When I click on edit button
    Then Edit Grades staff page appear

  Scenario: Demo - Check add grades page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "grades" section
    And I search for "5678"
    When I click on add grades button
    Then Add grades page appear

  Scenario: Demo -  Check delete grade pop up
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "grades" section
    And I search for "5678"
    When I click on delete button in grades page
    Then Delete grade pop up message appear









