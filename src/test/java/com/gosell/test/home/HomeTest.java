package com.gosell.test.home;


import com.gosell.test.BaseTest;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(
        features="src/test/resources/features/home/home.feature",
        glue={"com.gosell.stepdefs"},
        format= {"pretty","html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/re-run.txt"}
)
public class HomeTest extends BaseTest {

    @Test(description = "TC: Verify Home page",dataProvider = "features")
    public void verifyHomePageContent(CucumberFeatureWrapper cFeature){
        testRunner = new TestNGCucumberRunner(this.getClass());
        testRunner.runCucumber(cFeature.getCucumberFeature());
    }

    @DataProvider(name="features")
    public Object[][] getFeatures() {
        return testRunner.provideFeatures();
    }
}
