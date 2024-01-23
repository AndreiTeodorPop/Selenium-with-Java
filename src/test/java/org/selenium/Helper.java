package org.selenium;

import java.io.File;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class Helper {

    public static boolean verifyDownloadedFile(String expectedFileName, String location) throws InterruptedException {
        Thread.sleep(10000);
        File folder = new File(location);
        File[] fileList = folder.listFiles();
        boolean isFilePresent = false;
        assert fileList != null;
        for(File file:fileList) {
            if(file.isFile()) {
                String fileName = file.getName();
                System.out.println(fileName);
                if(fileName.matches(expectedFileName)){
                    isFilePresent = true;
                }
            }
        }
        return isFilePresent;
    }

    public static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContent = directoryToBeDeleted.listFiles();
        if(allContent != null) {
            for (File file: allContent) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }
}
