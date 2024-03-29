package controllers;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath({"config.properties"})
public class ConfigPropertyReader {

    public ConfigPropertyReader() {
        PropertyLoader.newInstance().populate(this);
    }

    @Property(value = "browser")
    private String browser;

    @Property(value = "url")
    private String url;

    @Property(value = "maxPageLoadTime")
    private int maxPageLoadTime;

    @Property(value = "implicitWait")
    private int implicitWait;

    @Property(value = "videoFeature")
    private String videoFeature;

    @Property(value = "videoFolder")
    private String videoFolder;

    @Property(value = "appType")
    private String appType;

    @Property(value = "retryCount")
    private String retryCount;

    public String getUrl() {
        return url;
    }

    public String getBrowser() {
        return browser;
    }

    public int getMaxPageLoadTime() {
        return maxPageLoadTime;
    }

    public int getImplicitlyWait() {
        return implicitWait;
    }

    public String getVideoFeature() {
        return videoFeature;
    }

    public String getVideoFolder() {
        return videoFolder;
    }

    public String getAppType() {
        return appType;
    }

    public int getRetryCount() {
        return Integer.parseInt(retryCount);
    }

}