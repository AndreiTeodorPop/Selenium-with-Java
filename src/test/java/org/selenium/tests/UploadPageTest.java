package org.selenium.tests;

import org.selenium.Hook;
import org.selenium.pages.HomePage;
import org.selenium.pages.RegisterPage;
import org.selenium.pages.UploadPage;
import org.testng.annotations.Test;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class UploadPageTest extends Hook {

    @Test
    public void uploadFileDemo() throws Exception {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        UploadPage uploadPage = new UploadPage();
        homePage.navigateToRegisterPageAndAcceptCookies();
        registerPage.navigateToUploadPage();
        uploadPage.uploadFile();
    }
}
