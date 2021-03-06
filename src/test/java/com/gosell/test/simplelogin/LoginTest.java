package com.gosell.test.simplelogin;

import com.gosell.test.BaseTest;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.*;


@CucumberOptions(
        features="src/test/resources/features/login/login.feature",
        glue={"com.gosell.stepdefs"},
        format= {"pretty","html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/re-run.txt"}
)
public class LoginTest extends BaseTest{

    @Test(description="TC: LoginGoSELL",dataProvider="features")
    public void loginGoSELL(CucumberFeatureWrapper cFeature) {
        testRunner = new TestNGCucumberRunner(this.getClass());
        testRunner.runCucumber(cFeature.getCucumberFeature());
    }

    @DataProvider(name="features")
    public Object[][] getFeatures() {
        return testRunner.provideFeatures();
    }

}
