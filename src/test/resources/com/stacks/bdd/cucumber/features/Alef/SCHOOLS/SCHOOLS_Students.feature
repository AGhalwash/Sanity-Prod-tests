
Feature: ALEF - Schools students sanity tests


  Scenario: Schools - Check search for students
    Given I Login to ALEF With "ADMIN_USER_Schools" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "students" section
    When I search for "Khaled Saeed Marzooq"
    Then I find "Khaled Saeed Marzooq"


  Scenario: Schools - Check edit student page
    Given I Login to ALEF With "ADMIN_USER_Schools" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "students" section
    And I search for "Khaled Saeed Marzooq"
    When I click on edit button
    Then Edit student page appeared


  Scenario: Schools - Check delete student page
    Given I Login to ALEF With "ADMIN_USER_Schools" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "students" section
    And I search for "Khaled Saeed Marzooq"
    When I click on delete button
    Then Delete student pop up message appear


  Scenario: Schools - Check add class page
    Given I Login to ALEF With "ADMIN_USER_Schools" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "students" section
    When I click on add student button
    Then Add student page appeared

  Scenario: Schools - Check Set QR Code student page
    Given I Login to ALEF With "ADMIN_USER_Schools" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "students" section
    And I search for "Khaled Saeed Marzooq"
    When I click on Set QR Code button
    Then Set QR code count pop up appears


  Scenario: Schools - Check disable section page
    Given I Login to ALEF With "ADMIN_USER_Schools" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "students" section
    And I search for "Khaled Saeed Marzooq"
    When I click on disable student button
    Then Disable student pop up appear





