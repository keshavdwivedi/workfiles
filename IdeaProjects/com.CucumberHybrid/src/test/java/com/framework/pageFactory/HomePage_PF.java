package com.framework.pageFactory;

import com.framework.utils.BaseSetup;
import com.framework.utils.CommonUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_PF extends BaseSetup {

    boolean flag;

    public HomePage_PF() {
        PageFactory.initElements(driver,this);
        logger= LogManager.getLogger(getClass().getName());
     }

     @FindBy(css = "div.banner>div>div>a>img") protected @CacheLookup WebElement mainBanner;
     @FindBy(id = "search_query_top") protected @CacheLookup WebElement searchtextField;
     @FindBy(name = "submit_search") protected @CacheLookup WebElement searchIcon;
     @FindBy(css = "a.login") protected @CacheLookup WebElement signinLink;
     @FindBy(css = "div#contact-link>a") protected @CacheLookup WebElement contactusLink;

     public void validateBanner(){
         flag=CommonUtils.validateWebelement(mainBanner);
         if(flag){
             logger.debug("Banner on homepage of website has been validated.");
         }
     }

     public void validateHomePageTitle(String expectedTitle){
         CommonUtils.checkTitle(driver,expectedTitle);
     }

     public void validateSearchfield(){
         flag=CommonUtils.validateWebelement(searchtextField);
         if (flag){
             logger.debug("Search field on homepage has been validated.");
         }
     }

     public void enterSearchTxt(String productName){
         searchtextField.sendKeys(productName);
     }

     public void clickSearchIcon(){
         searchIcon.click();
         logger.debug("Search icon has been clicked.");
     }

     public void clickSigninLink(){
         signinLink.click();
         logger.debug("Sign in link has been clicked successfully.");
     }

     public void clickContactusLink(){
         contactusLink.click();
         logger.debug("Contact us link has been clicked successfully.");
     }
}
