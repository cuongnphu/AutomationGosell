package com.gosell.pageobject.simplelogin;

import com.gosell.pageobject.utils.GenericUtils;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPO extends BaseLoginPO<LoginPO> {

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

    // Impl Getter
    public WebElement getLogoGosell() {
        return logoGosell;
    }

    public WebElement getSloLogin() {
        return sloLogin;
    }

    public WebElement getTxtEmail() {
        return txtEmail;
    }

    public WebElement getTxtPassword() {
        return txtPassword;
    }

    public WebElement getBtnLogin() {
        return btnLogin;
    }

    public WebElement getEleErrorUsername() {
        return eleErrorUsername;
    }

    public WebElement getEleErrorPassword() {
        return eleErrorPassword;
    }

    @Override
    public void verifyContentPage() {
        validateElement(logoGosell,"logo Gosell", Element_Type.DISPLAYED);
        validateElement(sloLogin,"Welcome back, please login",Element_Type.TEXT_VALUE);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }

    /**
     * Check login feature
     */
    public void login(String email, String pass){
        NXGReports.addStep("Enter email: " + email, LogAs.PASSED, null);
        txtEmail.sendKeys(email);

        NXGReports.addStep("Enter password: " + pass, LogAs.PASSED, null);
        txtPassword.sendKeys(pass);

        btnLogin.click();

        GenericUtils.wait(10000);
    }


}
