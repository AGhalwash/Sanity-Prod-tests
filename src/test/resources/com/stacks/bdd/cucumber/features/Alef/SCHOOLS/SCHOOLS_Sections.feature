Feature: ALEF - Schools sections sanity tests

  Scenario: Schools - Check search for section
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "sections" section
    When I search for "12-A"
    Then I find "12-A"


  Scenario: Schools - Check edit section page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "sections" section
    And I search for "12-A"
    When I click on edit button
    Then Edit section page appeared


  Scenario: Schools - Check delete section page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "sections" section
    And I search for "12-A"
    When I click on delete section button
    Then Delete section pop up message appear


  Scenario: Schools - Check add section page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "sections" section
    When I click on add section button
    Then Add section page appeared


  Scenario: Schools - Check disable section page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "sections" section
    And I search for "12-G"
    When I click on disable section button
    Then I find section "12-G" is disabled


  Scenario: Schools - Check enable section page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "sections" section
    And I search for "12-G"
    When I click on enable section button
    Then I find "12-G"


  Scenario: Schools - Check generate sections page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "sections" section
    When I click on generate sections button
    Then Generate sections page appears
