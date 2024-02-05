Feature: ALEF - Us grades sanity tests


  Scenario: Us - Check search for grades
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "grades" section
    When I search for "7"
    Then I find "7" grade

  Scenario: Us - Check edit grades page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "grades" section
    And I search for "7"
    When I click on edit grade button
    Then Edit Grades staff page appear

  Scenario: Us - Check add grades page
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "grades" section
    And I search for "7"
    When I click on add grades button
    Then Add grades page appear

  Scenario: Us -  Check delete grade pop up
    Given I Login to ALEF With "ADMIN_USER_US" in environment "US"
    And I choose organization "North Carolina"
    And I search for "Polk County Middle School"
    And I select "Polk County Middle School"
    And I click on "grades" section
    And I search for "7"
    When I click on delete button in grades page
    Then Delete grade pop up message appear









