package models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.TestPlanEditPage;
import pages.TestPlanManagementPage;
import webDriver.WebDriverStart;

/**
* Created by Tetiana on 08-Apr-15.
*/

public class TestPlanTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    TestPlanManagementPage testPlanManagementPage = new TestPlanManagementPage();
    TestPlanEditPage testPlanEditPage = new TestPlanEditPage();

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

        Assert.assertTrue(testPlanManagementPage.isTestPlanPresent());

        testPlanManagementPage.deleteTestPlan();
        testPlanManagementPage.yesDeleteTestPlan();
    }

    @AfterTest
    public void logOut() {
        homePage.clickLogOut();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.quit();
    }
}