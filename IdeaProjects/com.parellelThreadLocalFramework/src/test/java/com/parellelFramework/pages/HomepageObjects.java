package com.parellelFramework.pages;

import com.parellelFramework.tests.TestSetup;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageObjects {

    protected WebDriver driver;

    public HomepageObjects(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        TestSetup.logger= LogManager.getLogger(getClass().getName());
    }

    @FindBy(name = "username")protected  @CacheLookup WebElement emailField;
    @FindBy(name = "password")protected  @CacheLookup WebElement passwordField;
    @FindBy(xpath = "//input[@value='Login']")protected  @CacheLookup WebElement loginButton;

    public void clickLoginButton(){
        loginButton.click();
        TestSetup.logger.info("Login button clicked");
    }

    public void fillCredentials(String usernameValue,String passwordValue){

        emailField.sendKeys(usernameValue);
        passwordField.sendKeys(passwordValue);
        TestSetup.logger.info("Entered values "+usernameValue+" and "+passwordValue+ " in username and password fields");
    }
}
