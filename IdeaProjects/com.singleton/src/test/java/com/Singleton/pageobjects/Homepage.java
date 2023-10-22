package com.Singleton.pageobjects;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import com.base.Helper;
import com.relevantcodes.extentreports.LogStatus;

public class Homepage {
	
	public Homepage(WebDriver localinstance) {
		Helper.Instance=localinstance;
		Helper.logger= LogManager.getLogger(getClass().getName());
	}

	@FindBy(how=How.XPATH,using="//div[@class='header_user_info']/a")
	@CacheLookup public WebElement signinlink;
	
	@FindBy(how=How.CSS,using="img[src='http://automationpractice.com/img/logo.jpg']")
	@CacheLookup public WebElement homepagelogo;

	public void verifylogo()
	{
		Assert.assertTrue(homepagelogo.isDisplayed(),"logo not displayed");
		Helper.test.log(LogStatus.INFO,"Logo of the homepage has been verified");
		Helper.logger.info("Asserted logo on homepage");
	}
	
	public void verifyhomepageURL()
	{
		Assert.assertEquals("http://automationpractice.com/index.php",Helper.Instance.getCurrentUrl(),"Title is not as per expectation");
		Helper.test.log(LogStatus.INFO,"Homepage URL has been verified");
		Helper.logger.info("Asserted URL on homepage");
	}
	
	public void clicksignin()
	{
		signinlink.click();
	}
	

}
