package org.selenium.ui.tests;

import org.selenium.ui.helper.Hooks;
import org.selenium.ui.pages.HomePage;
import org.selenium.ui.pages.RegisterPage;
import org.testng.annotations.Test;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class RegisterPageTest extends Hooks {

    @Test
    public void registerDemo() throws Exception {
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToHomePage();
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.acceptCookies();
        registerPage.addUserInfo();
        registerPage.refreshPage();
        registerPage.makeScreenShotOfRefreshButton();
    }
}
