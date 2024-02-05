
Feature: ALEF - Idn classes sanity tests


  Scenario: Idn - Check pathway search
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I click on first school
    And I click on "classes" section
    And I click on add class button
    When I search by "pathway" in class material dropdown menu
    Then I find pathway options

  Scenario: Idn - Check search for class
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "classes" section
    When I search for "Matematika 7"
    Then I find "Matematika 7"

  Scenario: Idn - Check Class page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "classes" section
    And I search for "Matematika 7"
    When I select "Matematika 7"
    Then Class page appeared

  Scenario: Idn - Check edit class page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "classes" section
    And I search for "Matematika 7"
    When I click on edit button
    Then Edit class page appeared

  Scenario: Idn - Check delete class page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "classes" section
    And I search for "Matematika 7"
    When I click on delete button
    Then Delete pop up message appear
