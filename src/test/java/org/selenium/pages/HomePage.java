package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selenium.Constants;
import org.testng.Assert;

import static org.selenium.Helper.takeScreenShotOfPage;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class HomePage {
    protected static WebDriver driver;

    @FindBy(xpath = "//img[@id='enterimg']")
    WebElement registerPageRedirect;

    @FindBy(xpath = "//p[@class='fc-button-label' and text() = 'Consent']")
    WebElement acceptCookiesButton;

    public void InitPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage navigateToHomePage() throws Exception {
        driver.navigate().to(Constants.APP_URL);
        takeScreenShotOfPage(driver, "IndexPage.png");
        driver.manage().window().maximize();
        Assert.assertEquals("Index", driver.getTitle());
        return this;
    }

    public RegisterPage navigateToRegisterPageAndAcceptCookies() throws Exception {
        driver.findElement(By.xpath("//img[@id='enterimg']")).click();
        driver.findElement(By.xpath("//p[@class='fc-button-label' and text() = 'Consent']")).click();
        Assert.assertEquals("Register", driver.getTitle());
        takeScreenShotOfPage(driver, "RegisterPage.png");
        return new RegisterPage();
    }
}
