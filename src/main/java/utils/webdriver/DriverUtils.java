package utils.webdriver;

import org.openqa.selenium.WebDriver;

public class DriverUtils {

    public static WebDriver getDriver() {
        return WebDriverCreator.getWebDriverCreator().getWebDriver();
    }
}
