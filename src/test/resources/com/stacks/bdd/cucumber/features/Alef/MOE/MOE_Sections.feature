
Feature: ALEF - Moe sections sanity tests

  Scenario: Moe - Check search for section
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "sections" section
    When I search for "05/03"
    Then I find "05/03"


  Scenario: Moe - Check edit section page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "sections" section
    And I search for "05/03"
    When I click on edit button
    Then Edit section page appeared


  Scenario: Moe - Check delete section page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "sections" section
    And I search for "05/03"
    When I click on delete section button
    Then Delete section pop up message appear


  Scenario: Moe - Check add section page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "sections" section
    When I click on add section button
    Then Add section page appeared


  Scenario: Moe - Check disable section page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "sections" section
    And I search for "05/04"
    When I click on disable section button
    Then I find section "05/04" is disabled


  Scenario: Moe - Check enable section page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "sections" section
    And I search for "05/04"
    When I click on enable section button
    Then I find "05/04"


  Scenario: Moe - Check generate sections page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "sections" section
    When I click on generate sections button
    Then Generate sections page appears
