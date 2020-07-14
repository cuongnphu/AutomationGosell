package com.gosell.stepdefs;


import com.kirwa.nxgreport.NXGReports;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;


public abstract class BaseStep {
    protected static WebDriver webDriver;
    protected static boolean isEnglish;
    protected static String url;
    protected static String browser;


    /* Setter & Getter */
    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver) {
        BaseStep.webDriver = webDriver;
    }

    public static boolean getIsEnglish() {
        return isEnglish;
    }

    public static void setIsEnglish(boolean isEnglish) {
        BaseStep.isEnglish = isEnglish;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        BaseStep.url = url;
    }

    public static String getBrowser() {
        return browser;
    }

    public static void setBrowser(String browser) {
        BaseStep.browser = browser;
    }

    public void openGoSELLWebsite(WebDriver webDriver){
        // Set webdriver NXGReport
        NXGReports.setWebDriver(webDriver);

        webDriver.get(url);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

}
