package com.gosell.pageobject.common;

import com.gosell.pageobject.BasePagePO;
import com.gosell.pageobject.utils.GenericUtils;
//import com.kirwa.nxgreport.NXGReports;
//import com.kirwa.nxgreport.logging.LogAs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HeaderPO extends BasePagePO{

    @FindBy(css = "span > .selected-flag")
    private WebElement dropLanguage;

    @FindBy(xpath = ".//a//span[text()='Log out']")
    private WebElement eleLogout;

    @FindBy(xpath = ".//span//span[text()=' ENG']")
    private WebElement eleOptEnglish;

    @FindBy(xpath = ".//span//span[text()=' VIE']")
    private WebElement eleOptVietnamese;

    /**
     * Constructor
     * @param webDriver
     */
    public HeaderPO(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    public void switchLanguage(boolean isEnglish){
        if(isEnglish){
//            NXGReports.addStep("Switch to English", false);
            dropLanguage.click();
            GenericUtils.wait(2000);
            eleOptEnglish.click();
        }else {
//            NXGReports.addStep("Switch to Vietnamese",false);
            dropLanguage.click();
            GenericUtils.wait(2000);
            eleOptVietnamese.click();
        }
    }

    public void logout(){
//        NXGReports.addStep("Click Logout",false);
        eleLogout.click();
        GenericUtils.wait(3000);
    }
}
