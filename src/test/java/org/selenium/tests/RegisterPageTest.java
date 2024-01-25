package org.selenium.tests;

import org.selenium.Hooks;
import org.selenium.pages.HomePage;
import org.selenium.pages.RegisterPage;
import org.testng.annotations.Test;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class RegisterPageTest extends Hooks {

    @Test
    public void registerDemo() throws Exception {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        homePage.navigateToHomePage();
        homePage.navigateToRegisterPageAndAcceptCookies();
        registerPage.addUserInfo();
        registerPage.refreshPage();
        registerPage.makeScreenShotOfRefreshButton();
    }
}
