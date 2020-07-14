package com.gosell.pageobject.product;

import com.gosell.pageobject.BasePagePO;
import com.kirwa.nxgreport.NXGReports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPO extends BasePagePO {

    @FindBy(xpath = ".//a[@href='/product/list']")
    private WebElement menuProduct;

    @FindBy(xpath = ".//div[text()='Create Product']")
    private WebElement btnCreateProduct;

    /**
     * Constructor
     */
    public ProductPO(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }


    public void goToProductPage(){
        NXGReports.addStep("Click Product menu",false);
        menuProduct.click();
    }

    public void verifyProductPage(){
        NXGReports.addStep("Verify Product page content by Create Product button display",false);
        validateElement(btnCreateProduct,"Create Product",Element_Type.TEXT_VALUE);
    }


}
