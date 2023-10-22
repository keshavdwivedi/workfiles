package com.pageobjects;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import com.propertiesReader.PropertiesReader;
import com.relevantcodes.extentreports.LogStatus;
import com.testbase.PagefactoryBase;

public class Homepage {
	
	private WebDriver localdriver;
	
	public Homepage(WebDriver driver) {
		this.localdriver=driver;
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/configurations/log4j.properties");
	}
	
	public final Logger logger=Logger.getLogger(Homepage.class.getName());
	
	
	@FindBy(how=How.CSS,using="img[src='images/logo.gif']") @CacheLookup public WebElement logo;
	@FindBy(how=How.TAG_NAME,using = "a")@CacheLookup public List<WebElement> linklist;
	
	public void checkhomepagetitle(String str)
	{
		Assert.assertEquals(localdriver.getTitle(),str,"The title of page is not as per expected result");
		PagefactoryBase.Test.log(LogStatus.INFO,"Title of homepage validated");
		logger.info("Homepage Title Checked");
	}
	
	public void checklinks()
	{
		for (WebElement ele : linklist) {
			if(ele.getAttribute("innerHTML").equalsIgnoreCase("Home")&&
					(ele.getAttribute("innerHTML").equalsIgnoreCase("Flights"))&&
					(ele.getAttribute("innerHTML").equalsIgnoreCase("Flights"))&&
					(ele.getAttribute("innerHTML").equalsIgnoreCase("Hotels"))&&
					(ele.getAttribute("innerHTML").equalsIgnoreCase("Car Rentals"))&&
					(ele.getAttribute("innerHTML").equalsIgnoreCase("Cruises"))&&
					(ele.getAttribute("innerHTML").equalsIgnoreCase("Destinations"))&&
					(ele.getAttribute("innerHTML").equalsIgnoreCase("Vacations")))
			  {
				PagefactoryBase.Test.log(LogStatus.INFO,"All elements validated on homepage");
				break;
			 }
		}
		
		logger.info("All links on homepage validated");
	}
	
	public void checkurl() throws IOException
	{
		Assert.assertEquals(localdriver.getCurrentUrl(),PropertiesReader.geturl(),"Incorrect url found");
		PagefactoryBase.Test.log(LogStatus.INFO,"URL of homepage is validated");
		logger.info("URL of website checked");
	}
	
	public void checklogo()
	{
		boolean bool=logo.isDisplayed();
		if(bool)
		{
			PagefactoryBase.Test.log(LogStatus.INFO,"Homepage logo validated");
			logger.info("Logo of website validated");
		}
	}
	
	
	
	

}
