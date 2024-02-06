
Feature: ALEF - Demo sections sanity tests

  Scenario: Demo - Check search for section
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "sections" section
    When I search for "11-4"
    Then I find "11-4"

  Scenario: Demo - Check edit section page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "sections" section
    And I search for "11-4"
    When I click on edit button
    Then Edit section page appeared

  Scenario: Demo - Check delete section page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "sections" section
    And I search for "11-4"
    When I click on delete section button
    Then Delete section pop up message appear

  Scenario: Demo - Check add section page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "sections" section
    When I click on add section button
    Then Add section page appeared


  Scenario: Demo - Check disable section page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "sections" section
    And I search for "11-2"
    When I click on disable section button
    Then I find section "11-2" is disabled


  Scenario: Demo - Check enable section page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "sections" section
    And I search for "11-2"
    When I click on enable section button
    Then I find "11-2"

  Scenario: Demo - Check generate sections page
    Given I Login to ALEF With "ADMIN_USER_DEMO" in environment "Demo"
    And I search for "0 Multi Subject DO not touch"
    And I select "0 Multi Subject DO not touch"
    And I click on "sections" section
    When I click on generate sections button
    Then Generate sections page appears
