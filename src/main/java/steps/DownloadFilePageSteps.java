package steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import pages.DownloadFilePage;
import utils.files.FilesUtils;
import utils.wait.Wait;

import java.util.List;

public class DownloadFilePageSteps extends BaseSteps {

    private String getPathToDownloadDir() {
        return new DownloadFilePage().getPathToDownloadDir();
    }

    public List getFilesFromDownload() {
        return new DownloadFilePage().getFilesFromDownload();
    }

    public int getFilesCountInDownload() {
        int filesCount = new DownloadFilePage().getFilesCountInDownload();
        Logger.getLogger(DownloadFilePageSteps.class).info(String.format("Getting file count from Download repository %d", filesCount));
        return filesCount;
    }

    public List<String> getFileNamesInDownload() {
        return new DownloadFilePage().getFileNamesInDownload();
    }

    public boolean isFileDownloaded(String fileName) {
        try {
            Wait.waitParticularState(() -> FilesUtils.isFileDownloaded(fileName));
        }catch (TimeoutException exception) {
            return false;
        }
        return FilesUtils.isFileDownloaded(fileName);
    }

    public boolean isAnyFileDownloaded(int countBefore) {
        DownloadFilePage downloadPage = new DownloadFilePage();
        try{
            downloadPage.waitUntilFileDownloaded(countBefore);
        }catch (TimeoutException ex) {
            Logger.getLogger(DownloadFilePageSteps.class).info("File was not downloaded");
            return false;
        }
        return (downloadPage.getFilesCountInDownload() - countBefore == 1);
    }
}
