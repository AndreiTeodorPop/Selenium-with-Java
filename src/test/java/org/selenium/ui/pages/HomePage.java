package org.selenium.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.selenium.ui.helper.Constants;
import org.selenium.ui.helper.Helper;
import org.testng.Assert;

import static org.selenium.ui.helper.Helper.takeScreenShotOfPage;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class HomePage extends AbstractPage {

    @FindBy(xpath = "//img[@id='enterimg']")
    WebElement registerPageRedirect;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage navigateToHomePage() throws Exception {
        driver.navigate().to(Constants.APP_URL);
        takeScreenShotOfPage(driver, "IndexPage.png");
        driver.manage().window().maximize();
        Assert.assertEquals("Index", driver.getTitle());
        return this;
    }

    public RegisterPage navigateToRegisterPage() throws Exception {
        helper.clickElement(registerPageRedirect);
        Assert.assertEquals("Register", driver.getTitle());
        takeScreenShotOfPage(driver, "RegisterPage.png");
        return new RegisterPage(driver);
    }
}
