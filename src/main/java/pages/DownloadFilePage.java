package pages;

import org.openqa.selenium.TimeoutException;
import utils.Properties;
import utils.files.FilesUtils;
import utils.wait.Wait;

import java.util.List;
import java.util.ResourceBundle;

public class DownloadFilePage extends BasePage {

    public static final long DOWNLOAD_TIMEOUT = 60000;
    public static final long DOWNLOAD_POLLING_TIME = 200;

    public String getPathToDownloadDir() {
        return ResourceBundle.getBundle("configuration").getString(Properties.DOWNLOAD_DIR.getPropertyName());
    }

    public List getFilesFromDirectory(String pathToDirectory) {
        return FilesUtils.getFilesFromDirectory(pathToDirectory);
    }

    public List getFilesFromDownload() {
        return getFilesFromDirectory(getPathToDownloadDir());
    }

    public int getFilesCountInDirectory(String pathToDirectory) {
        return getFilesFromDirectory(pathToDirectory).size();
    }

    public int getFilesCountInDownload() {
        return getFilesCountInDirectory(getPathToDownloadDir());
    }

    public List<String> getFileNamesInDirectory(String pathToDirectory) {
        return FilesUtils.getNamesOfFiles(pathToDirectory);
    }

    public List<String> getFileNamesInDownload() {
        return getFileNamesInDirectory(getPathToDownloadDir());
    }

    public void waitUntilFileDownloaded(int countBeforeDownloading) {
        try {
            Wait.waitParticularState(() -> (getFilesCountInDownload() - countBeforeDownloading) == 1, DOWNLOAD_TIMEOUT, DOWNLOAD_POLLING_TIME);
        } catch (TimeoutException ex) {
            throw new RuntimeException("File was not downloaded!");
        }
    }
}
