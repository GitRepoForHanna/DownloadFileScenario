package utils.files;

import utils.Properties;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class FilesUtils {

    public static List getFilesFromDirectory(String pathToDirectory) {
        File folder = new File(pathToDirectory);
        return Arrays.asList(folder.listFiles());
    }

    public static List<String> getNamesOfFiles(String pathToDirectory) {
        List<String> namesList = new ArrayList<>();
        List<File> files = getFilesFromDirectory(pathToDirectory);
        for (File file : files) {
            namesList.add(file.getName());
        }
        return namesList;
    }

    public static boolean isFileDownloaded(String nameOfFile) {
        String downloadDirPath = ResourceBundle.getBundle("configuration").getString(Properties.DOWNLOAD_DIR.getPropertyName());
        File folder = new File(downloadDirPath);
        File[] files = folder.listFiles();

        for (File file : files) {
            if(file.isFile()){
                String fileName = file.getName();
                System.out.println(fileName);
                if(fileName.matches(nameOfFile)){
                    File f = new File(fileName);
                    f.deleteOnExit();
                    file.deleteOnExit();
                    return true;
                }
            }
        }
        return false;
    }
}
