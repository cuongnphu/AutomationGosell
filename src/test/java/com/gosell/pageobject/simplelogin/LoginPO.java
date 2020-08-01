package com.gosell.pageobject.simplelogin;

import com.gosell.pageobject.utils.GenericUtils;
//import com.kirwa.nxgreport.NXGReports;
//import com.kirwa.nxgreport.logging.LogAs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class LoginPO extends BaseLoginPO{

    @FindBy(xpath = ".//img[@alt='logo']")
    private WebElement logoGosell;

    @FindBy(css = "h3 > p[style=\"margin-bottom: 0px;\"]")
    private WebElement sloLogin;

    @FindBy(css = "#username")
    private WebElement txtEmail;

    @FindBy(css = "#password")
    private WebElement txtPassword;

    @FindBy(css = ".gs-button")
    private WebElement btnLogin;

    @FindBy(css = "#username + div")
    private WebElement eleErrorUsername;

    @FindBy(css = "#password + div")
    private WebElement eleErrorPassword;

    // Impl Constructor
    public LoginPO(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    public void verifyContentPage() {
//        NXGReports.addStep("Verify logo GoSELL is displayed", false);
        validateElement(logoGosell,"logo Gosell", Element_Type.DISPLAYED);
//        NXGReports.addStep("Verify welcome login text is displayed",false);
        validateElement(sloLogin,"Welcome back, please login",Element_Type.TEXT_VALUE);
    }

    public void login(String username, String password){
//        NXGReports.addStep("Enter email: " + username, false);
        txtEmail.sendKeys(username);

//        NXGReports.addStep("Enter password: " + password,false);
        txtPassword.sendKeys(password);

//        NXGReports.addStep("Click Login button",false);
        btnLogin.click();

        GenericUtils.wait(10000);
    }

    public void verifyLoginSuccess(){
        // Initialize WebStore & LocalStore to get accessToken
        WebStorage webStorage = (WebStorage) new Augmenter().augment(webDriver);
        LocalStorage localStorage = webStorage.getLocalStorage();

        // Verify accessToken value
//        NXGReports.addStep("Verify accessToken is created",false);
        Assert.assertNotNull(localStorage.getItem("accessToken"));
    }


}
