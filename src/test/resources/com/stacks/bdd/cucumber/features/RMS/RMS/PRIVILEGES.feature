
Feature: RMS - Check RMS privileges


  Scenario: RMS - Check call center added privileges
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I refresh page
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن"
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
    And I refresh page
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن"
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
    And I refresh page
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن"
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
    And I refresh page
    And I open View reports page
    And I open add ticket to call center page
    And I click on "ولي أمر" radio button
    When I open "الفرع" list
    Then I find "الرس" branch name
    And I don't find all branches
    And I click on "موظف" radio button
    And I open "الفرع" list
    And I do find all branches




