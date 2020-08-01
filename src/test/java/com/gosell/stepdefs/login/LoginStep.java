package com.gosell.stepdefs.login;


import com.gosell.pageobject.home.HomePO;
import com.gosell.pageobject.simplelogin.LoginPO;
import com.gosell.stepdefs.BaseStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class LoginStep extends BaseStep {

    private LoginPO loginPO;
    private HomePO homePO;

    public LoginStep() {
        loginPO = new LoginPO(webDriver);
        homePO = new HomePO(webDriver);
    }

    @Given("^Open GoSELL website$")
    public void openGoSell(){
        openGoSELLWebsite(webDriver);
    }

    @When("^Login GoSELL with username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void login(String username, String password){
        loginPO.login(username,password);
    }

    @Then("^Verify login GoSELL$")
    public void verifyLoginSuccess(){
        loginPO.verifyLoginSuccess();
    }

    @Then("^Verify login GoSELL page$")
    public void verifyLogout(){
        loginPO.verifyContentPage();
    }

}
