package org.selenium.ui.tests;

import org.selenium.ui.helper.Hooks;
import org.selenium.ui.pages.HomePage;
import org.selenium.ui.pages.RegisterPage;
import org.selenium.ui.pages.UploadPage;
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
