package com.framework.pageFactory;

import com.framework.utils.BaseSetup;
import com.framework.utils.CommonUtils;
import com.framework.utils.WaitHelper;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductList_PF extends BaseSetup {

    public ProductList_PF() {
        PageFactory.initElements(driver,this);
        logger= LogManager.getLogger(getClass().getName());
    }

    @FindBy(css = "div.product-container") protected @CacheLookup WebElement productListing;
    @FindBy(css = "div#center_column>p") protected @CacheLookup WebElement validationMessage;
    @FindBy(css = "h5[itemprop='name']>a") protected @CacheLookup WebElement productnametxt;

    public void validateMessage(String expectedMessage){
        WaitHelper.setwaitTime(driver,30,validationMessage);
        String actualMessage=validationMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        logger.debug("The validation message validated is "+actualMessage);
    }

    public void validateProductlist(){
        boolean flag=CommonUtils.validateWebelement(productListing);
        if(flag){
            logger.debug("The validation for product list on search result page has been done");
        }
    }

    public void getProductname(){
        String productName=productnametxt.getText();
        logger.debug("The product from search list is "+productName);
    }
 }
