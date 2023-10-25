
Feature: RMS - Check RMS privileges - View notifications for the ticket type


  Scenario: RMS - View reports for the ticket type: Complaint - Checkbox checked & correct ticket type
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I uncheck "عرض البلاغات لنوع التذكرة" power checkbox
    And I check "عرض البلاغات لنوع التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "موظف" radio button
    And I click on "شكوى عمل" radio button
    And I enter mandatory fields without client name
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "أحمد جمال غلوش" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I find the created ticket

  Scenario: RMS - View reports for the ticket type: Complaint - Checkbox unchecked & correct ticket type
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I uncheck "عرض البلاغات لنوع التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "موظف" radio button
    And I click on "شكوى عمل" radio button
    And I enter mandatory fields without client name
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "أحمد جمال غلوش" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I don't find the created ticket

  Scenario: RMS - View reports for the ticket type: Complaint - Checkbox checked & wrong ticket type
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I uncheck "عرض البلاغات لنوع التذكرة" power checkbox
    And I check "عرض البلاغات لنوع التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "موظف" radio button
    And I click on "شكوى عمل" radio button
    And I enter mandatory fields without client name
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "أحمد جمال غلوش" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I find the created ticket


  Scenario: RMS - View reports for the ticket type: problem - Checkbox checked & correct ticket type
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I open "عرض البلاغات لنوع التذكرة" power arrow button
    And I uncheck "عرض البلاغات لنوع التذكرة" power checkbox
    And I check "عرض البلاغات لنوع التذكرة مشكلة" power checkbox
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

  Scenario: RMS - View reports for the ticket type: problem - Checkbox unchecked & correct ticket type
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I open "عرض البلاغات لنوع التذكرة" power arrow button
    And I uncheck "عرض البلاغات لنوع التذكرة" power checkbox
    And I uncheck "عرض البلاغات لنوع التذكرة مشكلة" power checkbox
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

  Scenario: RMS - View reports for the ticket type: problem - Checkbox checked & wrong ticket type
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I open "عرض البلاغات لنوع التذكرة" power arrow button
    And I uncheck "عرض البلاغات لنوع التذكرة" power checkbox
    And I check "عرض البلاغات لنوع التذكرة مشكلة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "موظف" radio button
    And I click on "شكوى عمل" radio button
    And I enter mandatory fields without client name
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "أحمد جمال غلوش" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I don't find the created ticket



    ######################################

  Scenario: RMS - View reports for other ticket types - inquiry - Checkbox checked & correct ticket type
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I uncheck "عرض البلاغات لنوع التذكرة" power checkbox
    And I check "عرض البلاغات لنوع التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "موظف" radio button
    And I click on "استفسار" radio button
    And I enter mandatory fields without client name
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "أحمد جمال غلوش" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I find the created ticket

  Scenario: RMS - View reports for other ticket types - inquiry - Checkbox checked & correct ticket type
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I uncheck "عرض البلاغات لنوع التذكرة" power checkbox
    And I check "عرض البلاغات لنوع التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "موظف" radio button
    And I click on "استفسار" radio button
    And I enter mandatory fields without client name
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "أحمد جمال غلوش" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I find the created ticket

  Scenario: RMS - View reports for other ticket types - suggestion - Checkbox checked & correct ticket type
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I uncheck "عرض البلاغات لنوع التذكرة" power checkbox
    And I check "عرض البلاغات لنوع التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "موظف" radio button
    And I click on "اقتراح" radio button
    And I enter mandatory fields without client name
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "أحمد جمال غلوش" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I find the created ticket

  Scenario: RMS - View reports for other ticket types - request - Checkbox checked & correct ticket type
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I uncheck "عرض البلاغات لنوع التذكرة" power checkbox
    And I check "عرض البلاغات لنوع التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "موظف" radio button
    And I click on "طلب" radio button
    And I enter mandatory fields without client name
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "أحمد جمال غلوش" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I find the created ticket

  Scenario: RMS - View reports for other ticket types - request - Checkbox unchecked & correct ticket type
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I uncheck "عرض البلاغات لنوع التذكرة" power checkbox
    And I uncheck "عرض البلاغات لنوع التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "موظف" radio button
    And I click on "طلب" radio button
    And I enter mandatory fields without client name
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "أحمد جمال غلوش" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I don't find the created ticket

  Scenario: RMS - View reports for other ticket types - request - Checkbox checked & wrong ticket type
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I uncheck "عرض البلاغات لنوع التذكرة" power checkbox
    And I check "عرض البلاغات لنوع التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "موظف" radio button
    And I click on "شكوى عمل" radio button
    And I enter mandatory fields without client name
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "أحمد جمال غلوش" branch
    And I click on save button
    And I click on save button
    When I click on sort by ticket number
    Then I don't find the created ticket