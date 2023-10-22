package com.framework.stepDef;

import com.framework.utils.BaseSetup;
import com.framework.utils.CommonUtils;
import com.framework.utils.PropertiesReader;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class Common_stepDef {

    WebDriver driver=null;
    PropertiesReader readerObj;

    @When("user opens browser and navigates to test url")
    public void user_opens_browser_and_navigates_to_test_url() {

        readerObj=new PropertiesReader();
        driver= BaseSetup.webdriverSetup();
        driver.get(readerObj.getUrl());
    }
}
