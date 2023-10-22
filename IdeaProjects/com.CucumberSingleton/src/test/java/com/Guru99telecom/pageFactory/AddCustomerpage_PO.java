package com.Guru99telecom.pageFactory;

import com.Guru99telecom.BaseUtils.WebdriverSetup;
import com.Guru99telecom.Utils.BasicUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class AddCustomerpage_PO {

    @FindBy(css = "label[id*=message]") protected @CacheLookup List<WebElement>validationMessages;
    @FindBy(name = "submit")protected @CacheLookup WebElement submitButton;
    @FindBy(css = "#main h1")protected @CacheLookup WebElement addCustomerHeading;
    @FindBy(xpath = "//div[@class='2u 12u$(small)']/label") protected @CacheLookup List<WebElement> backgroundCheckButtons;
    @FindBy(id = "fname") protected @CacheLookup WebElement firstNameField;
    @FindBy(id = "lname") protected @CacheLookup WebElement lastNameField;
    @FindBy(id = "email") protected @CacheLookup WebElement emailField;
    @FindBy(css = "textarea#message")protected @CacheLookup WebElement messageField;
    @FindBy(id = "telephoneno")protected @CacheLookup WebElement mobileNo;

    public AddCustomerpage_PO() {

        PageFactory.initElements(WebdriverSetup.getDriver(),this);
        WebdriverSetup.logger= LogManager.getLogger(getClass().getName());
    }

    public void enterMessageField(String messageValue){

        String finalMessage=messageValue+BasicUtils.generateString(30);
        messageField.sendKeys(finalMessage);
        WebdriverSetup.logger.info("The value entered in the message field is "+finalMessage);
    }

    public void enterMobileField(String mobileValue){

        int randomIntValue=BasicUtils.generateInteger(10000,200000);
        String convertedNumber=mobileValue+randomIntValue;
        mobileNo.sendKeys(convertedNumber);
        WebdriverSetup.logger.info("The value entered in the mobile field is "+convertedNumber);
    }

    public void clickSubmitButton(){
        submitButton.click();
        WebdriverSetup.logger.info("Submit button on add customer page has been clicked");
    }

    public void validateAddCustomerHeading(String heading){
        BasicUtils.validateWebelement(addCustomerHeading,heading);
        WebdriverSetup.logger.info("The heading on the add customer page has been validated");
    }

    public void addCustomerValidateAlert(String expectedAlertText){

        Alert alert=BasicUtils.switchValidationAlert(WebdriverSetup.getDriver());
        String actualAlertText=BasicUtils.handleAlert(alert,WebdriverSetup.getDriver());
        Assert.assertEquals(actualAlertText,expectedAlertText);
        WebdriverSetup.logger.info("The Alert text has been validated and text found on alert is "+actualAlertText);
    }

    public void setAddCustomerBackgroundType(String backgroundVal){

        if(backgroundVal.equalsIgnoreCase("Done")){
            backgroundCheckButtons.get(0).click();
            WebdriverSetup.logger.info("Background type Done option has been selected");
        }

        else if (backgroundVal.equalsIgnoreCase("Pending")){
            backgroundCheckButtons.get(1).click();
            WebdriverSetup.logger.info("Background type Pending option has been selected");
        }
    }

    public void fillFirstNameField(String firstNameValue){
        firstNameField.sendKeys(firstNameValue);
        WebdriverSetup.logger.info("The value entered in first name field is "+firstNameValue);
    }

    public void fillLastNameField(String lastNameVal){
        lastNameField.sendKeys(lastNameVal);
        WebdriverSetup.logger.info("The value entered in last name field is "+lastNameVal);
    }

    public void clearNameFields(){

        firstNameField.clear();
        lastNameField.clear();
        WebdriverSetup.logger.info("The name fields have been cleared");
    }

    public void fillEmailField(String emailValue){

        emailField.sendKeys(emailValue);
        WebdriverSetup.logger.info("The value entered in email field is "+emailValue);
    }

    public void clearEmailField(){

        emailField.clear();
        WebdriverSetup.logger.info("Email field has been cleared");

    }

    public void checkValidationMessages(String expectedMessageTxt){

        for (WebElement MessageElement:validationMessages)
        {
            String actualMessagetxt=MessageElement.getText();
            if (expectedMessageTxt.equalsIgnoreCase(actualMessagetxt)){
                WebdriverSetup.logger.info("Validation message "+expectedMessageTxt+" has been found at "+validationMessages.indexOf(MessageElement));
            }
        }
     }
  }
