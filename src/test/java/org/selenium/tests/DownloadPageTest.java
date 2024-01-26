package org.selenium.tests;

import org.selenium.Hooks;
import org.selenium.pages.DownloadPage;
import org.selenium.pages.HomePage;
import org.selenium.pages.RegisterPage;
import org.testng.annotations.Test;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class DownloadPageTest extends Hooks {

    @Test
    public void downloadFileDemo() throws Exception {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage();
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.acceptCookies();
        registerPage.navigateToDownloadPage();

        DownloadPage downloadPage = new DownloadPage(getDriver());
        downloadPage.clearDownloadFolder();
        downloadPage.downloadFile();
        downloadPage.verifyDownloadFile();
    }
}
