package org.selenium.tests;

import org.selenium.Hooks;
import org.selenium.pages.HomePage;
import org.selenium.pages.RegisterPage;
import org.selenium.pages.UploadPage;
import org.testng.annotations.Test;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class UploadPageTest extends Hooks {

    @Test
    public void uploadFileDemo() throws Exception {
        HomePage homePage = new HomePage(getDriver());
        RegisterPage registerPage = new RegisterPage(getDriver());
        UploadPage uploadPage = new UploadPage(getDriver());
        homePage.navigateToHomePage();
        homePage.navigateToRegisterPage();
        registerPage.acceptCookies();
        registerPage.navigateToUploadPage();
        uploadPage.makeScreenShotOfUploadButton();
        uploadPage.uploadFile();
    }
}
