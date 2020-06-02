package com.gosell.test;

import com.gosell.helper.PropertiesHelper;
import com.kirwa.nxgreport.NXGReports;
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
                if(OS.contains("win")){
                    System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
                }else if(OS.contains("nix") || OS.contains("nux") || OS.contains("aix")){
                    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
                }
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");    
                DesiredCapabilities cap = DesiredCapabilities.firefox();
                //cap.setCapability("marionette", true);
                webDriver = new FirefoxDriver(cap);
                break;
            case IE:
                System.setProperty("webdriver.ie.driver", "drivers\\IEDriverServer_32.exe");
                DesiredCapabilities capFF = new DesiredCapabilities();
                capFF.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                webDriver = new InternetExplorerDriver(capFF);
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
