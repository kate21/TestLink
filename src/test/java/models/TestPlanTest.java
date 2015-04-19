package models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;
import webDriver.WebDriverStart;

/**
* Created by Tetiana on 08-Apr-15.
*/

public class TestPlanTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    TestPlanManagementPage testPlanManagementPage = new TestPlanManagementPage();
    TestPlanEditPage testPlanEditPage = new TestPlanEditPage();
    TestPlanSpecificationPage testPlanSpecificationPage = new TestPlanSpecificationPage();

    @BeforeTest
    public void login() {
        loginPage.webDriver();
        loginPage.openTestLinkPage();
        loginPage.enterUserName();
        loginPage.enterPassword();
        loginPage.clickLogInButton();
    }

    @Test
    public void positiveCreateTestPlanTest() {

        homePage.openTestPlanManagement();

        testPlanManagementPage.clickCreateTestPlanButton();

        testPlanEditPage.enterTestPlanName();
        testPlanEditPage.enterTestPlanDescription();
        testPlanEditPage.markActiveCheckBox();
        testPlanEditPage.markPublicCheckBox();
        testPlanEditPage.createTestPlan();

        Assert.assertTrue(testPlanManagementPage.isTestPlanPresent(), "ERROR_New Test Plan is not created");

        homePage.returnToHomePage();
        homePage.openTestSpecification();
        testPlanSpecificationPage.clickSettingsButton();
        testPlanSpecificationPage.clickNewTestSuiteButton();
        testPlanSpecificationPage.enterTestSuiteName();
        testPlanSpecificationPage.clickSaveTestSuiteButton();

        Assert.assertTrue(testPlanSpecificationPage.isTestSuitePresent(), "ERROR_New Test Suite is not created");

        testPlanSpecificationPage.clickNewTestSuiteFolder();
        testPlanSpecificationPage.clickSettingsButton();
        testPlanSpecificationPage.clickNewTestCaseButton();
        testPlanSpecificationPage.enterTestCaseName();
        testPlanSpecificationPage.enterTestCasePreconditions();
        testPlanSpecificationPage.clickCreateButton();
        testPlanSpecificationPage.clickCreateTestStepButton();
        testPlanSpecificationPage.enterTestCaseStep1();
        testPlanSpecificationPage.enterTestCaseExpectedResult1();
        testPlanSpecificationPage.clickSaveTestStepButton();
        testPlanSpecificationPage.enterTestCaseStep2();
        testPlanSpecificationPage.enterTestCaseExpectedResult2();
        testPlanSpecificationPage.clickSaveTestStepButton();
        testPlanSpecificationPage.enterTestCaseStep3();
        testPlanSpecificationPage.enterTestCaseExpectedResult3();
        testPlanSpecificationPage.clickSaveTestCaseButton();

        Assert.assertTrue(testPlanSpecificationPage.isTestCasePresent(), "ERROR_New Test Case is not created");

        testPlanSpecificationPage.clickSettingsButton();
        testPlanSpecificationPage.clickAddToTestPlanButton();
        testPlanSpecificationPage.enterTestPlanNameInTheSearchField();
        testPlanSpecificationPage.markCheckBoxMethod();
        testPlanSpecificationPage.addToTestPlan();

        Assert.assertTrue(testPlanSpecificationPage.isTestCaseIsUsedInTestPlan(), "ERROR_Test_Case_is_not_used_in_test_plan");
    }

    @AfterTest
    public void logOut() {
        testPlanSpecificationPage.clickSettingsButton();
        testPlanSpecificationPage.clickDeleteTestCaseButton();
        testPlanSpecificationPage.clickYesDeleteTestCaseButton();
        testPlanSpecificationPage.clickTestSuiteFolder();
        testPlanSpecificationPage.clickSettingsButton();
        testPlanSpecificationPage.clickDeleteTestSuiteButton();
        testPlanSpecificationPage.clickYesDeleteTestSuiteButton();
        homePage.returnToHomePage();
        homePage.openTestPlanManagement();
        testPlanManagementPage.deleteTestPlan();
        testPlanManagementPage.yesDeleteTestPlan();
        homePage.clickLogOut();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.quit();
    }
}