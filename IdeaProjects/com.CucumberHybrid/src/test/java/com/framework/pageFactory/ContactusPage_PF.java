package com.framework.pageFactory;

import com.framework.utils.BaseSetup;
import com.framework.utils.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ContactusPage_PF extends BaseSetup {

    public ContactusPage_PF(){
        PageFactory.initElements(driver,this);
        logger= LogManager.getLogger(getClass().getName());
    }

    @FindBy(css = "div#center_column>h1")protected @CacheLookup WebElement contactusHeading;
    @FindBy(css = "div.alert.alert-danger li")protected @CacheLookup WebElement validationMessage;
    @FindBy(id = "id_contact")protected @CacheLookup WebElement subjectDropdown;
    @FindBy(id = "email")protected @CacheLookup WebElement emailaddressField;
    @FindBy(id = "message")protected @CacheLookup WebElement messageField;
    @FindBy(id = "submitMessage")protected @CacheLookup WebElement sendButton;

    public void validateContactusPageHeading(String contactusTitle){
        CommonUtils.checkTitle(driver,contactusTitle);
        logger.debug("The title of contact us page validated is "+contactusTitle);
    }

    public void clicksendButton(){
        sendButton.click();
        logger.debug("Send button on contact us page has been clicked successfully.");
    }

    public void checkvalidationMessage(String expectedvalidationMessage){
        String actualvalidationMessage=validationMessage.getText();
        Assert.assertTrue(expectedvalidationMessage.equalsIgnoreCase(actualvalidationMessage));
        logger.debug("The validation message "+actualvalidationMessage+" for contact us has been validated");
    }

    public void enterEmailAddress(String email){
        emailaddressField.clear();
        emailaddressField.sendKeys(email);
    }

    public void selectSubject(String subject){

        Select subjectdropdown=new Select(subjectDropdown);
        subjectdropdown.selectByVisibleText(subject);
        logger.debug("The selected dropdown option is "+subject);
    }

    public void enterMessagetxt(){
        String contactusMessage=CommonUtils.generateString();
        messageField.sendKeys(contactusMessage);
        logger.debug("The message entered in contact us form is "+contactusMessage);
    }

    public void checkcontactusheading(){
        boolean flag=CommonUtils.validateWebelement(contactusHeading);
        if(flag){
            logger.debug("Contact us page heading has been validated");
        }
     }
 }
