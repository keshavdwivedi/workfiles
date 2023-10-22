package com.Guru99telecom.stepDefs;

import com.Guru99telecom.BaseUtils.WebdriverSetup;
import com.Guru99telecom.Utils.BasicUtils;
import com.Guru99telecom.Utils.PropertiesReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Guru99_CommonStepdefs {

    @Given("User navigates to Guru99 telecom website")
    public void user_navigates_to_guru99_telecom_website() {
        //WebdriverSetup.setupDriver();
        WebdriverSetup.navigateURL(new PropertiesReader().getAppURL());
    }

    @Then("User verifies the page title {string}")
    public void user_verifies_the_page_title(String expectedTitle) {
        BasicUtils.checkTitle(WebdriverSetup.getDriver(),expectedTitle);
    }

}
