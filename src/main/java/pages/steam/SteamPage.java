package pages.steam;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.DownloadFilePage;
import utils.wait.Wait;
import utils.webdriver.DriverUtils;

public class SteamPage extends DownloadFilePage {

    @FindBy(className = "header_installsteam_btn_content")
    private WebElement installButton;

    @FindBy(xpath = "//wrongXpath")
    private WebElement unexistingButton;

    public SteamPage() {
        PageFactory.initElements(DriverUtils.getDriver(), this);
    }

    public void clickInstallButton() {
        Wait.waitParticularState(installButton::isDisplayed);
        installButton.click();
    }

    public void clickUnexistingButton() {
        Wait.waitParticularState(unexistingButton::isDisplayed, 10, 500);
        unexistingButton.click();
    }

}
