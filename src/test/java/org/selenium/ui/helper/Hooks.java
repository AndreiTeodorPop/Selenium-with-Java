package org.selenium.ui.helper;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.selenium.ui.service.BrowserService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
@Getter
public class Hooks extends BrowserService {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setup(String browserName) {
        driver = initSeleniumWebDriver(browserName);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

}
