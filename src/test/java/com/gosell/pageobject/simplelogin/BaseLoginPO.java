package com.gosell.pageobject.simplelogin;

import com.gosell.pageobject.BasePagePO;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseLoginPO<T extends BasePagePO<T>> extends BasePagePO<T> {

    @FindBy(xpath = ".//span[text()='English']")
    private WebElement eleEnglish;

    @FindBy(xpath = ".//span[text()='Tiếng Việt']")
    private WebElement eleVietnamese;

    /**
     * Constructor
     * @param webDriver
     */
    public BaseLoginPO(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    public abstract void verifyContentPage();

    public void switchLanguage(boolean isEnglish){
        if(isEnglish){
            NXGReports.addStep("Switch to English", LogAs.PASSED,null);
            eleEnglish.click();
        }else {
            NXGReports.addStep("Switch to Vietnamese", LogAs.PASSED,null);
            eleVietnamese.click();
        }
    }
}
