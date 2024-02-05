Feature: ALEF - Moe grades sanity tests


  Scenario: Moe - Check search for grades
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "grades" section
    When I search for "5"
    Then I find "5" grade

  Scenario: Moe - Check edit grades page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "grades" section
    And I search for "5"
    When I click on edit grade button
    Then Edit Grades staff page appear

  Scenario: Moe - Check add grades page
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "grades" section
    And I search for "5"
    When I click on add grades button
    Then Add grades page appear

  Scenario: Moe -  Check delete grade pop up
    Given I Login to ALEF With "ADMIN_USER_MOE" in environment "MOE"
    And I search for "Al Tafawwoq School"
    And I select "Al Tafawwoq School"
    And I click on "grades" section
    And I search for "5"
    When I click on delete button in grades page
    Then Delete grade pop up message appear









