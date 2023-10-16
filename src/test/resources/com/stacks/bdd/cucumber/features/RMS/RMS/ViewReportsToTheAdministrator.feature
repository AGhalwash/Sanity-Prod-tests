
Feature: RMS - Check RMS privileges - View reports to the administrator


  Scenario: RMS - Check  View reports to the administrator privilege - Checkbox checked & correct administrator
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I check "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "عميل خارجي" radio button
    And I enter mandatory fields
    And I click on "موظف" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "أحمد جمال غلوش" branch
    And I click on save button
    And I click on save button
    When I click on "بلاغاتي" ticket status button
    Then I find the created ticket


  Scenario: RMS - Check  View reports to the administrator privilege - Checkbox unchecked & correct administrator
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "عميل خارجي" radio button
    And I enter mandatory fields
    And I click on "موظف" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "أحمد جمال غلوش" branch
    And I click on save button
    And I click on save button
    When I click on "بلاغاتي" ticket status button
    Then I don't find the created ticket


  Scenario: RMS - Check  View reports to the administrator privilege - Checkbox checked & different administrator
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I check "عرض البلاغات للمسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "عميل خارجي" radio button
    And I enter mandatory fields
    And I click on "موظف" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "عهود مبارك الحربي" branch
    And I click on save button
    And I click on save button
    When I click on "بلاغاتي" ticket status button
    Then I don't find the created ticket


  Scenario: RMS - Check  Present reports to a department official privilege - Checkbox checked & correct department
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I check "عرض البلاغات لمسؤول بالقسم" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "عميل خارجي" radio button
    And I enter mandatory fields
    And I click on "موظف" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "نوره جريد الزنيدي" branch
    And I click on save button
    And I click on save button
    When I click on "بلاغاتي" ticket status button
    Then I find the created ticket


  Scenario: RMS - Check  Present reports to a department official privilege - Checkbox unchecked & correct department
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I uncheck "عرض البلاغات لمسؤول بالقسم" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "عميل خارجي" radio button
    And I enter mandatory fields
    And I click on "موظف" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "نوره جريد الزنيدي" branch
    And I click on save button
    And I click on save button
    When I click on "بلاغاتي" ticket status button
    Then I don't find the created ticket


  Scenario: RMS - Check  Present reports to a department official privilege - Checkbox checked & different department
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I check "عرض البلاغات لمسؤول بالقسم" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "عميل خارجي" radio button
    And I enter mandatory fields
    And I click on "موظف" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "ندى عبدالله العقيل" branch
    And I click on save button
    And I click on save button
    When I click on "بلاغاتي" ticket status button
    Then I don't find the created ticket


  Scenario: RMS - Check  Present reports to a branch official privilege - Checkbox checked & correct branch
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I check "عرض البلاغات لمسؤول بالفرع" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "عميل خارجي" radio button
    And I enter mandatory fields
    And I click on "موظف" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "ندى عبدالله العقيل" branch
    And I click on save button
    And I click on save button
    When I click on "بلاغاتي" ticket status button
    Then I find the created ticket


  Scenario: RMS - Check  Present reports to a branch official privilege - Checkbox unchecked & correct branch
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I uncheck "عرض البلاغات لمسؤول بالفرع" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "عميل خارجي" radio button
    And I enter mandatory fields
    And I click on "موظف" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "ندى عبدالله العقيل" branch
    And I click on save button
    And I click on save button
    When I click on "بلاغاتي" ticket status button
    Then I don't find the created ticket


  Scenario: RMS - Check  Present reports to a branch official privilege - Checkbox checked & different branch
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I check "عرض البلاغات لمسؤول بالفرع" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "عميل خارجي" radio button
    And I enter mandatory fields
    And I click on "موظف" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "سكن النعيرية" branch
    And I open "الموظف" list in ticket source section
    And I choose "عهود مبارك الحربي" branch
    And I click on save button
    And I click on save button
    When I click on "بلاغاتي" ticket status button
    Then I don't find the created ticket


  Scenario: RMS - Check  View reports to the responsible department privilege - Checkbox checked & correct department
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I check "عرض البلاغات للقسم المسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
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
    When I click on "بلاغاتي" ticket status button
    Then I find the created ticket


  Scenario: RMS - Check  View reports to the responsible department privilege - Checkbox unchecked & correct department
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I uncheck "عرض البلاغات للقسم المسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
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
    When I click on "بلاغاتي" ticket status button
    Then I don't find the created ticket


  Scenario: RMS - Check  View reports to the responsible department privilege - Checkbox checked & different department
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I check "عرض البلاغات للقسم المسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
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
    When I click on "بلاغاتي" ticket status button
    Then I don't find the created ticket


  Scenario: RMS - Check  View reports from the responsible branch privilege - Checkbox checked & correct branch
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I check "عرض البلاغات للفرع المسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
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
    When I click on "بلاغاتي" ticket status button
    Then I find the created ticket

  Scenario: RMS - Check  View reports from the responsible branch privilege - Checkbox unchecked & correct branch
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I check "عرض البلاغات للفرع المسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
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
    When I click on "بلاغاتي" ticket status button
    Then I don't find the created ticket


  Scenario: RMS - Check View reports from the responsible branch privilege - Checkbox checked & different branch
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I check "عرض البلاغات للفرع المسؤول" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
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
    And I choose "الطائف" branch
    And I click on save button
    And I click on save button
    When I click on "بلاغاتي" ticket status button
    Then I don't find the created ticket


  Scenario: RMS - Check View reports to all officials privilege - branch - Checkbox checked & different branch
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I check "عرض البلاغات لكل المسؤولين" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
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
    And I choose "الطائف" branch
    And I click on save button
    And I click on save button
    When I click on "بلاغاتي" ticket status button
    Then I find the created ticket


  Scenario: RMS - Check View reports to all officials privilege - department - Checkbox checked & different department
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I check "عرض البلاغات لكل المسؤولين" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
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
    When I click on "بلاغاتي" ticket status button
    Then I find the created ticket


  Scenario: RMS - Check View reports to all officials privilege - reports to a branch official - Checkbox unchecked & correct branch
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I uncheck "عرض البلاغات لمسؤول بالفرع" power checkbox
    And I check "عرض البلاغات لكل المسؤولين" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "عميل خارجي" radio button
    And I enter mandatory fields
    And I click on "موظف" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "ندى عبدالله العقيل" branch
    And I click on save button
    And I click on save button
    When I click on "بلاغاتي" ticket status button
    Then I find the created ticket


  Scenario: RMS -  Check View reports to all officials privileg - View reports to the administrator - Checkbox unchecked & correct administrator
    Given I Login to RMS With "Admin"
    And I change language to Arabic
    And I open Authorization View Page page
    And I edit role with name "اوتوميشن أحمد"
    And I open "البلاغات" power arrow button
    And I open "عرض البلاغات" power arrow button
    And I open "عرض البلاغات للمسؤول" power arrow button
    And I uncheck "عرض البلاغات للمسؤول" power checkbox
    And I check "عرض البلاغات لكل المسؤولين" power checkbox
    And I uncheck "عرض البلاغات لمُنشئ التذكرة" power checkbox
    And I click on save button
    And I log out from RMS
    And I Login to RMS With "Normal user"
    And I change language to Arabic
    And I change language to Arabic
    And I open View reports page
    And I open add ticket to call center page
    And I click on "عميل خارجي" radio button
    And I enter mandatory fields
    And I click on "موظف" radio button in appointment of official section
    And I open "الفرع" list in ticket source section
    And I choose "الرس" branch
    And I open "الموظف" list in ticket source section
    And I choose "أحمد جمال غلوش" branch
    And I click on save button
    And I click on save button
    When I click on "بلاغاتي" ticket status button
    Then I find the created ticket