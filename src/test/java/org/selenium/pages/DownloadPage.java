package org.selenium.pages;

import org.openqa.selenium.By;
import org.selenium.Helper;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.apache.commons.io.file.PathUtils.deleteDirectory;

/**
 * @author : andrei
 * @created : 1/23/2024, Monday
 **/
public class DownloadPage extends HomePage {

    private static final String expectedFileName = "samplefile.pdf";
    private static final String location = System.getProperty("user.dir") + File.separator + "src/main/resources/download";
    Path download = Paths.get(location);

    public void downloadFile() throws InterruptedException, IOException {
        deleteDirectory(download);
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        Assert.assertTrue(Helper.verifyDownloadedFile(expectedFileName, location));
    }
}
