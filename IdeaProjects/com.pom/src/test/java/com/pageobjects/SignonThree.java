package com.pageobjects;

import java.util.List;

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

public class SignonThree {
	
WebDriver localdriver;
	
	public SignonThree(WebDriver driver) {
		this.localdriver=driver;
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/configurations/log4j.properties");
	}
	
	@FindBy(how=How.XPATH,using="//input[@name='outFlight']")@CacheLookup public List<WebElement> Departureairline;
	@FindBy(how=How.XPATH,using="//input[@name='inFlight']")@CacheLookup public List<WebElement> Returnairline;
	@FindBy(how=How.XPATH,using="//img[@src='/images/masts/mast_selectflight.gif']")@CacheLookup public WebElement SelectFlightlogo;
	@FindBy(how=How.XPATH,using="//input[@name='reserveFlights']")@CacheLookup public WebElement Continuebutton;
	public final Logger logger=Logger.getLogger(SignonThree.class.getName());
	
	public void checkheadingforthirdpage()
	{
		Assert.assertTrue(SelectFlightlogo.isDisplayed(),"Select Flight logo not present");
		PagefactoryBase.Test.log(LogStatus.INFO," Select Flight logo is displayed successfully");
		logger.info("Checked heading for third page");
		
	}
	
	public void selectdepartingAirline()
	{
		for(WebElement ele: Departureairline) {
			
			if(ele.getAttribute("value").equalsIgnoreCase("Pangea Airlines$362$274$9:17"))
			{
				ele.click();
				break;
			}
			PagefactoryBase.Test.log(LogStatus.INFO,"Departure Flight selected successfully");
		}
		
		logger.info("Departing airline selected");
	}
	
	public void selectReturnAirline()
	{
		for (WebElement ele :Returnairline) {
			if(ele.getAttribute("value").equalsIgnoreCase("Blue Skies Airlines$631$273$14:30"))
			{
				ele.click();
				break;
			}
			
			PagefactoryBase.Test.log(LogStatus.INFO,"Arrival Flight selected successfully");
		}
		
		logger.info("Returning airline selected");
	}
	
	public void clickcontinuebutton()
	{
		Continuebutton.click();
	}
	

}
