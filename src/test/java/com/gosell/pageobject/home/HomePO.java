package com.gosell.pageobject.home;


import com.gosell.pageobject.BasePagePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePO extends BasePagePO<HomePO> {

    @FindBy(css = ".gs-page-content > .title")
    private WebElement eleWelcomeTitle;

    @FindBy(css = ".what-to-do-next > .title")
    private WebElement eleToDoTitle;

    /**
     * Constructor
     * @param webDriver
     */
    public HomePO(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        validateElement(eleWelcomeTitle,"Welcome to Gosell Title",Element_Type.DISPLAYED);
        validateElement(eleToDoTitle,"What to do next",Element_Type.TEXT_VALUE);
    }

    public void verifyContentPage(){
        isLoaded();
    }

}
