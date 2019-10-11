package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.webdriver.DriverUtils;

import java.util.List;

public class BasePage {

    protected static final String linkXPathByTextPattern = "//a[text()='%s']";

    public void navigateToURL(String url) {
        DriverUtils.getDriver().get(url);
    }

    protected WebElement findElementByXPath(String xPath) {
        return DriverUtils.getDriver().findElement(By.xpath(xPath));
    }

    protected List findElementsByXPath(String xPath) {
        return DriverUtils.getDriver().findElements(By.xpath(xPath));
    }

    protected WebElement findElementById(String id) {
        return DriverUtils.getDriver().findElement(By.id(id));
    }

    protected List findElementsById(String id) {
        return DriverUtils.getDriver().findElements(By.id(id));
    }
}
