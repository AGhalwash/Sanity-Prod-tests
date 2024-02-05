
Feature: ALEF - Schools schools sanity tests


  Scenario: Schools - Check search for school
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    When I search for "AL AIN MILITARY HIGH SCHOOL"
    Then I find "AL AIN MILITARY HIGH SCHOOL"


  Scenario: Schools - Check school details page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    When I select "AL AIN MILITARY HIGH SCHOOL"
    Then School details page appears

  Scenario: Schools - Check edit schools page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    When I click on edit button
    Then Edit school page appears

  Scenario: Schools - Check delete schools pop up
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    When I click on delete button for schools
    Then Delete school pop up message appear

  Scenario: Schools - Check disable schools pop up
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    When I click on disable button for schools
    Then Disable school pop up message appear