package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import webDriver.WebDriverStart;
import static models.TestSuite.*;
import static models.TestCase.*;
import static models.TestPlan.*;

/**
 * Created by Tetiana on 17-Apr-15.
 */
public class TestPlanSpecificationPage extends WebDriverStart {

    // Locators
    private static final By settingsButton = By.xpath("//img[@title='Actions']");
    private static final By newTestSuiteButton = By.name("new_testsuite");
    private static final By workFrameButton = By.name("workframe");
    private static final By testSuiteNameField = By.id("name");
    private static final By createTestSuiteButton = By.xpath("//input[@name='add_testsuite_button']");
    private static final By newTestSuiteAssertText = By.xpath("//div[@class='user_feedback']/p[contains(text(),'Test Suite created')]");
    private static final By newTestSuiteFolderAssert = By.xpath("//span[contains(text(),'TS-Rozetka_Search_Tests')]");
    private static final By treeFrameButton = By.xpath("//frame[@name='treeframe']");
    private static final By createTestCaseButton = By.id("create_tc");
    private static final By testCaseNameField = By.id("testcase_name");
    private static final By textEditorPreconditionsIframe = By.xpath("//iframe[@title='Rich text editor, preconditions']");
    private static final By textField = By.xpath("//br[@type='_moz']");
    private static final By finalCreateTestCaseButton = By.id("do_create_button");
    private static final By createStepButton = By.name("create_step");
    private static final By textEditorStepsIframe = By.xpath("//iframe[@title='Rich text editor, steps']");
    private static final By textEditorResultsIframe = By.xpath("//iframe[@title='Rich text editor, expected_results']");
    private static final By saveTestCaseStepButton = By.id("do_update_step");
    private static final By saveTestCaseButton = By.id("do_update_step_and_exit");
    private static final By addToTestPlanButton = By.xpath("//form[@id='addToTestPlans']/input[@value='Add to Test Plans']");
    private static final By searchTestPlanField = By.xpath("//input[@type='search']");
    private static final By markCheckBox = By.xpath("//td[@class='clickable_icon sorting_1']/input");
    private static final By addButton = By.name("add2testplan");
    private static final By testPlanUsageText = By.xpath("//span[contains(text(),'Test Plan usage')] ");
    private static final By testPlanUsageAssert = By.xpath("//table[@class='simple sortable']/tbody/tr/td[contains(text(),'Rozetka_FR')] ");
    private static final By deleteTestCaseButton = By.name("delete_tc");
    private static final By yesDeleteTestCaseButton = By.id("do_delete");
    private static final By testSuiteFolder = By.xpath("//span[contains(text(),'TS-Rozetka_Search_Tests (0)')]");
    private static final By deleteTestSuiteButton = By.id("delete_testsuite");
    private static final By yesDeleteTestSuiteButton = By.name("delete_testsuite");
    private static final By resequenceStepsButton = By.id("resequence_steps");

    // Method for switching to WorkFrame
    public void switchToWorkFrame() {
        WebElement workFrame = myDriver.findElement(workFrameButton);
        myDriver.switchTo().frame(workFrame);
    }

    // Method for switching to TreeFrame
    public void switchToTreeFrame() {
        WebElement treeFrame = myDriver.findElement(treeFrameButton);
        myDriver.switchTo().frame(treeFrame);
    }

    // Method for switching to Text Editor Preconditions Frame
    public void switchToTextEditorPreconditionsFrame() {
        WebElement textEditorPreconditionsFrame = myDriver.findElement(textEditorPreconditionsIframe);
        myDriver.switchTo().frame(textEditorPreconditionsFrame);
    }

    // Method for switching to Text Editor Steps Frame
    public void switchToTextEditorStepsFrame() {
        WebElement textEditorStepsFrame = myDriver.findElement(textEditorStepsIframe);
        myDriver.switchTo().frame(textEditorStepsFrame);
    }

    // Method for switching to Text Editor Results Frame
    public void switchToTextEditorResultsFrame() {
        WebElement textEditorResultsFrame = myDriver.findElement(textEditorResultsIframe);
        myDriver.switchTo().frame(textEditorResultsFrame);
    }

    // Method for clicking Settings Button
    public void clickSettingsButton() {
        try {
            switchToWorkFrame();
        }
        catch (Exception ex) {
            System.out.println("Driver is in work frame");
        }
        myDriver.findElement(settingsButton).click();
    }

    // Method for clicking New Test Suite Button
    public void clickNewTestSuiteButton() {
        myDriver.findElement(newTestSuiteButton).click();
    }

    // Method for entering Test Suite Name
    public void enterTestSuiteName() {
        myDriver.findElement(testSuiteNameField).sendKeys(TEST_SUITE_NAME);
    }

    // Method for creating New Test Suite Button
    public void clickSaveTestSuiteButton() {
        myDriver.findElement(createTestSuiteButton).click();
    }

