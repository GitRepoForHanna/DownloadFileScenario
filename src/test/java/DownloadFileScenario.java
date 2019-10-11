import org.testng.Assert;
import org.testng.annotations.Test;

public class DownloadFileScenario extends BaseTest{

    @Test
    public void downloadFile() {
        String fileToLoad = "datavalcombomergedepend.zip";
        contexturesSteps.navigateToContextures();
        contexturesSteps.clickLinkWithText(fileToLoad);
        Assert.assertTrue(contexturesSteps.isFileDownloaded(fileToLoad));
    }

}
