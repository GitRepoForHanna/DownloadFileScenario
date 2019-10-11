package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.wait.Wait;
import utils.webdriver.DriverUtils;

public class ContexturesPage extends DownloadFilePage {

    public ContexturesPage() {
        PageFactory.initElements(DriverUtils.getDriver(), this);
    }

    private WebElement getLinkByText(String linkTitle) {
        return findElementByXPath(String.format(linkXPathByTextPattern, linkTitle));
    }

    public void clickLinkWithText(String linkTitle) {
        WebElement link = getLinkByText(linkTitle);
        Wait.waitParticularState(link::isEnabled);
        link.click();
    }

}
