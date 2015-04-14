package pages;

import static models.TestPlan.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.WebDriverStart;

/**
 * Created by Tetiana on 08-Apr-15.
 */
public class TestPlanEditPage extends WebDriverStart {

    // Locators
    private static final By testPlanNameField = By.name("testplan_name");
    private static final By testPlanNDescriptionField = By.xpath("//br[@type='_moz']");
    private static final By testPlanNDescriptionFrame = By.xpath("//iframe[@title='Rich text editor, notes']");
    private static final By activeCheckBox = By.name("active");
    private static final By publicCheckBox = By.name("is_public");
    private static final By createButton = By.name("do_create");

    // Method for entering test-plan name
    public void enterTestPlanName() {
        myDriver.findElement(testPlanNameField).sendKeys(name);
    }

    // Method for entering test-plan description
    public void enterTestPlanDescription() {
        WebElement descriptionFrame = myDriver.findElement(testPlanNDescriptionFrame);
        myDriver.switchTo().frame(descriptionFrame);
        myDriver.findElement(testPlanNDescriptionField).sendKeys(description);
        myDriver.switchTo().parentFrame();
    }

    // Method for marking "Active" CheckBox
    public void markActiveCheckBox() {
        myDriver.findElement(activeCheckBox).click();
    }

    // Method for marking "Public" CheckBox
    public void markPublicCheckBox() {
        myDriver.findElement(publicCheckBox).click();
    }

    // Method for final test-plan creation
    public void createTestPlan() {
        myDriver.findElement(createButton).click();
    }
}
