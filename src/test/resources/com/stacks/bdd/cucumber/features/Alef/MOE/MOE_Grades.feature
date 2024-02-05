
Feature: ALEF - Idn grades sanity tests


  Scenario: Idn - Check search for grades
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "grades" section
    When I search for "8"
    Then I find "8"

  Scenario: Idn - Check edit grades page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "grades" section
    And I search for "8"
    When I click on edit button
    Then Edit Grades staff page appear

  Scenario: Idn - Check add grades page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "grades" section
    And I search for "8"
    When I click on add grades button
    Then Add grades page appear

  Scenario: Idn -  Check delete grade pop up
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "grades" section
    And I search for "8"
    When I click on delete button in grades page
    Then Delete grade pop up message appear









