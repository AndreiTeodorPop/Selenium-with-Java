package org.selenium.tests;

import org.selenium.Hook;
import org.selenium.pages.HomePage;
import org.selenium.pages.RegisterPage;
import org.testng.annotations.Test;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class RegisterPageTest extends Hook {

    @Test
    public void registerDemo() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = new RegisterPage();
        homePage.navigateToRegisterPageAndAcceptCookies();
        registerPage.addUserCredentials();
        registerPage.refreshPageAndScreenShot();
    }
}
