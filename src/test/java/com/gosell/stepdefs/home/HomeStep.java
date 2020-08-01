package com.gosell.stepdefs.home;


import com.gosell.pageobject.home.HomePO;
import com.gosell.stepdefs.BaseStep;
import cucumber.api.java.en.Then;


public class HomeStep extends BaseStep {

    private HomePO homePO;

    public HomeStep() {
        homePO = new HomePO(webDriver);
    }

    @Then("^Verify Home page$")
    public void verifyGoSellHomePage(){
        homePO.verifyContentPage();
    }

}
