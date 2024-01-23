package org.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.Constants;
import org.selenium.Helper;
import org.testng.Assert;

import java.io.IOException;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class DownloadPage extends HomePage {

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement downloadButton;

    public DownloadPage() {
        InitPage();
    }

    public void downloadFile() throws InterruptedException, IOException {
        downloadButton.click();
        Assert.assertTrue(Helper.verifyDownloadedFile(Constants.SAMPLEFILE_PDF, Constants.DOWNLOAD_LOCATION));
    }
}
