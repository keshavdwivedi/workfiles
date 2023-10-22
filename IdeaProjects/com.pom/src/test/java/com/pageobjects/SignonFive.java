package com.pageobjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.testbase.PagefactoryBase;

public class SignonFive {
	
WebDriver localdriver;
	
	public SignonFive(WebDriver driver) {
		this.localdriver=driver;
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/configurations/log4j.properties");
	}
	
	@FindBy(how=How.CSS,using="img[src='/images/masts/mast_confirmation.gif']")@CacheLookup public WebElement Bookingconfirmationlogo;
	@FindBy(how=How.CSS,using="img[src='/images/forms/Logout.gif']")@CacheLookup public WebElement logoutbutton;
	public final Logger logger=Logger.getLogger(SignonFive.class.getName());
	
	public void verifybookconfirmlogo()
	{
		Assert.assertTrue(Bookingconfirmationlogo.isDisplayed(),"booking confirmation logo not present");
		PagefactoryBase.Test.log(LogStatus.INFO,"Booking confirmation logo has been validated");
		logger.info("booking confirmation logo has been validated");
	}
	
	public void clicklogout()
	{
		Assert.assertTrue(logoutbutton.isDisplayed(),"Logout button not present");
		logoutbutton.click();
		PagefactoryBase.Test.log(LogStatus.INFO,"Logout button has been validated and clicked successfully");
		logger.info("log out button clicked successfully");
	}

}
