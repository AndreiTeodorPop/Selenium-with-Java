package org.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.selenium.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class Hook extends HomePage {

    private final String location = System.getProperty("user.dir") + File.separator + "src/main/resources/download";

    Path download = Paths.get(location);


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", download.toAbsolutePath().toString());
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
