package org.selenium.ui.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.ui.helper.Constants;
import org.selenium.ui.helper.Helper;
import org.testng.Assert;

import java.io.IOException;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class DownloadPage extends AbstractPage {

    @FindBy(id = "textbox")
    WebElement textBox;

    @FindBy(id = "createTxt")
    WebElement createFileButton;

    @FindBy(id = "link-to-download")
    WebElement downloadFile;

    public DownloadPage(WebDriver driver) {
        super(driver);
    }


    public void clearDownloadFolder() {
        Helper.deleteDirectory(Constants.PATH_DOWNLOAD_LOCATION.toFile());
    }

    public void downloadFile() {
        helper.sendKeys(textBox, "This is my generated file");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createFileButton);
        helper.clickElement(createFileButton);
        helper.clickElement(downloadFile);
    }

    public void verifyDownloadFile() throws IOException, InterruptedException {
        Assert.assertTrue(Helper.verifyDownloadedFile(Constants.INFO_TXT, Constants.DOWNLOAD_LOCATION));
        System.out.println("File " + Constants.INFO_TXT + " downloaded successfully");
    }
}
