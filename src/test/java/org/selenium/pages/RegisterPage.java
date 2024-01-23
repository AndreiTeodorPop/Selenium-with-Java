package org.selenium.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class RegisterPage extends HomePage {

    public void addUserCredentials() {
        driver.findElement(By.xpath("//input[@ng-model='FirstName']")).sendKeys("Andrei");
        driver.findElement(By.xpath("//input[@ng-model='LastName']")).sendKeys("Pop");
    }

    public void refreshPageAndScreenShot() {
        driver.findElement(By.xpath("//button[@id='Button1']")).click();
        //makeScreenShotOfButton(refreshButton, "RefreshButton");
    }

    public UploadPage navigateToUploadPage() {
        driver.navigate().to("https://demo.automationtesting.in/FileUpload.html");
        Assert.assertEquals("File input - Multi select", driver.getTitle());
        return new UploadPage();
    }

    public DownloadPage navigateToDownloadPage() {
        driver.navigate().to("https://demo.automationtesting.in/FileDownload.html");
        Assert.assertEquals("File input - Multi select", driver.getTitle());
        return new DownloadPage();
    }

}
