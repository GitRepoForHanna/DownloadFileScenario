package utils.webdriver;

import org.openqa.selenium.WebDriver;

public class WebDriverCreator {

    private static final String BROWSER_PROPERTY = "browser";
    private WebDriver webDriver;
    private static WebDriverCreator instance;

    private WebDriverCreator() {

    }

    private void initWebDriver() {
        String browser = System.getProperty(BROWSER_PROPERTY);
        if(null == webDriver) {
            switch (browser) {
                case "chrome": {
                    webDriver = new ChromeDriverCreator().create();
                    break;
                }
                case "firefox": {
                    webDriver = new FirefoxDriverCreator().create();
                    break;
                }
                default: {
                    throw new RuntimeException("Unknown browser type is selected");
                }
            }
            webDriver.manage().window().maximize();
        }
    }

    public static WebDriverCreator getWebDriverCreator() {
        if (null == instance) {
            instance = new WebDriverCreator();
        }
        return instance;
    }

    public WebDriver getWebDriver() {
        if(null == webDriver) {
            initWebDriver();
        }
        return webDriver;
    }
}
