package org.selenium.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.selenium.ui.helper.Helper;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class AbstractPage {

    protected WebDriver driver;
    protected Helper helper;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        helper = new Helper();
        PageFactory.initElements(driver, this);
    }
}
