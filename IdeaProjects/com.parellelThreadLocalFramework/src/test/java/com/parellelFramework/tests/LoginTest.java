package com.parellelFramework.tests;

import com.parellelFramework.pages.HomepageObjects;
import com.parellelFramework.testDataSetup.DataProvidersList;
import com.parellelFramework.utilities.CommonUtils;
import com.parellelFramework.utilities.CommonWaitHelper;
import org.testng.annotations.Test;

public class LoginTest extends TestSetup {

    HomepageObjects homepageObjects;

    @Test(dataProvider = "loginData",dataProviderClass = DataProvidersList.class)
    void DemoTest(String username,String password) {
        homepageObjects=new HomepageObjects(driver);
        CommonWaitHelper.setImplicitWait(driver,50);
        driver.get(propertiesFileReaderObject.getAppURL());
        homepageObjects.fillCredentials(username, CommonUtils.decodePassword(password));
        homepageObjects.clickLoginButton();
    }
 }
