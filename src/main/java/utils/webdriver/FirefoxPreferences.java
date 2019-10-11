package utils.webdriver;

public enum FirefoxPreferences {
    SHOW_WHEN_STARTING("browser.download.manager.showWhenStarting"),
    SHOW_ALERT_ON_COMPLETE("browser.download.manager.showAlertOnComplete"),
    SAVE_TO_DISK("browser.helperApps.neverAsk.saveToDisk"),
    FOLDER_LIST("browser.download.folderList"),
    DOWNLOAD_DIR("browser.download.dir"),
    USE_DOWNLOAD_DIR("browser.download.useDownloadDir");

    private String preferenceName;

    FirefoxPreferences(String preferenceName) {
        this.preferenceName = preferenceName;
    }

    public String getPreferenceName() {
        return preferenceName;
    }
}
