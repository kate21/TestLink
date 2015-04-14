package pages;

import static models.User.*;
import webDriver.WebDriverStart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Tetiana on 08-Apr-15.
 */

public class LoginPage extends WebDriverStart {

    // Locators
    private static final By loginField = By.id("login");
    private static final By passwordField = By.name("tl_password");
    private static final By loginButton = By.name("login_submit");

    // Method for entering username on "Log In" page
    public void enterUserName() {
    myDriver.findElement(loginField).sendKeys(NAME);
    }

    // Method for entering user password on "Log In" page
    public void enterPassword () {
        myDriver.findElement(passwordField).sendKeys(PASSWORD);
    }

    // Method for clicking "Log In" button
    public void clickLogInButton () {
        myDriver.findElement(loginButton).click();
    }
}
