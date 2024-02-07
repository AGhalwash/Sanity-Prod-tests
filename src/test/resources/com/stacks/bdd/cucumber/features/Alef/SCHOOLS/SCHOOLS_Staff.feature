
Feature: ALEF - Schools staff sanity tests


  Scenario: Schools - Check search for staff
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "staff" section
    When I search for "Mariam"
    Then I find "Mariam"

  Scenario: Schools - Check edit staff page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "staff" section
    And I search for "Mariam"
    When I click on edit button
    Then Edit school staff page appear

  Scenario: Schools - Check add staff page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "staff" section
    And I search for "Mariam"
    When I click on add staff button
    Then Add school staff page appear

  Scenario: Schools -  Check disable staff pop up
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "staff" section
    And I search for "Mariam"
    When I click on disable button
    Then Disable staff pop up appear