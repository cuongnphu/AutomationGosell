package com.gosell.test;

import com.gosell.helper.PropertiesHelper;
import com.kirwa.nxgreport.NXGReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;



public abstract class BaseTest {

    private String OS = System.getProperty("os.name").toLowerCase();
    protected WebDriver webDriver;
    protected boolean isEnglish;
    protected static final String PROPERTIES_DATA = "gosell.properties";
    protected String testData = System.getProperty("user.dir") + "//" +
            PropertiesHelper.getConfigValue(PROPERTIES_DATA, "DATA_FILE");

    enum BrowserType{
        CHROME, FIREFOX, IE
    }

    @BeforeClass
    @Parameters({"url", "browser", "isEnglishLanguage"})
    public void setup(String url, String browser, boolean isEnglishLanguage){
        BrowserType type = BrowserType.valueOf(browser.toUpperCase());
        switch (type){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver();
                break;
            default:
                break;
        }

        // Set webdriver NXGReport
        NXGReports.setWebDriver(webDriver);

        webDriver.get(url);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();

        // Set languages
        isEnglish = isEnglishLanguage;
    }

    @AfterClass
    public void tearDown(){
        webDriver.close();
        webDriver.quit();
    }

}
