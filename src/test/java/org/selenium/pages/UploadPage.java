package org.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.Constants;

import java.io.File;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class UploadPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='input-4']")
    WebElement uploadButton;

    public UploadPage() {
        InitPage();
    }

    public void uploadFile() {
        File file = new File(Constants.UPLOAD_FILE);
        uploadButton.sendKeys(file.getAbsolutePath());
    }
}
