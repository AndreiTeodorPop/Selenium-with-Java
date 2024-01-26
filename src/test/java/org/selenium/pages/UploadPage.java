package org.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.helper.Constants;

import java.io.File;
import java.io.IOException;

import static org.selenium.helper.Helper.takeScreenShotOfElement;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class UploadPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='input-4']")
    WebElement uploadButton;

    @FindBy(xpath = "//div[@class='btn btn-primary btn-file']")
    WebElement uploadButtonScreenShot;

    public UploadPage(WebDriver driver) {
        super(driver);
    }


    public void uploadFile() {
        File file = new File(Constants.UPLOAD_FILE);
        uploadButton.sendKeys(file.getAbsolutePath());
    }

    public void makeScreenShotOfUploadButton() throws IOException {
        takeScreenShotOfElement(uploadButtonScreenShot, "UploadButton");
    }
}
