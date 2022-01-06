package controllers;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.io.File;
import java.net.URI;

public class ValueAssigner {
    public static ConfigPropertyReader appConfig = new ConfigPropertyReader();

    public static String browser = appConfig.getBrowser();
    public static int maxPageLoadTime = appConfig.getMaxPageLoadTime();
    public static int implicitWait = appConfig.getImplicitlyWait();
    public static String videoFeature = appConfig.getVideoFeature();
    public static String website = appConfig.getUrl();
    public static String videoFolder = appConfig.getVideoFolder();
    public static String appType = appConfig.getAppType();
    public static int retryCount = appConfig.getRetryCount();
    public static String fileSeparator = File.separator;
    public static String osName = System.getProperty("os.name");
    public static String osArchitecture = System.getProperty("os.arch");
    public static String osVersion = System.getProperty("os.version");
    public static String osBit = System.getProperty("sun.arch.data.model");
    public static String projectWorkingDirectory = System.getProperty("user.dir");
    public static Robot re;
    public static Alert al;
    public static Select se;
    public static Actions ac;
}
