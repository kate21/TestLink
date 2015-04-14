package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webDriver.WebDriverStart;

/**
 * Created by Tetiana on 08-Apr-15.
 */
public class HomePage extends WebDriverStart{

    // Locators
    private static final By testPlanManagementButton = By.xpath("//div[@id='test_plan_mgmt_topics']/a[contains(text(),'Test Plan Management')]");
    private static final By logOutButton = By.xpath("//div[@class='menu_title']/span/a/img[@title='Logout']");
    private static final By mainFrameName = By.name("mainframe");
    private static final By titleBarFrame = By.name("titlebar");

    // Method for opening "Test Plan Management" page
    public void openTestPlanManagement() {
        WebElement mainFrame = myDriver.findElement(mainFrameName);
        myDriver.switchTo().frame(mainFrame);
        myDriver.findElement(testPlanManagementButton).click();
    }

    // Method for "Log out" execution
    public void clickLogOut() {
        WebElement titleBar = myDriver.findElement(titleBarFrame);
        myDriver.switchTo().frame(titleBar);
        myDriver.findElement(logOutButton).click();
    }
}
