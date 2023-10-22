package PageTests;

import DataReaderSetup.ExcelDataProviders;
import PageObjects.HomePageObjects;
import TestEnvSetup.TestSetup;
import org.testng.annotations.Test;

public class HomepageTest extends TestSetup {

    HomePageObjects homePageobj;

    @Test(dataProvider = "LoginData", dataProviderClass = ExcelDataProviders.class)
    public void TestLogin() throws InterruptedException {
        homePageobj=new HomePageObjects();
        homePageobj.clickLoginLink();
        homePageobj.enterLoginCredentials();
    }

}
