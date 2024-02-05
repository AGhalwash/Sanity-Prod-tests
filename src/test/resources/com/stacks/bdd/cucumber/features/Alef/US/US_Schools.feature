
Feature: ALEF - Us sanity tests


  Scenario: Us - Check pathway search
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I click on first school
    And I click on "classes" section
    And I click on add class button
    When I search by "pathway" in class material dropdown menu
    Then I find pathway options

  Scenario: Us - Check search for class
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "classes" section
    When I search for "Core 1 - Graber"
    Then I find "Core 1 - Graber"

  Scenario: Us - Check Class page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "classes" section
    And I search for "Core 1 - Graber"
    When I select "Core 1 - Graber"
    Then Class page appeared

  Scenario: Us - Check edit class page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "classes" section
    And I search for "Core 1 - Graber"
    When I click on edit button
    Then Edit class page appeared

  Scenario: Us - Check delete class page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "classes" section
    And I search for "Core 1 - Graber"
    When I click on delete button
    Then Delete pop up message appear