package com.gosell.stepdefs.product;

import com.gosell.pageobject.product.ProductPO;
import com.gosell.stepdefs.BaseStep;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class ProductStep extends BaseStep {

    private ProductPO productPO;

    public ProductStep() {
        productPO = new ProductPO(webDriver);
    }

    @When("^Go to Product page$")
    public void goToProductPage(){
        productPO.goToProductPage();
    }

    @Then("^Verify Product page$")
    public void verifyProductPage(){
        productPO.verifyProductPage();
    }

}
