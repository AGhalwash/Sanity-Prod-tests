
Feature: ALEF - Schools classes sanity tests


  Scenario: Schools - Check pathway search
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I click on first school
    And I click on "classes" section
    And I click on add class button
    When I search by "pathway" in class material dropdown menu
    Then I find pathway options

  Scenario: Schools - Check search for class
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    When I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "classes" section
    When I search for "Islamic Studies"
    Then I find "Islamic Studies"

  Scenario: Schools - Check Class page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    When I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "classes" section
    And I search for "Islamic Studies"
    When I select "Islamic Studies"
    Then Class page appeared

  Scenario: Schools - Check edit class page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    When I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "classes" section
    And I search for "Islamic Studies"
    When I click on edit button
    Then Edit class page appeared

  Scenario: Schools - Check delete class page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    When I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "classes" section
    And I search for "Islamic Studies"
    When I click on delete button
    Then Delete pop up message appear

  Scenario: Schools - Check add class page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    When I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "classes" section
    When I click on add class button
    Then Add class page appears