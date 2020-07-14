package com.gosell.stepdefs.common;

import com.gosell.pageobject.common.HeaderPO;
import com.gosell.stepdefs.BaseStep;
import cucumber.api.java.en.When;


public class HeaderStep extends BaseStep {

    private HeaderPO headerPO;

    public HeaderStep() {
        headerPO = new HeaderPO(webDriver);
    }

    @When("^Logout GoSELL$")
    public void logout(){
        headerPO.logout();
    }

}
