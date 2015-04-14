package webDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

/**
 * Created by Tetiana on 09-Apr-15.
 */
public class WebDriverStart {

    public static WebDriver myDriver;
    private static final String URL = "http://demo.testlink.org/latest/login.php";

    public void webDriver() {
        myDriver = new FirefoxDriver();
        myDriver.manage().window().maximize();
        myDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void openTestLinkPage() {
        myDriver.get(URL);
    }

    public void quit() {
        myDriver.quit();
    }
}
