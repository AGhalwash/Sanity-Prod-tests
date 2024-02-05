Feature: ALEF - Moe classes sanity tests


  Scenario: Moe - Check pathway search
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I click on first school
    And I click on "classes" section
    And I click on add class button
    When I search by "pathway" in class material dropdown menu
    Then I find pathway options

  Scenario: Moe - Check search for class
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "classes" section
    When I search for "Islamic Studies"
    Then I find "Islamic Studies"

  Scenario: Moe - Check Class page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "classes" section
    And I search for "Islamic Studies"
    When I select "Islamic Studies"
    Then Class page appeared

  Scenario: Moe - Check edit class page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "classes" section
    And I search for "Islamic Studies"
    When I click on edit button
    Then Edit class page appeared

  Scenario: Moe - Check delete class page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "classes" section
    And I search for "Islamic Studies"
    When I click on delete button
    Then Delete pop up message appear

  Scenario: Moe - Check add class page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "classes" section
    When I click on add class button
    Then Add class page appears