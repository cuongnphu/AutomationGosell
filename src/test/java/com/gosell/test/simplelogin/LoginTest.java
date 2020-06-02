package com.gosell.test.simplelogin;

import com.gosell.helper.ExcelHelper;
import com.gosell.pageobject.BasePagePO;
import com.gosell.pageobject.common.HeaderPO;
import com.gosell.pageobject.simplelogin.LoginPO;
import com.gosell.pageobject.utils.GenericUtils;
import com.gosell.test.BaseTest;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    private LoginPO loginPO;
    private HeaderPO headerPO;

    @Test(priority = 1, description = "Test positive test case login ")
    public void login(){
        String email = ExcelHelper.readExcelData(testData, "Login", 1, 1);
        String password = ExcelHelper.readExcelData(testData, "Login", 1, 2);
        loginPO = new LoginPO(webDriver);
        loginPO.switchLanguage(isEnglish);
        loginPO.verifyContentPage();
        loginPO.login(email,password);

        // Initialize WebStore & LocalStore to get accessToken
        WebStorage webStorage = (WebStorage) new Augmenter().augment(webDriver);
        LocalStorage localStorage = webStorage.getLocalStorage();

        // Verify accessToken value
        Assert.assertNotNull(localStorage.getItem("accessToken"));
    }

    @Test(priority = 2, description = "Test positive logout")
    public void logout(){
        headerPO = new HeaderPO(webDriver);
        headerPO.switchLanguage(isEnglish);
        GenericUtils.wait(3000);

        // Click Logout button
        headerPO.logout();
        GenericUtils.wait(3000);

        // Verify Logout successfully
        loginPO.verifyContentPage();
    }

    @Test(priority = 3, description = "Test negative test case login")
    public void loginWithNullEmailAndPassword(){
        NXGReports.addStep("Test Login with null Email & Password", LogAs.PASSED,null);
        loginPO.login("","");
        GenericUtils.wait(1000);

        // Verify Error message display
        loginPO.validateElement(loginPO.getEleErrorUsername(),"This field must not be empty", BasePagePO.Element_Type.TEXT_VALUE);
        loginPO.validateElement(loginPO.getEleErrorPassword(),"This field must not be empty", BasePagePO.Element_Type.TEXT_VALUE);
    }



}
