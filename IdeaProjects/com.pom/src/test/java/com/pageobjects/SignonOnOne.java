package com.pageobjects;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import com.propertiesReader.PropertiesReader;
import com.relevantcodes.extentreports.LogStatus;
import com.testbase.PagefactoryBase;

public class SignonOnOne {
	
	WebDriver localdriver;
	
	public SignonOnOne(WebDriver driver) {
		this.localdriver=driver;
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/configurations/log4j.properties");
	}

	@FindBy(how=How.LINK_TEXT,using="SIGN-OFF") @CacheLookup public WebElement signofflink;
	@FindBy(how=How.NAME,using="userName")@CacheLookup public WebElement username;
	@FindBy(how=How.NAME,using="password")@CacheLookup public WebElement password;
	@FindBy(how=How.XPATH,using="//input[@name='login']")@CacheLookup public WebElement submitbutton;
	@FindBy(how=How.XPATH,using="//input[@name='login']")@CacheLookup public List<WebElement> submitb1utton;
	public final Logger logger=Logger.getLogger(SignonOnOne.class.getName());
	
	public void clicksignoff()
	{
		signofflink.click();
	}
	
	public void verifyloginelements()
	{
		Assert.assertTrue(username.isDisplayed(),"username is not displayed");
		Assert.assertTrue(password.isDisplayed(), "password is not displayed");
		Assert.assertTrue(submitbutton.isDisplayed(),"submit button is not displayed");
		PagefactoryBase.Test.log(LogStatus.INFO,"login elements have been verified successfully");
		logger.info("Login elements have been validated successfully");
	}
	
	public void login() throws IOException
	{
		username.sendKeys(PropertiesReader.getusername());
		String pword=PagefactoryBase.decodepassword(PropertiesReader.getpassword());
		password.sendKeys(pword);
		submitbutton.click();
		PagefactoryBase.Test.log(LogStatus.INFO,"login has been done successfully");
		logger.info("login has been done successfully");
	}
	
	
}
