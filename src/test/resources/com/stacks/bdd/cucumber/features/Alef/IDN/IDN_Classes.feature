
Feature: ALEF - Us sanity tests


  Scenario: ALEF-43855 - Fix missing pathway class materials on search when creating class as admin
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I click on first school
    And I click on "classes" section
    And I click on add class button
    When I search by "pathway" in class material dropdown menu
    Then I find pathway options