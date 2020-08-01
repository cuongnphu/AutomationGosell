package com.gosell.test;


import com.gosell.helper.PropertiesHelper;
import com.gosell.stepdefs.BaseStep;
import cucumber.api.testng.TestNGCucumberRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;



public abstract class BaseTest {

    private String OS = System.getProperty("os.name").toLowerCase();
    protected static final String PROPERTIES_DATA = "gosell.properties";
    protected String url = PropertiesHelper.getConfigValue(PROPERTIES_DATA,"url");
    protected String browser = PropertiesHelper.getConfigValue(PROPERTIES_DATA,"browser");
    protected boolean isEnglishLanguage = Boolean.parseBoolean(PropertiesHelper.getConfigValue(PROPERTIES_DATA,"isEnglishLanguage"));
    protected WebDriver webDriver;
    protected TestNGCucumberRunner testRunner;

    enum BrowserType{
        CHROME, FIREFOX, IE
    }

    @BeforeClass
    public void setup(){
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

        // Set params to BaseStep
        BaseStep.setWebDriver(webDriver);
        BaseStep.setUrl(url);
        BaseStep.setIsEnglish(isEnglishLanguage);
        BaseStep.setBrowser(browser);

        testRunner = new TestNGCucumberRunner(this.getClass());
    }

    @AfterClass
    public void tearDown(){
        webDriver.close();
        webDriver.quit();
        testRunner.finish();
    }

}
