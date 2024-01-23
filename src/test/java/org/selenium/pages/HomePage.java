package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class HomePage {

    protected static WebDriver driver;

    public void InitPage() {
        PageFactory.initElements(driver, this);
    }

    private static final String url = "https://demo.automationtesting.in/Index.html";

    public HomePage navigateToHomePage() {
        driver.navigate().to(url);
//        driver.manage().window().maximize();
        Assert.assertEquals("Index", driver.getTitle());
        return this;
    }

    public RegisterPage navigateToRegisterPageAndAcceptCookies() {
        driver.findElement(By.xpath("//img[@id='enterimg']")).click();
        driver.findElement(By.xpath("//p[@class='fc-button-label' and text() = 'Consent']")).click();
        Assert.assertEquals("Register", driver.getTitle());
        return new RegisterPage();
    }
}
