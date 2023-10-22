package com.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.testbase.PagefactoryBase;

public class SignonTwo {
	
WebDriver localdriver;
	
	public SignonTwo(WebDriver driver) {
		this.localdriver=driver;
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/configurations/log4j.properties");
	}  

	@FindBy(how=How.CSS,using="img[src='/images/masts/mast_flightfinder.gif']") @CacheLookup public WebElement flightfinderlogo;
	@FindBy(how=How.XPATH,using="//b/font/input[@type='radio']") @CacheLookup public List<WebElement> flighttype;
	@FindBy(how=How.NAME,using="fromPort") @CacheLookup public WebElement fromport;
	@FindBy(how=How.NAME,using="fromMonth") @CacheLookup public WebElement fromMonth;
	@FindBy(how=How.NAME,using="fromDay") @CacheLookup public WebElement fromDay;
	@FindBy(how=How.NAME,using="toPort") @CacheLookup public WebElement toport;
	@FindBy(how=How.NAME,using="toMonth")@CacheLookup public WebElement toMonth;
	@FindBy(how=How.NAME,using="toDay")@CacheLookup public WebElement toDay;
	@FindBy(how=How.XPATH,using="//input[@name='findFlights']")@CacheLookup public WebElement Continuebutton;
	public final Logger logger=Logger.getLogger(SignonTwo.class.getName());
	
	
	public void verifylogin()
	{
		Assert.assertTrue(flightfinderlogo.isDisplayed(),"User login not successful");
		PagefactoryBase.Test.log(LogStatus.INFO,"User logged in successfully");
		logger.info("login information has been done successfully");
	}
	public void SelectFlightType()
	{
		for (WebElement ele: flighttype) {
			if(ele.getAttribute("value").equalsIgnoreCase("oneway"))
			{
				ele.click();
				break;
			}
		}
	logger.info("Filght type has been selected successfully");		
	PagefactoryBase.Test.log(LogStatus.INFO,"Flight type selected successfully");
	}
	
	public void selectFromAirport()
	{
		Select fromportdrp=new Select(fromport);
		fromportdrp.selectByVisibleText("London");
		PagefactoryBase.Test.log(LogStatus.INFO,"Departing airport selected successfully");
		logger.info("Departing airport selected");
	}
	
	public void selectDepartingDate()
	{
		Select frommonth=new Select(fromMonth);
		Select fromday=new Select(fromDay);
		frommonth.selectByVisibleText("August");
		fromday.selectByVisibleText("31");
		PagefactoryBase.Test.log(LogStatus.INFO,"Departure date selected successfully");
		logger.info("Departure date selected");
	}
	
	public void selectToAirport()
	{
		Select toportdrp=new Select(toport);
		toportdrp.selectByVisibleText("Seattle");
		PagefactoryBase.Test.log(LogStatus.INFO,"Arrival airport selected successfully");
		logger.info("Arrival airport selected");
	}
	
	public void selectArrivalDate()
	{
		Select tomonth=new Select(toMonth);
		Select today=new Select(toDay);
		tomonth.selectByVisibleText("November");
		today.selectByVisibleText("15");
		PagefactoryBase.Test.log(LogStatus.INFO,"Arrival date selected successfully");
		logger.info("Arrival date selected");
	}
	
	public void pressContinueButton()
	{
		Continuebutton.click();
	}

}
