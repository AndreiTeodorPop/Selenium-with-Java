package org.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class AbstractPage {

    protected static WebDriver driver;

    public void InitPage() {
        PageFactory.initElements(driver, this);
    }
}
