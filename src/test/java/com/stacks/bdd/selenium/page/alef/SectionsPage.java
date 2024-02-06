package com.stacks.bdd.selenium.page.alef;

import com.stacks.bdd.selenium.driver.core.CustomWebDriver;
import com.stacks.bdd.selenium.driver.core.PageObject;
import com.stacks.bdd.selenium.driver.core.Waiter;

import static com.stacks.bdd.selenium.locator.alef.ClassesLocator.HEAD_TITLE_TEXT;
import static com.stacks.bdd.selenium.locator.alef.GradesLocator.DELETE_BUTTON;
import static com.stacks.bdd.selenium.locator.alef.SchoolsLocator.FIRST_DISABLED_ROW_BY_NAME;
import static com.stacks.bdd.selenium.locator.alef.SectionsLocator.*;


public class SectionsPage extends PageObject {

    public SectionsPage(CustomWebDriver driver) {
        super(driver, SectionsPage.class.getName());
    }


    public boolean editSectionPageAppeared() {
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Edit section information"), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Section Name"), 5);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Select Grade"), 5);
        boolean condition4 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Section"), 5);
        boolean condition5 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Source Id"), 5);
        return (condition1 && condition2 && condition3 && condition4 && condition5);
    }

    public boolean addSectionPageAppeared() {
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Add section information"), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Section Name"), 5);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Select Grade"), 5);
        boolean condition4 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Section"), 5);
        boolean condition5 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Source Id"), 5);
        return (condition1 && condition2 && condition3 && condition4 && condition5);
    }

    public boolean generateSectionsPageAppeared() {
        boolean condition1 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Generate Sections"), 5);
        boolean condition2 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Number of Sections (Max 25)"), 5);
        boolean condition3 = Waiter.waitExpectedConditionsVisibilityOf(driver, HEAD_TITLE_TEXT.by("Naming Convention"), 5);
        return (condition1 && condition2 && condition3);
    }

    public boolean deleteSectionPopupAppear() {
        return Waiter.waitExpectedConditionsVisibilityOf(driver, DELETE_SECTION_POP_UP_MESSAGE.by(), 5);
    }

    public void clickOnAddSectionButton() {
        Waiter.waitExpectedConditionsVisibilityOf(driver, ADD_SECTION_BUTTON.by(), 5);
        driver.clickOnAndVerify(ADD_SECTION_BUTTON.by());
    }

    public boolean checkSectionIsDisabled(String value) {
        return Waiter.waitExpectedConditionsVisibilityOf(driver, FIRST_DISABLED_ROW_BY_NAME.by(value), 5);
    }

    public void clickOnDisableSectionButton() {
        if (Waiter.waitExpectedConditionsVisibilityOf(driver, ENABLE_SECTION_BUTTON.by(), 5)) {
            driver.clickOnAndVerify(ENABLE_SECTION_BUTTON.by());
        }
        driver.clickOnAndVerify(DISABLE_SECTION_BUTTON.by(), ENABLE_SECTION_BUTTON.by());
    }

    public void clickOnEnableSectionButton() {
        if (Waiter.waitExpectedConditionsVisibilityOf(driver, DISABLE_SECTION_BUTTON.by(), 5)) {
            driver.clickOnAndVerify(DISABLE_SECTION_BUTTON.by());
        }
        driver.clickOnAndVerify(ENABLE_SECTION_BUTTON.by(), DISABLE_SECTION_BUTTON.by());
    }

    public void clickOnGenerateSectionsButton(){
        Waiter.waitExpectedConditionsVisibilityOf(driver, GENERATE_SECTIONS_BUTTON.by(), 5);
        driver.clickOnAndVerify(GENERATE_SECTIONS_BUTTON.by());
    }

    public void clickOnDeleteSectionButton() {
        Waiter.waitExpectedConditionsVisibilityOf(driver, DELETE_SECTION_BUTTON.by(), 5);
        driver.clickOnAndVerify(DELETE_SECTION_BUTTON.by(),DELETE_SECTION_POP_UP_MESSAGE.by());
    }
}


