package com.stacks.bdd.selenium.page.alef;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;

import static com.stacks.bdd.selenium.locator.alef.SchoolsLocator.*;


public class SchoolsPage extends PageObject {

    public SchoolsPage(CustomWebDriver driver) {
        super(driver, SchoolsPage.class.getName());
    }

    public void chooseOrganization(String organization) {
        Waiter.waitExpectedConditionsVisibilityOf(driver,ORGANIZATION_DROP_DOWN.by(),5);
        driver.clickOn(ORGANIZATION_DROP_DOWN.by());
        Waiter.waitExpectedConditionsVisibilityOf(driver, ORGANIZATION_DROP_DOWN_OPTION.by(organization), 5);
        driver.clickOnAndVerify(ORGANIZATION_DROP_DOWN_OPTION.by(organization));
    }

    public void clickOnFirstSchool(){
        Waiter.waitExpectedConditionsVisibilityOf(driver,SCHOOLS_FIRST_ROW.by(),5);
        driver.clickOnAndVerify(SCHOOLS_FIRST_ROW.by());
    }

    public void clickOnSection(String section){
        Waiter.waitExpectedConditionsVisibilityOf(driver,CLASSES_SECTION.by(section),5);
        driver.clickOn(CLASSES_SECTION.by(section));
    }

    public void clickOnAddClassButton(){
        Waiter.waitExpectedConditionsVisibilityOf(driver,ADD_CLASS_BUTTON.by(),5);
        driver.clickOnAndVerify(ADD_CLASS_BUTTON.by());
    }

    public void clickOnClassMaterialDropDownMenu(){
        Waiter.waitExpectedConditionsVisibilityOf(driver,CLASS_MATERIAL_DROP_DOWN_MENU.by(),5);
        driver.scrollToElement(CLASS_MATERIAL_DROP_DOWN_MENU.by());
        driver.clickOn(CLASS_MATERIAL_DROP_DOWN_MENU);
    }

    public void searchClassMaterialDropDownMenu(String value){
        Waiter.waitExpectedConditionsVisibilityOf(driver,CLASS_MATERIAL_SEARCH_TEXT.by(),5);
        driver.sendKeysTo(value,CLASS_MATERIAL_SEARCH_TEXT.by());
    }

    public boolean findPathwayOption(){
        return Waiter.waitExpectedConditionsVisibilityOf(driver,PATHWAY_OPTION.by(),5);
    }
}


