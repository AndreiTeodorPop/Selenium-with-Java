package org.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    protected static WebDriver driver;

    public void InitPage() {
        PageFactory.initElements(driver, this);
    }
}
