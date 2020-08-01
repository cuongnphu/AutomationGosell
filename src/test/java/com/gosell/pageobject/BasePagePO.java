package com.gosell.pageobject;

import com.gosell.library.GenericLib;
//import com.kirwa.nxgreport.NXGReports;
//import com.kirwa.nxgreport.logging.LogAs;
//import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public abstract class BasePagePO {

    protected WebDriver webDriver;
    public static boolean IS_ENGLISH_LANGUAGE = true;

    public enum Element_Type{
        DISPLAYED, IS_ENABLE, IS_SELECTED, HIDDEN, TEXT_VALUE, NOT_EXIST
    }

    /**
     * Constructor
     * @param webDriver
     */
    public BasePagePO(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Get url in Browser
     * @param url
     */
    public void getUrl(String url){
        webDriver.get(url);
    }

    /**
     * Validate WebElement with expected value
     * @param webElement
     * @param expected
     * @param type
     */
    public void validateElement(WebElement webElement, String expected, Element_Type type){
        switch (type){
            case DISPLAYED:
                try {
                    Assert.assertTrue(webElement.isDisplayed(),expected + " is not displayed. ");
                }catch (NoSuchElementException e){
//                    NXGReports.addStep(expected + " is not found", LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    throw new AssertionError(e.getMessage());
                }catch (AssertionError e){
//                    NXGReports.addStep(e.getMessage(), LogAs.FAILED,
//                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    throw new AssertionError(e.getMessage());
                }
                break;
            case IS_ENABLE:
                try {
                    Assert.assertTrue(webElement.isEnabled(), expected + " is not enabled.");
                }catch (NoSuchElementException e){
//                    NXGReports.addStep(expected + " is not found",LogAs.FAILED,
//                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    throw new AssertionError(e.getMessage());
                }catch (AssertionError e){
//                    NXGReports.addStep(e.getMessage(), LogAs.FAILED,
//                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    throw new AssertionError(e.getMessage());
                }
                break;
            case IS_SELECTED:
                try {
                    Assert.assertTrue(webElement.isSelected(), expected + " is not selected  ");
                }catch (NoSuchElementException e){
//                    NXGReports.addStep(expected + " is not found",LogAs.FAILED,
//                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    throw new AssertionError(e.getMessage());
                }catch (AssertionError e){
//                    NXGReports.addStep(e.getMessage(), LogAs.FAILED,
//                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    throw new AssertionError(e.getMessage());
                }
                break;
            case HIDDEN:
                try {
                    Assert.assertFalse(webElement.isDisplayed(), expected + " is not hidden.");
                }catch (NoSuchElementException e){
//                    NXGReports.addStep(expected + " is not found",LogAs.FAILED,
//                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    throw new AssertionError(e.getMessage());
                }catch (AssertionError e){
//                    NXGReports.addStep(e.getMessage(), LogAs.FAILED,
//                            new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    throw new AssertionError(e.getMessage());
                }
                break;
            case TEXT_VALUE:
                try {
                    Assert.assertEquals(getText(webElement), expected);
                }catch (NoSuchElementException e){
//                    NXGReports.addStep(expected + " is not found", LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    throw new AssertionError(e.getMessage());
                }catch (AssertionError e){
//                    NXGReports.addStep(e.getMessage(), LogAs.FAILED, new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
                    throw new AssertionError(e.getMessage());
                }
                break;
            case NOT_EXIST:
                webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                try{
                    webElement.click();
                    throw new AssertionError(expected + " is still displayed.");
                }catch (NoSuchElementException e){
//                    NXGReports.addStep(expected + " is not exist.", LogAs.PASSED,null);
                }
                break;
            default:
                break;

        }
    }

    /**
     * GET Element text
     * @param webElement
     * @return
     */
    public String getText(WebElement webElement){
        if(webElement.getTagName().equals("input") || webElement.getTagName().equals("textarea")){
            return webElement.getAttribute("value");
        }
        return webElement.getText();
    }

    /**
     * Select option in select element by text
     * @param ele
     * @param item
     */
    public void selectOptionByText(WebElement ele, String item){
        Select select = new Select(ele);
        select.selectByVisibleText(item);
    }

    /**
     * Select option in select element by value
     * @param ele
     * @param val
     */
    public void selectOptionByValue(WebElement ele, String val){
        Select select = new Select(ele);
        select.selectByValue(val);
    }

    /**
     * Select option in select element by index
     * @param ele
     * @param index
     */
    public void selectOptionByIndex(WebElement ele, int index){
        Select select = new Select(ele);
        select.selectByIndex(index);
    }

    /**
     * Switch to other tab Windows Browser
     * @param tabIndex
     */
    public void switchToOtherTab(int tabIndex){
        List<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(tabIndex));
    }

    /**
     * Wait until clickable Element
     * @param webElement
     * @param timeOut
     */
    public void waitUntilElementClickable(WebElement webElement, long timeOut){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, timeOut);
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        }catch (TimeoutException e){
//            NXGReports.addStep(e.getMessage(), LogAs.FAILED,
//                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Wait Element text display
     * @param webElement
     * @param timeOut
     * @param text
     */
    public void waitUntilTextPresent(WebElement webElement, long timeOut, String text){
        try{
            WebDriverWait wait = new WebDriverWait(webDriver, timeOut);
            wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
        }catch (TimeoutException e){
//            NXGReports.addStep(e.getMessage(), LogAs.FAILED,
//                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Wait Element is util hidden
     * @param by
     * @param timeOut
     */
    public void waitUntilElementHidden(By by, long timeOut){
        try{
            WebDriverWait wait = new WebDriverWait(webDriver, timeOut);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        }catch (TimeoutException e){
//            NXGReports.addStep(e.getMessage(), LogAs.FAILED,
//                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError(e.getMessage());
        }
    }

    /**
     * Switch to other frame
     * @param name
     */
    public void switchToFrame(String name){
        webDriver.switchTo().frame(name);
    }

    /**
     * Switch to other frame
     * @param id
     */
    public void switchToFrame(int id){
        webDriver.switchTo().frame(id);
    }

    /**
     * Switch to other frame
     * @param eleFrame
     */
    public  void switchToFrame(WebElement eleFrame){
        webDriver.switchTo().frame(eleFrame);
    }

    /**
     * Verify CSS value of element
     * @param webElement
     * @param cssName
     * @param expected
     */
    public void verifyCssValue(WebElement webElement, String cssName, String expected){
        try{
            String actualValue = webElement.getCssValue(cssName);
//            if(cssName.contains("color")){
//                actualValue = GenericLib.parseRgbTohex(actualValue);
//            }
            Assert.assertEquals(actualValue, expected);
        }catch (AssertionError e){
//            NXGReports.addStep(e.getMessage(), LogAs.FAILED,
//                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            throw new AssertionError(e.getMessage());
        }
    }

}
