package com.stacks.bdd.selenium.page.alef;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;

import static com.stacks.bdd.selenium.locator.alef.ClassesLocator.*;


public class ClassesPage extends PageObject {

    public ClassesPage(CustomWebDriver driver) {
        super(driver, ClassesPage.class.getName());
    }


    public void clickOnAddClassButton() {
        Waiter.waitExpectedConditionsVisibilityOf(driver, ADD_CLASS_BUTTON.by(), 5);
        driver.clickOnAndVerify(ADD_CLASS_BUTTON.by());
    }

    public void clickOnClassMaterialDropDownMenu() {
        Waiter.waitExpectedConditionsVisibilityOf(driver, CLASS_MATERIAL_DROP_DOWN_MENU.by(), 5);
        driver.scrollToElement(CLASS_MATERIAL_DROP_DOWN_MENU.by());
        driver.clickOn(CLASS_MATERIAL_DROP_DOWN_MENU);
    }

    public void searchClassMaterialDropDownMenu(String value) {
        Waiter.waitExpectedConditionsVisibilityOf(driver, CLASS_MATERIAL_SEARCH_TEXT.by(), 5);
        driver.sendKeysTo(value, CLASS_MATERIAL_SEARCH_TEXT.by());
    }

    public boolean findPathwayOption() {
        return Waiter.waitExpectedConditionsVisibilityOf(driver, PATHWAY_OPTION.by(), 5);
    }

    public boolean editClassPageAppeared(){
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Edit class"), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Class Information"), 5);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Teacher"), 5);
        boolean condition4 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Class Material"), 5);
        boolean condition5 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Class Settings"), 5);
        return (condition1 && condition2 && condition3 && condition4 && condition5);
    }

    public boolean classPageAppeared(String value){
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by(value), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Class details"), 5);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Student enrollment"), 5);
        boolean condition4 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Class schedule"), 5);
        boolean condition5 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by(" Edit class"), 5);
        boolean condition6 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("+ Add Student"), 5);
        boolean condition7 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("+ Add Schedule"), 5);
        return (condition1 && condition2 && condition3 && condition4 && condition5 && condition6 && condition7);
    }

    public boolean addClassPageAppeared(){
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Add new class"), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Class Information"), 5);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Teacher"), 5);
        boolean condition4 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Class Material"), 5);
        boolean condition5 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Class Settings"), 5);
        boolean condition6 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Title"), 5);
        return (condition1 && condition2 && condition3 && condition4 && condition5 && condition6);
    }
}


