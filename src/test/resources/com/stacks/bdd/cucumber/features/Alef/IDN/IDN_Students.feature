
Feature: ALEF - Idn students sanity tests


  Scenario: Idn - Check search for students
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "students" section
    When I search for "Kayley"
    Then I find "Kayley"


  Scenario: Idn - Check edit student page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "students" section
    And I search for "Kayley"
    When I click on edit button
    Then Edit student page appeared


  Scenario: Idn - Check delete student page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "students" section
    And I search for "Kayley"
    When I click on delete button
    Then Delete student pop up message appear


  Scenario: Idn - Check add class page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "students" section
    When I click on add student button
    Then Add student page appeared

  Scenario: Idn - Check Set QR Code student page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "students" section
    And I search for "Kayley"
    When I click on Set QR Code button
    Then Set QR code count pop up appears


  Scenario: Idn - Check disable section page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "students" section
    And I search for "Kayley"
    When I click on disable student button
    Then Disable student pop up appear