    // Method for verifying of new test suite creation
    public boolean isTestSuitePresent() {
        myDriver.findElement(newTestSuiteAssertText);
        myDriver.switchTo().parentFrame();
        switchToTreeFrame();
        myDriver.findElement(newTestSuiteFolderAssert);
        //myDriver.switchTo().parentFrame();
        return true;
    }

    // Method for clicking new test suite folder
    public void clickNewTestSuiteFolder() {
        myDriver.findElement(newTestSuiteFolderAssert).click();
        myDriver.switchTo().parentFrame();
    }

    // Method for clicking "add test case" button
    public void clickNewTestCaseButton() {
        myDriver.findElement(createTestCaseButton).click();
    }

    // Method for entering Test Case Name
    public void enterTestCaseName() {
        myDriver.findElement(testCaseNameField).sendKeys(TEST_CASE_NAME);
    }

    // Method for entering Test Case Preconditions
    public void enterTestCasePreconditions() {
        switchToTextEditorPreconditionsFrame();
        myDriver.findElement(textField).sendKeys(TEST_CASE_PRECONDITIONS);
        myDriver.switchTo().parentFrame();
    }

    // Method for clicking "add test case" button
    public void clickCreateButton() {
        myDriver.findElement(finalCreateTestCaseButton).click();
    }

    // Method for clicking "Create Test Step" button
    public void clickCreateTestStepButton() {
        myDriver.findElement(createStepButton).click();
    }

    // Method for entering Test Case Step 1
    public void enterTestCaseStep1() {
        switchToTextEditorStepsFrame();
        myDriver.findElement(textField).sendKeys(TC_STEP_1);
        myDriver.switchTo().parentFrame();
    }

    // Method for entering Test Case Expected Result 1
    public void enterTestCaseExpectedResult1() {
        switchToTextEditorResultsFrame();
        myDriver.findElement(textField).sendKeys(TC_EXPECTED_RESULT_1);
        myDriver.switchTo().parentFrame();
    }

    // Method for entering Test Case Step 2
    public void enterTestCaseStep2() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switchToTextEditorStepsFrame();
        myDriver.findElement(textField).sendKeys(TC_STEP_2);
        myDriver.switchTo().parentFrame();
    }

    // Method for entering Test Case Expected Result 2
    public void enterTestCaseExpectedResult2() {
        switchToTextEditorResultsFrame();
        myDriver.findElement(textField).sendKeys(TC_EXPECTED_RESULT_2);
        myDriver.switchTo().parentFrame();
    }

    // Method for entering Test Case Step 3
    public void enterTestCaseStep3() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switchToTextEditorStepsFrame();
        myDriver.findElement(textField).sendKeys(TC_STEP_3);
        myDriver.switchTo().parentFrame();
    }

    // Method for entering Test Case Expected Result 3
    public void enterTestCaseExpectedResult3() {
        switchToTextEditorResultsFrame();
        myDriver.findElement(textField).sendKeys(TC_EXPECTED_RESULT_3);
        myDriver.switchTo().parentFrame();
    }

    // Method for Test Step saving
    public void clickSaveTestStepButton() {
        myDriver.findElement(saveTestCaseStepButton).click();
    }

    // Method for Test Case saving
    public void clickSaveTestCaseButton() {
        myDriver.findElement(saveTestCaseButton).click();
    }

    // Method for adding Test Case to Test Plan
    public void clickAddToTestPlanButton() {
        myDriver.findElement(addToTestPlanButton).click();
    }

    // Method for searching Test Plan
    public void enterTestPlanNameInTheSearchField() {
        myDriver.findElement(searchTestPlanField).sendKeys(TEST_PLAN_NAME);
    }

    // Method for check box marking
    public void markCheckBoxMethod() {
        myDriver.findElement(markCheckBox).click();
    }

    // Method for final adding Test Suite to Test Plan
    public void addToTestPlan() {
        myDriver.findElement(addButton).click();
    }

    public boolean isTestCaseIsUsedInTestPlan() {
        myDriver.findElement(testPlanUsageText);
        myDriver.findElement(testPlanUsageAssert);
        return true;
    }

    // Method for deleting Test Case
    public void clickDeleteTestCaseButton() {
        myDriver.findElement(deleteTestCaseButton).click();
    }

    // Method for final deleting Test Case
    public void clickYesDeleteTestCaseButton() {
        myDriver.findElement(yesDeleteTestCaseButton).click();
    }

    // Method for final deleting Test Case
    public void clickTestSuiteFolder() {
        myDriver.switchTo().parentFrame();
        switchToTreeFrame();
        myDriver.findElement(testSuiteFolder).click();
        myDriver.switchTo().parentFrame();
    }

    // Method for final deleting Test Suite
    public void clickDeleteTestSuiteButton() {
        myDriver.findElement(deleteTestSuiteButton).click();
    }

    // Method for final deleting Test Suite
    public void clickYesDeleteTestSuiteButton() {
        myDriver.findElement(yesDeleteTestSuiteButton).click();
    }

    // Method for verifying of new test case creation
    public boolean isTestCasePresent() {
        myDriver.findElement(resequenceStepsButton);
        return true;
    }
}
