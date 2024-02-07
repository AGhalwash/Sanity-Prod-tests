
Feature: ALEF - Moe students sanity tests


  Scenario: Moe - Check search for students
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "students" section
    When I search for "Naeema"
    Then I find "Naeema"


  Scenario: Moe - Check edit student page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "students" section
    And I search for "Naeema"
    When I click on edit button
    Then Edit student page appeared


  Scenario: Moe - Check delete student page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "students" section
    And I search for "Naeema"
    When I click on delete button
    Then Delete student pop up message appear


  Scenario: Moe - Check add class page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "students" section
    When I click on add student button
    Then Add student page appeared

  Scenario: Moe - Check Set QR Code student page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "students" section
    And I search for "Naeema"
    When I click on Set QR Code button
    Then Set QR code count pop up appears


  Scenario: Moe - Check disable section page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "students" section
    And I search for "Naeema"
    When I click on disable student button
    Then Disable student pop up appear





