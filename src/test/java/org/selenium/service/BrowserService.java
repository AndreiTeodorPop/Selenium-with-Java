package org.selenium.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.selenium.helper.Constants;
import org.selenium.pages.AbstractPage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class BrowserService extends AbstractPage {
    public void initSeleniumWebDriver(String browserName) throws Exception {
        InitPage();
        switch (browserName) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                Map<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("download.default_directory", Constants.PATH_DOWNLOAD_LOCATION.toAbsolutePath().toString());
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "FireFox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setPreference("browser.download.folderList", 2);
                firefoxProfile.setPreference("browser.download.dir",System.getProperty("user.dir") + File.separator + "src" +
                        File.separator + "main" + File.separator + "resources" + File.separator + "download" + File.separator);
                firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/vnd.microsoft.portable-executable");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(firefoxProfile);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "Edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                Map<String, Object> edgePrefs = new HashMap<>();
                edgePrefs.put("download.default_directory", Constants.PATH_DOWNLOAD_LOCATION.toAbsolutePath().toString());
                edgeOptions.setExperimentalOption("edgePrefs", edgePrefs);
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Provide a valid browser name");
        }
    }

}
