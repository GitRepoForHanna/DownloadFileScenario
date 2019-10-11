package steps.steam;

import pages.steam.SteamAboutPage;
import steps.DownloadFilePageSteps;

public class SteamAboutPageSteps extends DownloadFilePageSteps {

    public void clickInstallSteamButton() {
        new SteamAboutPage().clickInstallSteamButton();
    }

}
