
Feature: ALEF - Idn sections sanity tests

  Scenario: Demo - Check search for section
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "sections" section
    When I search for "8-8-A"
    Then I find "8-8-A"

  Scenario: Idn - Check edit section page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "sections" section
    And I search for "8-8-A"
    When I click on edit button
    Then Edit section page appeared

  Scenario: Idn - Check delete section page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "sections" section
    And I search for "8-8-A"
    When I click on delete section button
    Then Delete section pop up message appear

  Scenario: Idn - Check add section page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "sections" section
    When I click on add section button
    Then Add section page appeared


  Scenario: Idn - Check disable section page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "sections" section
    And I search for "7--"
    When I click on disable section button
    Then I find section "7--" is disabled


  Scenario: Idn - Check enable section page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "sections" section
    And I search for "7--"
    When I click on enable section button
    Then I find "7--"

  Scenario: Idn - Check generate sections page
    Given I Login to ALEF With "ADMIN_USER_IDN" in environment "IDN"
    And I search for "DEMO SCHOOL (22189)"
    And I select "DEMO SCHOOL (22189)"
    And I click on "sections" section
    When I click on generate sections button
    Then Generate sections page appears
