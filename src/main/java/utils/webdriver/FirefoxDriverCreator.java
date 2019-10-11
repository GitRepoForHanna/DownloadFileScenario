package utils.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import utils.Properties;

import java.util.ResourceBundle;

public class FirefoxDriverCreator {

    public static final String PATH_TO_FIREFOXDRIVER = "C:\\webdriver\\geckodriver.exe";

    public WebDriver create() {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", true);
        System.setProperty("webdriver.gecko.driver", PATH_TO_FIREFOXDRIVER);
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference(FirefoxPreferences.SHOW_WHEN_STARTING.getPreferenceName(), false);
        profile.setPreference(FirefoxPreferences.SHOW_ALERT_ON_COMPLETE.getPreferenceName(), false);
        profile.setPreference(FirefoxPreferences.SAVE_TO_DISK.getPreferenceName(), "application/octet-stream;application/zip");
        profile.setPreference(FirefoxPreferences.FOLDER_LIST.getPreferenceName(), 2);
        profile.setPreference(FirefoxPreferences.DOWNLOAD_DIR.getPreferenceName(),
                                ResourceBundle.getBundle("configuration").getString(Properties.DOWNLOAD_DIR.getPropertyName()));
        profile.setPreference(FirefoxPreferences.USE_DOWNLOAD_DIR.getPreferenceName(), true);
        options.setCapability("firefox_profile", profile);
        return new FirefoxDriver(options);
    }
}
