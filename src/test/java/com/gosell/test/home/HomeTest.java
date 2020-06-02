package com.gosell.test.home;

import com.gosell.helper.ExcelHelper;
import com.gosell.pageobject.home.HomePO;
import com.gosell.pageobject.simplelogin.LoginPO;
import com.gosell.test.BaseTest;
import org.testng.annotations.Test;


public class HomeTest extends BaseTest {

    private HomePO homePO;
    private LoginPO loginPO;

    @Test(priority = 1, description = "Test content on Home page")
    public void verifyHomePageContent(){
        // Get email & password in file excel
        String email = ExcelHelper.readExcelData(testData, "Login", 1, 1);
        String password = ExcelHelper.readExcelData(testData, "Login", 1, 2);

        // Initialize 2 instances PO
        loginPO = new LoginPO(webDriver);
        homePO = new HomePO(webDriver);

        // Login Gosell
        loginPO.login(email,password);

        // Verify page content
        homePO.verifyContentPage();
    }
}
