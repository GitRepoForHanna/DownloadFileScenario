package utils.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Properties;

import java.util.HashMap;
import java.util.ResourceBundle;

public class ChromeDriverCreator {

    public WebDriver create() {
        String downloadDirPath = ResourceBundle.getBundle("configuration").getString(Properties.DOWNLOAD_DIR.getPropertyName());
        String pathToDriver = ResourceBundle.getBundle("configuration").getString(Properties.PATH_TO_CHROME_DRIVER.getPropertyName());
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", downloadDirPath);
        chromePrefs.put("safebrowsing.enabled", true);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.setExperimentalOption("prefs", chromePrefs);
        return new ChromeDriver(options);
    }
}
