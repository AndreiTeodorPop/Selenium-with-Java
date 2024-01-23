package org.selenium;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class Constants {

    public static final String DOWNLOAD_LOCATION = System.getProperty("user.dir") + File.separator + "src/main/resources/download";

    public static final String APP_URL = "https://demo.automationtesting.in/Index.html";

    public static final String PAGE_SCREENSHOT_FOLDER = "target/demo-screenshots/pages/";
    public static final String ELEMENT_SCREENSHOT_FOLDER = "target/demo-screenshots/elements/";
    public static final String SAMPLEFILE_PDF = "samplefile.pdf";

    public static final String UPLOAD_FILE = "src/main/resources/upload/SamplePicture.jpg";

    public static final Path PATH_DOWNLOAD_LOCATION = Paths.get(DOWNLOAD_LOCATION);

    private Constants() {

    }
}
