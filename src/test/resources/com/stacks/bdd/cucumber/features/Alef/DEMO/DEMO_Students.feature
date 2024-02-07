
Feature: ALEF - Demo students sanity tests


  Scenario: Demo - Check search for students
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "students" section
    When I search for "Evelien"
    Then I find "Evelien"


  Scenario: Demo - Check edit student page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "students" section
    And I search for "Evelien"
    When I click on edit button
    Then Edit student page appeared


  Scenario: Demo - Check delete student page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "students" section
    And I search for "Evelien"
    When I click on delete button
    Then Delete student pop up message appear


  Scenario: Demo - Check add class page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "students" section
    When I click on add student button
    Then Add student page appeared

  Scenario: Demo - Check Set QR Code student page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "students" section
    And I search for "Evelien"
    When I click on Set QR Code button
    Then Set QR code count pop up appears


  Scenario: Demo - Check disable section page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "students" section
    And I search for "Kamtest177"
    When I click on disable student button
    Then Disable student pop up appear





