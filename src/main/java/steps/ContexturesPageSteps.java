package steps;

import org.openqa.selenium.TimeoutException;
import pages.ContexturesPage;
import utils.files.FilesUtils;
import utils.wait.Wait;

public class ContexturesPageSteps extends DownloadFilePageSteps {

    public static final String CONTEXTURES_URL = "https://www.contextures.com/excelfiles.html#Function";

    public void navigateToContextures() {
        new ContexturesPage().navigateToURL(CONTEXTURES_URL);
    }

    public void clickLinkWithText(String linkText) {
        new ContexturesPage().clickLinkWithText(linkText);
    }


}
