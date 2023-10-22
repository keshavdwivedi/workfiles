package com.pageobjects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.propertiesReader.PropertiesReader;
import com.relevantcodes.extentreports.LogStatus;
import com.testbase.PagefactoryBase;

public class SignonFour {
	
	WebDriver localdriver;
	
	public SignonFour(WebDriver driver) {
		this.localdriver=driver;
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/configurations/log4j.properties");
	}
	
	@FindBy(how=How.XPATH,using="//img[@src='/images/masts/mast_book.gif']")@CacheLookup public WebElement Bookflightlogo;
	@FindBy(how=How.NAME,using="passFirst0")@CacheLookup public WebElement Firstname;
	@FindBy(how=How.NAME,using="passLast0")@CacheLookup public WebElement lastname;
	@FindBy(how=How.NAME,using="pass.0.meal")@CacheLookup public WebElement mealpreference;
	@FindBy(how=How.NAME,using="creditnumber")@CacheLookup public WebElement creditcardno;
	@FindBy(how=How.NAME,using="cc_exp_dt_mn")@CacheLookup public WebElement creditcardexpMonth;
	@FindBy(how=How.NAME,using="cc_exp_dt_yr")@CacheLookup public WebElement creditcardexpYear;
	@FindBy(how=How.XPATH,using="//input[@name='buyFlights']")@CacheLookup public WebElement purchasebutton;
	public final Logger logger=Logger.getLogger(SignonFour.class.getName());
	
	public void checkbookflightlogo()
	{
		Assert.assertTrue(Bookflightlogo.isDisplayed(),"Book flight logo not getting displayed");
		PagefactoryBase.Test.log(LogStatus.INFO,"Book flight logo verified");
		logger.info("Book flight logo has been verified");
	}
	
	public void enterPassengerDetails() throws IOException
	{
		Firstname.sendKeys(PropertiesReader.getfirstname());
		lastname.sendKeys(PropertiesReader.getlastname());
		Select mealprefDrp=new Select(mealpreference);
		mealprefDrp.selectByVisibleText("Kosher");
		PagefactoryBase.Test.log(LogStatus.INFO,"Passenger details filled successfully");
		logger.info("Passenger details have been filled successfully");
	}
	
	public void enterCardDetails()
	{
		Select cardexpmonth=new Select(creditcardexpMonth);
		Select cardexpyear=new Select(creditcardexpYear);
		creditcardno.sendKeys("098765432109876543210");
		cardexpmonth.selectByVisibleText("12");
		cardexpyear.selectByVisibleText("2010");
		PagefactoryBase.Test.log(LogStatus.INFO,"card details filled successfully");
		logger.info("card details have been filled successfully");
	}
	
	public void clickpurchasebutton()
	{
		((JavascriptExecutor)localdriver).executeScript("arguments[0].scrollIntoView();",purchasebutton);
		purchasebutton.click();
	}
	
	
	
	
	
}
