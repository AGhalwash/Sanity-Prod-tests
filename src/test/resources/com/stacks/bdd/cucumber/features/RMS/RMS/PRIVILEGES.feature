
Feature: RMS - Check RMS privileges


  Scenario: RMS - Check call center privileges
    Given I Login to RMS With "Normal user"
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    When I click on "عميل خارجي" radio button
