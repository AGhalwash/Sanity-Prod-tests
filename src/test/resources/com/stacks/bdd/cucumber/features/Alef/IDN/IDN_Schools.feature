
Feature: ALEF - Idn schools sanity tests


  Scenario: Idn - Check search for school
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    When I search for "DEMO SCHOOL (22189)"
    Then I find "DEMO SCHOOL (22189)"


  Scenario: Idn - Check school details page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    When I select "DEMO SCHOOL (22189)"
    Then School details page appears

  Scenario: Idn - Check edit schools page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    When I click on edit button
    Then Edit school page appears

  Scenario: Idn - Check delete schools page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    When I click on delete button for schools
    Then Delete school pop up message appear

  Scenario: Idn - Check disable schools page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    When I click on disable button for schools
    Then Disable school pop up message appear