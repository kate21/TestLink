package pages;

import org.openqa.selenium.By;
import webDriver.WebDriverStart;

/**
 * Created by Tetiana on 08-Apr-15.
 */
public class TestPlanManagementPage extends WebDriverStart {

    // Locators
    private static final By createTestPlanButton = By.name("create_testplan");
    private static final By newTestPlanItem = By.xpath("//table[@id='item_view']/tbody/tr/td/a[contains(text(),'Rozetka_FR')]");
    private static final By deleteTestPlanButton = By.xpath("//table[@id='item_view']/tbody/tr/td/img[contains(@onclick,'Rozetka_FR')]");
    private static final By yesDeleteTestPlanButton = By.id("ext-gen20");

    // Method for initial test-plan creation
    public void clickCreateTestPlanButton() {
        myDriver.findElement(createTestPlanButton).click();
    }

    // Method for verifying the presence of test-plan in test-plan list
    public boolean isTestPlanPresent() {
        myDriver.findElement(newTestPlanItem);
        return true;
    }

    // Method for initial test-plan deletion
    public void deleteTestPlan() {
        myDriver.findElement(deleteTestPlanButton).click();
    }

    // Method for final test-plan deletion
    public void yesDeleteTestPlan() {
        myDriver.findElement(yesDeleteTestPlanButton).click();
        myDriver.switchTo().defaultContent();
    }
}
