package com.Guru99telecom.pageFactory;

import com.Guru99telecom.BaseUtils.WebdriverSetup;
import com.Guru99telecom.Utils.BasicUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

public class Homepage_PO {

    @FindBy(css = "a.logo") protected @CacheLookup WebElement pageHeading;
    @FindBy(css = "h3>a") protected @CacheLookup List<WebElement>homepageLinks;
    @FindBy(css = "#one>div>div:nth-child(2)>img")protected @CacheLookup  WebElement homepageLogo;

    public Homepage_PO(){

        PageFactory.initElements(WebdriverSetup.getDriver(),this);
        WebdriverSetup.logger= LogManager.getLogger(getClass().getName());
    }

    public void validateHomePageLogo(){

        boolean flag;

        flag=BasicUtils.validateWebelement(homepageLogo);
        if (flag){
            WebdriverSetup.logger.info("The homepage logo has been validated");
        }
    }

    public void validateHomePageLinks(String expectedText) {

        for (WebElement homepageLink : homepageLinks) {
            String homePageTxt = homepageLink.getText();
            if(expectedText.equalsIgnoreCase(homePageTxt)){
                WebdriverSetup.logger.info("Element found and validated in list is "+expectedText);
                break;
            }
        }
    }

    public void clickAddCustomerLink(){

       int size= homepageLinks.size();
        System.out.println("size is "+size);
        homepageLinks.get(0).click();
        WebdriverSetup.logger.info("Add Customer link clicked");

    }

    public void clickAddTariffPlanLink(){
        homepageLinks.get(1).click();
        WebdriverSetup.logger.info("Add Tariff link clicked");
    }

    public void clickAddTariffPlanCustomerLink(){
        homepageLinks.get(2).click();
        WebdriverSetup.logger.info("Add Tariff plan to customer link clicked");
    }

    public void clickPayBillLink(){
        homepageLinks.get(3).click();
        WebdriverSetup.logger.info("Pay bill link clicked");
    }

    public void validateNavigatedPageTitle(String expectedNavigatedHeading){

        BasicUtils.checkTitle(WebdriverSetup.getDriver(),expectedNavigatedHeading);
        WebdriverSetup.logger.info("The page title of navigated page verified is "+expectedNavigatedHeading);
    }

    public void validateHomePageHeading(String pageHeadingtxt){

        BasicUtils.validateWebelement(pageHeading,pageHeadingtxt);
        WebdriverSetup.logger.info("Home page heading"+pageHeadingtxt+"has been validated");
    }

    public void verifyHomepageLinksCount(int homePageExpectedCount){

        int homepageLinkCount=homepageLinks.size();
        Assert.assertEquals(homepageLinkCount,homePageExpectedCount);
        System.out.println("The count of elements found is "+homepageLinkCount);
        WebdriverSetup.logger.info("The count of elements found is "+homepageLinkCount);
    }

    public void navigatebacktoHomePage(){
        WebdriverSetup.getDriver().navigate().back();
    }

}
