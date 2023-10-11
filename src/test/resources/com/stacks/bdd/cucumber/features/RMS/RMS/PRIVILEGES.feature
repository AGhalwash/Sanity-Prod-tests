
Feature: RMS - Check RMS privileges


  Scenario: RMS - Check call center added privileges
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I check "إضافة تذكرة بلاغ" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I refresh page
    And I open View reports page
    And I open add ticket to call center page
    When I click on "ولي أمر" radio button
    Then I find "طلب" & "اقتراح" & "استفسار" & "شكوى شخصية" radio buttons
    And I don't find "شكوة عمل" radio button
    And I click on "عميل خارجي" radio button
    And I find "طلب" & "اقتراح" & "استفسار" & "شكوى شخصية" radio buttons
    And I don't find "شكوة عمل" radio button
    And I click on "موظف" radio button
    And I find "طلب" & "اقتراح" & "استفسار" & "شكوى شخصية" radio buttons
    And I do find "شكوة عمل" radio button


  Scenario: RMS - Check call center removed privileges
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I uncheck "إضافة تذكرة بلاغ" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I refresh page
    When I open View reports page
    Then I don't find add ticket button


  Scenario: RMS - Check call center Branch privileges
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "إضافة تذكرة بلاغ" power arrow button
    And I open " إضافة تذكرة (إستفسار)" power arrow button
    And I open "اضف تذكرة - موظف - استفسار" power arrow button
    And I check "إضافة تذكرة الكل" power checkbox
    And I close "اضف تذكرة - موظف - استفسار" power arrow button
    And I open "اضف تذكرة - ولى امر- استفسار" power arrow button
    And I check "بلاغ المسؤل (الفرع)" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "ولي أمر" radio button
    When I open "الفرع" list in ticket source section
    Then I find "الرس" branch name
    And I don't find all branches
    And I click on "موظف" radio button
    And I open "الفرع" list in ticket source section
    And I do find all branches



  Scenario: RMS - Check  View reports to the responsible department privilege - Checkbox checked & correct department
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I check "عرض البلاغات للقسم المسؤول" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "عميل خارجي" radio button
    And I enter mandatory fields
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I click on save button
    And I click on save button
    When I click on "حالاتي" ticket status button
    Then I find the created ticket

  Scenario: RMS - Check  View reports to the responsible department privilege - Checkbox unchecked & correct department
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I uncheck "عرض البلاغات للقسم المسؤول" power checkbox
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
    #When I click on "حالاتي" ticket status button
    Then I don't find the created ticket

  Scenario: RMS - Check  View reports to the responsible department privilege - Checkbox checked & different department
   # Given I Login to RMS With "Admin"
   # And I change language to Arabic
   # And I open Authorization View Page page
   # And I edit role with name "اوتوميشن أحمد"
   # And I open "البلاغات" power arrow button
   # And I open "عرض البلاغات" power arrow button
   # And I open "عرض البلاغات للمسؤول" power arrow button
   # And I check "عرض البلاغات للقسم المسؤول" power checkbox
   # And I click on save button
   # And I log out from RMS
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
    #When I click on "حالاتي" ticket status button
    Then I don't find the created ticket



  Scenario: RMS - Check  View reports to the creator privilege - Checkbox checked & different department
    #Given I Login to RMS With "Admin"
    #And I change language to Arabic
    #And I open Authorization View Page page
    ##And I edit role with name "اوتوميشن أحمد"
    #And I open "البلاغات" power arrow button
    #And I open "عرض البلاغات" power arrow button
    #And I open "عرض البلاغات للمسؤول" power arrow button
    #And I uncheck "عرض البلاغات للمسؤول" power checkbox
    #And I uncheck "عرض البلاغات لكل المسؤولين" power checkbox
    #And I check "عرض البلاغات للقسم المسؤول" power checkbox
    #And I click on save button
    #And I log out from RMS
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
    When I click on "حالاتي" ticket status button
    Then I find the created ticket





  Scenario: RMS - sdsdsd
    Given I Login to RMS With "<Username>"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "<Reports>" power arrow button
    And I check "إضافة تذكرة بلاغ" power checkbox
