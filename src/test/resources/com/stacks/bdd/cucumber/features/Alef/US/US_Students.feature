
Feature: ALEF - Us students sanity tests


  Scenario: Us - Check search for students
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "students" section
    When I search for "Cano-chavez"
    Then I find "Cano-chavez"


  Scenario: Us - Check edit student page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "students" section
    And I search for "Cano-chavez"
    When I click on edit button
    Then Edit student page appeared


  Scenario: Us - Check delete student page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "students" section
    And I search for "Cano-chavez"
    When I click on delete button
    Then Delete student pop up message appear


  Scenario: Us - Check add class page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "students" section
    When I click on add student button
    Then Add student page appeared

  Scenario: Us - Check Set QR Code student page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "students" section
    And I search for "Cano-chavez"
    When I click on Set QR Code button
    Then Set QR code count pop up appears


  Scenario: Us - Check disable section page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "students" section
    And I search for "Cano-chavez"
    When I click on disable student button
    Then Disable student pop up appear





