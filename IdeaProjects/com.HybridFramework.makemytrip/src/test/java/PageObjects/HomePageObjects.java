package PageObjects;

import BaseSetup.Makemytrip_SingletonBaseClass;
import DataReaderSetup.PropertiesReader;
import Utilities.CommonUtilties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
    public HomePageObjects(){
        PageFactory.initElements(Makemytrip_SingletonBaseClass.getInstance(),this);
    }

    @FindBy(how= How.XPATH,using="//p[@data-cy='LoginHeaderText']")
    @CacheLookup public WebElement loginLink;

    @FindBy(how=How.CSS,using ="ul.userSection.pushRight>li:nth-child(4) p")
    @CacheLookup public WebElement loggedInUserLabel;

    @FindBy(how=How.CSS,using = "#username")
    @CacheLookup public WebElement usernameField;

    @FindBy(how=How.XPATH,using = "//button[@class='capText font16']")
    @CacheLookup public WebElement continueButton;

    @FindBy(how=How.XPATH,using = "//input[@id='password']")
    @CacheLookup public WebElement passwordField;

    @FindBy(how=How.XPATH,using = " //button[@class='capText font16']")
    @CacheLookup public WebElement loginButton;

    public void clickLoginLink() {
        ((JavascriptExecutor) Makemytrip_SingletonBaseClass.getInstance()).executeScript("arguments[0].click()",loginLink);
    }

    public void enterLoginCredentials() throws InterruptedException {
        usernameField.sendKeys(PropertiesReader.getsignupemail());
        continueButton.click();
        String encryptedPassword=PropertiesReader.getpassword();
        passwordField.sendKeys(CommonUtilties.decryptPassword(encryptedPassword));
        loginButton.click();
        Thread.sleep(3000);
        CommonUtilties.waitForElementTobeVisible(loggedInUserLabel);
    }
}
