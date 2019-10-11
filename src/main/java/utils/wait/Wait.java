package utils.wait;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.webdriver.DriverUtils;

import java.util.concurrent.Callable;

public class Wait {

    public static final long TIMEOUT = 30000;
    public static final long POLLING_TIME = 100;

    public static void waitParticularState(Callable<Boolean> state, long timeout, long pollingTime) {
        new WebDriverWait(DriverUtils.getDriver(), timeout, pollingTime)
                .until(webDriver -> {
                    try {
                        return state.call();
                    } catch (Exception e) {
                        System.out.println("Still waiting...");
                        e.printStackTrace();
                    }
                    return false;
                });
    }

    public static void waitParticularState(Callable<Boolean> state) {
        new WebDriverWait(DriverUtils.getDriver(), TIMEOUT, POLLING_TIME)
                .until(webDriver -> {
                    try {
                        return state.call();
                    } catch (Exception e) {
                        System.out.println("Still waiting...");
                    }
                    return false;
                });
    }
}
