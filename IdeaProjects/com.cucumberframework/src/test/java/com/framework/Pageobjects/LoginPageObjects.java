package com.framework.Pageobjects;

import basehelper.HelperClass;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import basehelper.Baseutil;

public class LoginPageObjects {

    @SuppressWarnings("unused")
    private Baseutil obj;

    public LoginPageObjects(Baseutil obj) {
        this.obj = obj;
        PageFactory.initElements(obj.getdriver(), this);
        HelperClass.logger= LogManager.getLogger(getClass().getName());
    }

    @FindBy(how = How.CSS, using = "a.login")
    @CacheLookup
    public WebElement signinlink;
    @FindBy(how = How.CSS, using = "button#SubmitLogin")
    @CacheLookup
    public WebElement loginbutton;
    @FindBy(how = How.CSS, using = "input#email")
    @CacheLookup
    public WebElement emailfield;
    @FindBy(how = How.CSS, using = "input#passwd")
    @CacheLookup
    public WebElement passwordfield;
    @FindBy(how = How.CSS, using = "div#center_column>div:nth-child(2)>p")
    @CacheLookup
    public WebElement errormessage;

    public void clicksigninlink() {
        signinlink.click();
    }

    public void clickLoginButton() {
        loginbutton.click();
    }

    public void checkblanksubmitMessage() {
        if (errormessage.isDisplayed()) {
            HelperClass.logger.info("Blank submit error message has been validated");
        }
    }

    public void enterInvalidCredentials() {
        String emailstring=HelperClass.generateString()+"@gmail.com";
        emailfield.sendKeys(emailstring);
        passwordfield.sendKeys("123456");
        HelperClass.logger.info("The invalid crddentials on login page class has been validated");

    }

    public void CheckAuthenticationErrorMessage() {
        if (errormessage.isDisplayed()) {
            HelperClass.logger.info("Authentication error message has been validated");
        }
    }

}
