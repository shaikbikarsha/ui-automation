package controllers;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserInitializer extends ValueAssigner {
    public static WebDriver driver;

    public synchronized static WebDriver createDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        switch (browser.toLowerCase()) {
            case "chrome":
                /* Will use the following based on requirement
                String PROXY = "localhost:4444";
                Proxy proxy = new Proxy();
                proxy.setHttpProxy(PROXY);
                proxy.setSslProxy(PROXY);
                chromeOptions.setCapability("proxy", PROXY);
                chromeOptions.addArguments("--test-type");
                chromeOptions.addArguments("--disable-web-security");
                chromeOptions.addArguments("--ignore-fetcher-cert-requests");
                chromeOptions.addArguments("--disable-renderer-backgrounding");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--user-data-dir=./chrome");
                chromeOptions.addArguments("--proxy-server="+ PROXY);
                chromeOptions.addArguments("--allow-file-access-from-files");
                chromeOptions.addArguments("--allow-running-insecure-content");
                chromeOptions.addArguments("--allow-cross-origin-auth-prompt");
                chromeOptions.addArguments("--allow-file-access");*/
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "chrome_headless" :
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--no-sandbox");
                driver = new ChromeDriver(chromeOptions);
                break;
            default : throw new NotFoundException("Browser Not Found. Please Provide a Valid Browser");
        }
        if (implicitWait > 0) {
            implicitlyWait(implicitWait);
        }

        if (maxPageLoadTime > 0) {
            setMaxPageLoadTime(maxPageLoadTime);
        }
        return driver;
    }

    public static void implicitlyWait(int timeInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
    }

    public static void setMaxPageLoadTime(int timeInSeconds) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeInSeconds));
    }
}
