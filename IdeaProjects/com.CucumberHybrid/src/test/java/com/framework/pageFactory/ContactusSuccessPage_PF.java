package com.framework.pageFactory;

import com.framework.utils.BaseSetup;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactusSuccessPage_PF extends BaseSetup {

    public ContactusSuccessPage_PF(){

        PageFactory.initElements(driver,this);
        logger= LogManager.getLogger(getClass().getName());
    }

    @FindBy(css = "p.alert.alert-success")protected @CacheLookup WebElement successMessage;

    public void validateSuccessmessage(String expectedsuccessMessage){

        String actualsuccessmessage=successMessage.getText();
        Assert.assertTrue(expectedsuccessMessage.equalsIgnoreCase(actualsuccessmessage));
        logger.debug("The success message "+actualsuccessmessage+" in contact us form has been validated");
    }

}
