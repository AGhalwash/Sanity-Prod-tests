
Feature: ALEF - Us staff sanity tests


  Scenario: Us - Check search for staff
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "Kentucky"
    And I search for "Alef US School - Kentucky 2023/2024"
    And I select "Alef US School - Kentucky 2023/2024"
    And I click on "staff" section
    When I search for "Prabitha"
    Then I find "Prabitha"

  Scenario: Us - Check edit staff page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "Kentucky"
    And I search for "Alef US School - Kentucky 2023/2024"
    And I select "Alef US School - Kentucky 2023/2024"
    And I click on "staff" section
    And I search for "Prabitha"
    When I click on edit button
    Then Edit school staff page appear

  Scenario: US - Check add staff page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "Kentucky"
    And I search for "Alef US School - Kentucky 2023/2024"
    And I select "Alef US School - Kentucky 2023/2024"
    And I click on "staff" section
    And I search for "Prabitha"
    When I click on add staff button
    Then Add school staff page appear

  Scenario: Us -  Check disable staff pop up
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "Kentucky"
    And I search for "Alef US School - Kentucky 2023/2024"
    And I select "Alef US School - Kentucky 2023/2024"
    And I click on "staff" section
    And I search for "Prabitha"
    When I click on disable button
    Then Disable staff pop up appear