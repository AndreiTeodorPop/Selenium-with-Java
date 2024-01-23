package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class UploadPage extends HomePage {

    public void uploadFile() {
        WebElement fileInput = driver.findElement(By.xpath("//input[@id='input-4']"));
        File file = new File("src/main/resources/upload/SamplePicture.jpg");
        fileInput.sendKeys(file.getAbsolutePath());
    }
}
