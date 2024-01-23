package org.selenium.tests;

import org.selenium.Constants;
import org.selenium.Hook;
import org.selenium.pages.DownloadPage;
import org.selenium.pages.HomePage;
import org.selenium.pages.RegisterPage;
import org.testng.annotations.Test;

import static org.apache.commons.io.file.PathUtils.deleteDirectory;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class DownloadPageTest extends Hook {

    @Test
    public void downloadFileDemo() throws Exception {
        deleteDirectory(Constants.PATH_DOWNLOAD_LOCATION);
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        DownloadPage downloadPage = new DownloadPage();
        homePage.navigateToRegisterPageAndAcceptCookies();
        registerPage.navigateToDownloadPage();
        downloadPage.downloadFile();
    }
}
