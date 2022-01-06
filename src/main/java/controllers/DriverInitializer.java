package controllers;

import com.automation.remarks.video.enums.RecorderType;
import com.automation.remarks.video.enums.RecordingMode;
import com.automation.remarks.video.enums.VideoSaveMode;
import com.automation.remarks.video.recorder.VideoRecorder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class DriverInitializer extends BrowserInitializer {
    public static ThreadLocal<WebDriver> wd = new ThreadLocal();

    @BeforeTest(alwaysRun = true)
    public void suiteSetup() {
        switch (browser.toLowerCase()) {
            case "chrome", "chrome_headless" -> WebDriverManager.chromedriver().setup();
            default -> throw new NotFoundException("Browser Not Found. Please Provide a Valid Browser");
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver = DriverInitializer.createDriver();
        setWebDriver(driver);

        if (videoFeature.toLowerCase().contains("enabledfailed")) {
            setupVideoRecordingFailedOnly();
        } else if (videoFeature.toLowerCase().contains("enabledall")) {
            setupVideoRecordingAll();
        }
    }

    public void setupVideoRecordingFailedOnly() {
         VideoRecorder.conf()
                .withVideoFolder(videoFolder)                                            // Default is ${user.dir}/video.
                .videoEnabled(true)                                                     // Disabled video globally
                .withVideoSaveMode(VideoSaveMode.FAILED_ONLY)                           // Save videos ONLY FAILED tests
                .withRecorderType(RecorderType.MONTE)                                   // Monte is Default recorder
                .withRecordMode(RecordingMode.ALL);                                     // Record video only for tests with @Video
    }

    public void setupVideoRecordingAll() {
         VideoRecorder.conf()
                .withVideoFolder(videoFolder)                                            // Default is ${user.dir}/video.
                .videoEnabled(true)                                                     // Disabled video globally
                .withVideoSaveMode(VideoSaveMode.ALL)                                   // Save videos All tests
                .withRecorderType(RecorderType.MONTE)                                   // Monte is Default recorder
                .withRecordMode(RecordingMode.ALL);                                     // Record video only for tests with @Video
    }

    public void setWebDriver(WebDriver driver) {
        wd.set(driver);
    }

    public static WebDriver getWebDriver() {
        return wd.get();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() throws Exception {
        Thread.sleep(2000);
        getWebDriver().quit();
    }
}
