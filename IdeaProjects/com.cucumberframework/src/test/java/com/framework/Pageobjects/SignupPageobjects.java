package com.framework.Pageobjects;

import basehelper.HelperClass;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import basehelper.Baseutil;


public class SignupPageobjects {

    @SuppressWarnings("unused")
    private Baseutil obj;


    public SignupPageobjects(Baseutil obj) {
        this.obj = obj;
        PageFactory.initElements(obj.getdriver(), this);
        HelperClass.logger= LogManager.getLogger(getClass().getName());
    }


    @FindBy(how = How.CSS, using = "a.login")
    @CacheLookup
    public WebElement signinlink;
    @FindBy(how = How.CSS, using = "input#email_create")
    @CacheLookup
    public WebElement EmailField;
    @FindBy(how = How.CSS, using = "div.submit>button")
    @CacheLookup
    public WebElement SignupButton;

    public void clickSigninLink() {
        signinlink.click();
    }

    public void checksignupfield() {
        if (EmailField.isDisplayed()) {
            HelperClass.logger.info("Signup Field Appeared on DOM");
        }
    }

    public void clickSignupButton() {
        SignupButton.click();
    }

    public void enterInvalidEmail() {
        EmailField.sendKeys(HelperClass.generateString());
        HelperClass.logger.info("Invalid email entered and validated");
    }

    public void enterValidEmail() {
        EmailField.sendKeys(HelperClass.generateString()+"@gmail.com");
        HelperClass.logger.info("Valid email entered and validated");
    }


}
