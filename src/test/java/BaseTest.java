import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.ContexturesPageSteps;
import steps.DownloadFilePageSteps;
import steps.steam.SteamAboutPageSteps;
import steps.steam.SteamPageSteps;
import utils.webdriver.WebDriverCreator;

public class BaseTest {

    protected ContexturesPageSteps contexturesSteps;
    protected SteamPageSteps steamSteps;
    protected SteamAboutPageSteps steamAboutSteps;
    protected DownloadFilePageSteps downloadPageSteps;
    protected WebDriverCreator instance;

    public BaseTest() {
        this.downloadPageSteps = new DownloadFilePageSteps();
        this.contexturesSteps = new ContexturesPageSteps();
        this.steamSteps = new SteamPageSteps();
        this.steamAboutSteps = new SteamAboutPageSteps();
    }

    @BeforeMethod
    public void createInstance() {
        instance = WebDriverCreator.getWebDriverCreator();
    }

    @AfterMethod
    public void closeDriver() {
        instance.getWebDriver().close();
    }

}
