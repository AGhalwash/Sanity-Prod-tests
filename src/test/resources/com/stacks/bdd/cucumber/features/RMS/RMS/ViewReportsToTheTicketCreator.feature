
Feature: RMS - Check RMS privileges - View reports to the ticket creator

  Scenario: RMS - Check View reports to the ticket creator - Checkbox checked & correct creator
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I check "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I open "عرض البلاغات لنوع التذكرة" power arrow button
    And I check "عرض البلاغات لكل انواع التذاكر" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "عميل خارجي" radio button
    And I enter mandatory fields
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I find the created ticket

  Scenario: RMS - Check View reports to the ticket creator - Checkbox unchecked & correct creator
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I open "عرض البلاغات لنوع التذكرة" power arrow button
    And I check "عرض البلاغات لكل انواع التذاكر" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "عميل خارجي" radio button
    And I enter mandatory fields
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I don't find add ticket button
