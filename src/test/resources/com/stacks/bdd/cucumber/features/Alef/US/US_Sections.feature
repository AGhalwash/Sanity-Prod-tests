Feature: ALEF - Us sections sanity tests

  Scenario: Us - Check search for section
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "sections" section
    When I search for "6-(2)"
    Then I find "6-(2)"


  Scenario: Us - Check edit section page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "sections" section
    And I search for "6-(2)"
    When I click on edit button
    Then Edit section page appeared


  Scenario: Us - Check delete section page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "sections" section
    And I search for "6-(2)"
    When I click on delete section button
    Then Delete section pop up message appear


  Scenario: Us - Check add section page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "sections" section
    When I click on add section button
    Then Add section page appeared


  Scenario: Us - Check disable section page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "sections" section
    And I search for "6-(5)"
    When I click on disable section button
    Then I find section "6-(5)" is disabled


  Scenario: Us - Check enable section page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "sections" section
    And I search for "6-(5)"
    When I click on enable section button
    Then I find "6-(5)"


  Scenario: Us - Check generate sections page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "sections" section
    When I click on generate sections button
    Then Generate sections page appears
