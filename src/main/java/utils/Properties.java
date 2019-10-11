package utils;

public enum Properties {
    BROWSER("browser"),
    PATH_TO_CHROME_DRIVER("path_to_chrome_driver"),
    PATH_TO_FF_DRIVER("path_to_ff_driver"),
    DOWNLOAD_DIR("download_dir");

    private String property;

    Properties(String property) {
        this.property = property;
    }

    public String getPropertyName() {
        return property;
    }
}
