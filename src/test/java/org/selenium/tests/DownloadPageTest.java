package org.selenium.tests;

import org.selenium.Hook;
import org.selenium.pages.DownloadPage;
import org.selenium.pages.HomePage;
import org.selenium.pages.RegisterPage;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class DownloadPageTest extends Hook {

    @Test
    public void downloadFileDemo() throws InterruptedException, IOException {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        DownloadPage downloadPage = new DownloadPage();
        homePage.navigateToRegisterPageAndAcceptCookies();
        registerPage.navigateToDownloadPage();
        downloadPage.downloadFile();
    }
}
