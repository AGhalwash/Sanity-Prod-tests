Feature: ALEF - Schools grades sanity tests


  Scenario: Schools - Check search for grades
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "grades" section
    When I search for "11"
    Then I find "5"

  Scenario: Schools - Check edit grades page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "grades" section
    And I search for "11"
    When I click on edit button
    Then Edit Grades staff page appear

  Scenario: Schools - Check add grades page
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "grades" section
    And I search for "11"
    When I click on add grades button
    Then Add grades page appear

  Scenario: Schools -  Check delete grade pop up
    Given I Login to ALEF With "ADMIN_USER_SCHOOLS" in environment "Schools"
    And I search for "AL AIN MILITARY HIGH SCHOOL"
    And I select "AL AIN MILITARY HIGH SCHOOL"
    And I click on "grades" section
    And I search for "11"
    When I click on delete button in grades page
    Then Delete grade pop up message appear









