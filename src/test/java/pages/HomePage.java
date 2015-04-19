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
    private static final By testSpecificationButton = By.xpath("//div[@id='testspecification_topics']/a[contains(text(),'Test Specification')]");
    private static final By logoButton = By.xpath("//img[@title='logo']");

    // Method for switching to TitleBar frame
    public void switchToTitleBarFrame() {
        WebElement titleBar = myDriver.findElement(titleBarFrame);
        myDriver.switchTo().frame(titleBar);
    }

    // Method for switching to Main frame
    public void switchToMainFrame() {
        WebElement mainFrame = myDriver.findElement(mainFrameName);
        myDriver.switchTo().frame(mainFrame);
    }


    // Method for opening "Test Plan Management" page
    public void openTestPlanManagement() {
        switchToMainFrame();
        myDriver.findElement(testPlanManagementButton).click();
    }

    // Method for "Log out" execution
    public void clickLogOut() {
        switchToTitleBarFrame();
        myDriver.findElement(logOutButton).click();
    }

    // Method for opening "Test Specification" page
    public void openTestSpecification() {
        switchToMainFrame();
        myDriver.findElement(testSpecificationButton).click();
    }

    // Method for returning to HomePage
    public void returnToHomePage() {
        myDriver.switchTo().defaultContent();
        switchToTitleBarFrame();
        myDriver.findElement(logoButton).click();
    }
}
