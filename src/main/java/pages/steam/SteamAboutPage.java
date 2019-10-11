package pages.steam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.DownloadFilePage;
import utils.wait.Wait;
import utils.webdriver.DriverUtils;

public class SteamAboutPage extends DownloadFilePage {

    @FindBy(className = "about_install_steam_link")
    private WebElement installSteamButton;

    public SteamAboutPage() {
        PageFactory.initElements(DriverUtils.getDriver(), this);
    }

    public void clickInstallSteamButton() {
        Wait.waitParticularState(installSteamButton::isDisplayed);
        installSteamButton.click();
    }
}
