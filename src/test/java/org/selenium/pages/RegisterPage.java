package org.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;

import static org.selenium.Helper.takeScreenShotOfElement;
import static org.selenium.Helper.takeScreenShotOfPage;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class RegisterPage extends AbstractPage {
    @FindBy(xpath = "//input[@ng-model='FirstName']")
    WebElement firstNameBox;

    @FindBy(xpath = "//input[@ng-model='LastName']")
    WebElement lastNameBox;

    @FindBy(xpath = "//button[@id='Button1']")
    WebElement refreshButton;

    public RegisterPage() {
        InitPage();
    }


    public void addUserCredentials() {
        firstNameBox.sendKeys("Andrei");
        lastNameBox.sendKeys("Pop");
    }

    public void refreshPageAndScreenShot() throws IOException {
        refreshButton.click();
        takeScreenShotOfElement(refreshButton, "RefreshButton");
    }

    public UploadPage navigateToUploadPage() throws Exception {
        driver.navigate().to("https://demo.automationtesting.in/FileUpload.html");
        Assert.assertEquals("File input - Multi select", driver.getTitle());
        takeScreenShotOfPage(driver, "UploadPage.png");
        return new UploadPage();
    }

    public DownloadPage navigateToDownloadPage() throws Exception {
        driver.navigate().to("https://demo.automationtesting.in/FileDownload.html");
        Assert.assertEquals("File input - Multi select", driver.getTitle());
        takeScreenShotOfPage(driver, "DownloadPage.png");
        return new DownloadPage();
    }

}
