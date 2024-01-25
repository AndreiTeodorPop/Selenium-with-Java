package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;

import static org.selenium.helper.Helper.takeScreenShotOfElement;
import static org.selenium.helper.Helper.takeScreenShotOfPage;

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

    @FindBy(xpath = "//a[@class='dropdown-toggle' and text() = 'More']")
    WebElement moreList;

    @FindBy(xpath = "//a[@href='FileDownload.html']")
    WebElement downloadPage;

    @FindBy(xpath = "//a[@href='FileUpload.html']")
    WebElement uploadPage;

    @FindBy(xpath = "//input[@ng-model='EmailAdress']")
    WebElement emailBox;

    @FindBy(xpath = "//input[@value='Male']")
    WebElement maleRadioButton;

    @FindBy(xpath = "//input[@id='checkbox2'][@value='Movies']")
    WebElement moviesCheckBox;

    @FindBy(xpath = "//input[@id='checkbox3'][@value='Hockey']")
    WebElement hockeyCheckBox;

    @FindBy(id = "country")
    WebElement countrySelect;

    public RegisterPage() {
        InitPage();
    }


    public void addUserInfo() {
        firstNameBox.sendKeys("Andrei");
        lastNameBox.sendKeys("Pop");
        emailBox.sendKeys("automation@test.com");
        maleRadioButton.click();
        moviesCheckBox.click();
        hockeyCheckBox.click();
        Select countryDropDown = new Select(countrySelect);
        countryDropDown.selectByVisibleText("United States of America");
    }

    public void refreshPage() {
        refreshButton.click();
    }

    public void makeScreenShotOfRefreshButton() throws IOException {
        takeScreenShotOfElement(refreshButton, "RefreshButton");
    }

    public UploadPage navigateToUploadPage() throws Exception {
        moreList.click();
        uploadPage.click();
        Assert.assertEquals("File input - Multi select", driver.getTitle());
        takeScreenShotOfPage(driver, "UploadPage.png");
        return new UploadPage();
    }

    public DownloadPage navigateToDownloadPage() throws Exception {
        moreList.click();
        downloadPage.click();
        Assert.assertEquals("File input - Multi select", driver.getTitle());
        takeScreenShotOfPage(driver, "DownloadPage.png");
        return new DownloadPage();
    }

}
