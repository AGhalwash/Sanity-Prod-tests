
Feature: ALEF - Idn staff sanity tests


  Scenario: Idn - Check search for staff
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "staff" section
    When I search for "Principal 20"
    Then I find "Principal 20"

  Scenario: Idn - Check edit staff page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "staff" section
    And I search for "Principal 20"
    When I click on edit button
    Then Edit school staff page appear

  Scenario: Idn - Check add staff page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "staff" section
    And I search for "Principal 20"
    When I click on add staff button
    Then Add school staff page appear

  Scenario: Idn -  Check disable staff pop up
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "staff" section
    And I search for "Principal 20"
    When I click on disable button
    Then Disable staff pop up appear