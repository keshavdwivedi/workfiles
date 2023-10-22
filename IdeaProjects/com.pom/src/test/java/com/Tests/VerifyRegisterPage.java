package com.Tests;

import com.pageobjects.Registration;
import com.testbase.PagefactoryBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyRegisterPage {

    private String Expectedregistertitle="Register: Mercury Tours";

    @Test(description = "Registration page check")
    public void checkregistration() throws IOException {

        WebDriver driver= PagefactoryBase.startbrowser();
        Registration registerobj= PageFactory.initElements(driver,Registration.class);
        registerobj.clickregisterlink();
        registerobj.checkregisterpagetitle(Expectedregistertitle);
        registerobj.blanksubmit();
    }
}
