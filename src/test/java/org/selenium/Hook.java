package org.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.selenium.pages.AbstractPage;
import org.selenium.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class Hook extends AbstractPage {


    @BeforeMethod
    public void setup() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", Constants.PATH_DOWNLOAD_LOCATION.toAbsolutePath().toString());
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        HomePage homePage = new HomePage();
        homePage.navigateToHomePage();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
