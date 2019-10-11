import org.testng.Assert;
import org.testng.annotations.Test;

public class SteamScenarios extends BaseTest{

    @Test(enabled = false)
    public void downloadSteamFile() {
        steamSteps.navigateToSteam();
        steamSteps.clickInstallButton();
        int filesCount = downloadPageSteps.getFilesCountInDownload();
        steamAboutSteps.clickInstallSteamButton();
        Assert.assertTrue(downloadPageSteps.isAnyFileDownloaded(filesCount));
    }

    @Test
    public void waitsTestExperiments() {
        steamSteps.navigateToSteam();
        steamSteps.clickUnexistingButton();
    }
}
