package org.selenium;

import org.selenium.service.BrowserService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class Hooks extends BrowserService {


    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void setup(String browserName) {
        initSeleniumWebDriver(browserName);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

}
