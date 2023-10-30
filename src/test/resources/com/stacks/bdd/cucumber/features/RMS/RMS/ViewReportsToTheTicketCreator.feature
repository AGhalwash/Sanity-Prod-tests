
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


  Scenario: RMS - Check View reports to report creators in the department - Checkbox checked & correct department
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I check "عرض البلاغات لمُنشئي البلاغات بالقسم" power checkbox
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
    And I click on "إدارة" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الإدارة" list in ticket source section
    And I choose "الإدارة العامة للفرع" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I find the created ticket


  Scenario: RMS - Check View reports to report creators in the department - Checkbox unchecked & correct department
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I uncheck "عرض البلاغات لمُنشئي البلاغات بالقسم" power checkbox
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
    And I click on "إدارة" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الإدارة" list in ticket source section
    And I choose "الإدارة العامة للفرع" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I don't find the created ticket


  Scenario: RMS - Check View reports to report creators in the department - Checkbox checked & different department
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I check "عرض البلاغات لمُنشئي البلاغات بالقسم" power checkbox
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
    And I click on "إدارة" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الإدارة" list in ticket source section
    And I choose "قسم منطلق" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I don't find the created ticket


  Scenario: RMS - Check View reports to the branch’s report creators - Checkbox checked & correct branch
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I check "عرض البلاغات لمُنشئى البلاغات بالفرع" power checkbox
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


  Scenario: RMS - Check View reports to the branch’s report creators - Checkbox unchecked & correct branch
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I uncheck "عرض البلاغات لمُنشئى البلاغات بالفرع" power checkbox
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
    Then I don't find the created ticket


  Scenario: RMS - Check View reports to the branch’s report creators - Checkbox checked & different branch
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I check "عرض البلاغات لمُنشئى البلاغات بالفرع" power checkbox
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
    And I choose "الطائف" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I don't find the created ticket


  Scenario: RMS - View reports for all report creators - Checkbox checked & correct creator
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I check "عرض البلاغات لكل مُنشئي البلاغات" power checkbox
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


  Scenario: RMS - View reports for all report creators - Checkbox checked & correct department
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I check "عرض البلاغات لكل مُنشئي البلاغات" power checkbox
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
    And I click on "إدارة" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الإدارة" list in ticket source section
    And I choose "الإدارة العامة للفرع" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I find the created ticket


  Scenario: RMS - View reports for all report creators - Checkbox checked & correct branch
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I check "عرض البلاغات لكل مُنشئي البلاغات" power checkbox
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
    Then I don't find the created ticket



  Scenario: RMS - View reports for all report creators - Checkbox unchecked & correct creator
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I uncheck "عرض البلاغات لكل مُنشئي البلاغات" power checkbox
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
    Then I don't find the created ticket


  Scenario: RMS - View reports for all report creators - Checkbox unchecked & correct department
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I uncheck "عرض البلاغات لكل مُنشئي البلاغات" power checkbox
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
    And I click on "إدارة" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الإدارة" list in ticket source section
    And I choose "الإدارة العامة للفرع" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I don't find the created ticket


  Scenario: RMS - View reports for all report creators - Checkbox unchecked & correct branch
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I uncheck "عرض البلاغات لكل مُنشئي البلاغات" power checkbox
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
    Then I don't find the created ticket
