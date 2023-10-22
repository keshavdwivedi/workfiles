package com.Guru99telecom.stepDefs.testSetup;

import com.Guru99telecom.BaseUtils.WebdriverSetup;
import com.Guru99telecom.Utils.BasicUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class TestSpecifications {

    @Before
    public void invokeBrowser(){

        WebdriverSetup.setupDriver();
    }

    @After(order = 1)
    public void checkFailScenario(Scenario scenario){

        if(scenario.isFailed()){
            try {
                scenario.log("Scenario "+scenario.getName() +" has been failed");
                BasicUtils.takeScreenShotReturnPath(WebdriverSetup.getDriver());
                BasicUtils.embedScreenShot(scenario,WebdriverSetup.getDriver());
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        else {
            try {
                scenario.log("Scenario "+scenario.getName()+ "has been passed");
                BasicUtils.takeScreenShotReturnPath(WebdriverSetup.getDriver());
                BasicUtils.embedScreenShot(scenario,WebdriverSetup.getDriver());
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @After(order = 0)
    public void closeBrowser(){

        WebdriverSetup.tearDownSession();
    }



}
