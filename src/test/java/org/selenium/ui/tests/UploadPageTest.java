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
        homePage.navigateToHomePage();
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.acceptCookies();
        registerPage.navigateToUploadPage();

        UploadPage uploadPage = new UploadPage(getDriver());
        uploadPage.makeScreenShotOfUploadButton();
        uploadPage.uploadFile();
    }
}
