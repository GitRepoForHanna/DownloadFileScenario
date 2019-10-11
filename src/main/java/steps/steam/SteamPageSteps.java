package steps.steam;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import pages.steam.SteamPage;
import steps.DownloadFilePageSteps;
import utils.webdriver.DriverUtils;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SteamPageSteps extends DownloadFilePageSteps {

    public static final String STEAM_URL = "https://store.steampowered.com/games/";

    public void navigateToSteam() {
        new SteamPage().navigateToURL(STEAM_URL);
    }

    public void clickInstallButton() {
        new SteamPage().clickInstallButton();
    }

    public void clickUnexistingButton() {
        long before = System.currentTimeMillis();
        System.out.println("Before: " + before);
        DriverUtils.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        try{
            new SteamPage().clickUnexistingButton();
        }catch (NoSuchElementException ex) {
            long after = System.currentTimeMillis();
            System.out.println("No such element");
            System.out.println("After: " + after);
            System.out.print("Difference: " + (after-before));
        }catch (TimeoutException ex) {
            long after = System.currentTimeMillis();
            System.out.println("Time out");
            System.out.println("After: " + after);
            System.out.print("Difference: " + (after-before));
        }
    }

}
