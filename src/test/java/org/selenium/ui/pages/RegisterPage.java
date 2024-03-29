package org.selenium.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.selenium.ui.helper.Helper;
import org.testng.Assert;

import java.io.IOException;

import static org.selenium.ui.helper.Helper.*;

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

    @FindBy(xpath = "//p[@class='fc-button-label' and text() = 'Consent']")
    WebElement acceptCookiesButton;

    @FindBy(id = "country")
    WebElement countrySelect;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }


    public RegisterPage acceptCookies() {
        helper.clickElement(acceptCookiesButton);
        return new RegisterPage(driver);
    }


    public void addUserInfo() {
        helper.sendKeys(firstNameBox, "Andrei");
        helper.sendKeys(lastNameBox, "Pop");
        helper.sendKeys(emailBox, "automation@test.com");
        helper.clickElement(maleRadioButton);
        helper.clickElement(moviesCheckBox);
        helper.clickElement(hockeyCheckBox);
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
        helper.clickElement(moreList);
        helper.clickElement(uploadPage);
        Assert.assertEquals("File input - Multi select", driver.getTitle());
        takeScreenShotOfPage(driver, "UploadPage.png");
        return new UploadPage(driver);
    }

    public DownloadPage navigateToDownloadPage() throws Exception {
        helper.clickElement(moreList);
        helper.clickElement(downloadPage);
        Assert.assertEquals("File input - Multi select", driver.getTitle());
        takeScreenShotOfPage(driver, "DownloadPage.png");
        return new DownloadPage(driver);
    }

}
