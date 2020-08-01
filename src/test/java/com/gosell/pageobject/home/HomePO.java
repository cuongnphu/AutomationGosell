package com.gosell.pageobject.home;


import com.gosell.pageobject.BasePagePO;
//import com.kirwa.nxgreport.NXGReports;
//import com.kirwa.nxgreport.logging.LogAs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePO extends BasePagePO {

    @FindBy(css = ".gs-page-content > .title")
    private WebElement eleWelcomeTitle;

    @FindBy(css = ".what-to-do-next > .title")
    private WebElement eleToDoTitle;

    /**
     * Constructor
     */
    public HomePO(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void verifyContentPage() {
//        NXGReports.addStep("Verify: Welcome to Gosell Title", false);
        validateElement(eleWelcomeTitle, "Welcome to Gosell Title", Element_Type.DISPLAYED);
//        NXGReports.addStep("Verify: What to do next", false);
        validateElement(eleToDoTitle, "What to do next", Element_Type.TEXT_VALUE);
    }

}
