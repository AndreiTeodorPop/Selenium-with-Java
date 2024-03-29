package org.selenium.ui.helper;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class Helper {
    public static boolean verifyDownloadedFile(String expectedFileName, String location) throws IOException, InterruptedException {
        Thread.sleep(3000);
        File folder = new File(location);
        File[] fileList = folder.listFiles();
        boolean isFilePresent = false;
        assert fileList != null;
        for (File file : fileList) {
            if (file.isFile()) {
                String data = FileUtils.readFileToString(file, "UTF-8");
                String fileName = file.getName();
                if (fileName.matches(expectedFileName) && !data.isEmpty()) {
                    isFilePresent = true;
                }
            }
        }
        return isFilePresent;
    }

    public static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContent = directoryToBeDeleted.listFiles();
        if (allContent != null) {
            for (File file : allContent) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    public static void takeScreenShotOfPage(WebDriver webdriver, String pageName) throws Exception {
        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(Constants.PAGE_SCREENSHOT_FOLDER + pageName);
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public static void takeScreenShotOfElement(WebElement logo, String elementName) throws IOException {
        File source = ((TakesScreenshot)logo).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File(Constants.ELEMENT_SCREENSHOT_FOLDER + elementName + ".png"));
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void sendKeys(WebElement element, String value) {
        element.sendKeys(value);
    }
}
