package com.pageobjects;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
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

public class Registration {
	
	WebDriver localdriver;
	String str="http://newtours.demoaut.com/create_account_success.php";
	String expectedtext="srikant chaturvedi";
	
	public Registration(WebDriver driver) {
		this.localdriver=driver;
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/configurations/log4j.properties");
	}
	public final Logger logger=Logger.getLogger(Registration.class.getName());
	@FindBy(how=How.LINK_TEXT,using="REGISTER") @CacheLookup public WebElement registerlink;
	@FindBy(how=How.CSS,using="input[name*='first']") @CacheLookup public WebElement firstname;
	@FindBy(how=How.CSS,using="input[name*='last']") @CacheLookup public WebElement lastname;
	@FindBy(how=How.NAME,using="phone") @CacheLookup public WebElement phoneno;
	@FindBy(how=How.ID,using="userName") @CacheLookup public WebElement email;
	@FindBy(how=How.NAME,using="address1") @CacheLookup public WebElement address;
	@FindBy(how=How.NAME,using="city") @CacheLookup public WebElement city;
	@FindBy(how=How.NAME,using="state") @CacheLookup public WebElement state;
	@FindBy(how=How.NAME,using="postalCode") @CacheLookup public WebElement postalcode;
	@FindBy(how=How.NAME,using="country") @CacheLookup public WebElement country;
	@FindBy(how=How.ID,using="email") @CacheLookup public WebElement username;
	@FindBy(how=How.NAME,using="password") @CacheLookup public WebElement password;
	@FindBy(how=How.NAME,using="confirmPassword") @CacheLookup public WebElement confirmpassword;
	@FindBy(how=How.XPATH,using="//input[@name='submit']") @CacheLookup public WebElement submitbutton;
	@FindBy(how=How.CSS,using="img[src='/images/masts/mast_register.gif']") @CacheLookup public WebElement image;
	
	public void clickregisterlink()
	{
		PagefactoryBase.implicitlywait(3);
		registerlink.click();
	}
	
	public void checkregisterpagetitle(String title)
	{
		Assert.assertEquals(localdriver.getTitle(),title,"The title of registration page is not matching");
		PagefactoryBase.Test.log(LogStatus.INFO,"Title of register page validated");
		logger.info("Registration page title checked");
	}
	
	public void checkregisterpageimage()
	{
		boolean bool=image.isDisplayed();
		if(bool)
//		PagefactoryBase.Test.log(LogStatus.INFO,"Register image is displayed");
		logger.info("Register page image has been validated");
	}
	
	public void blanksubmit()
	{
		submitbutton.click();
		//PagefactoryBase.Test.log(LogStatus.INFO,"blank submit on registration page is done successfully");
		logger.info("Blank submit on registration page is done");
	}
	
	public void submitbyentername(String fname,String lname) throws IOException
	{
	    Entername(fname,lname);
		submitbutton.click();
		checksuccessmessage();
		//PagefactoryBase.Test.log(LogStatus.INFO,"submit by entering name is done successfully");
		logger.info("submit by entering name is done");
	}
	
	public void submitbyenteringcontactinformation(String fname,String lname) throws IOException
	{
		Entername(fname,lname);
		EnterphoneandEmail();
		submitbutton.click();
		checksuccessmessage();
		//PagefactoryBase.Test.log(LogStatus.INFO,"submit by entering contact information is done successfully");
	}
	
	public void submitbyenteringcontactandMailingdetails(String fname,String lname) throws IOException
	{
		Entername(fname,lname);
		EnterphoneandEmail();
		Entermailingdetails();
	    submitbutton.click();
	    checksuccessmessage();
	   //PagefactoryBase.Test.log(LogStatus.INFO,"submit by entering contact information and mailing details is done successfully");
	   logger.info("submit by entering contact information and mailing details is done successfully");
	}
	
	public void checksuccessmessage()
	{
		if(localdriver.getCurrentUrl().equalsIgnoreCase(str))
		{
			String bodyText = localdriver.findElement(By.tagName("body")).getText();
			Assert.assertTrue(bodyText.contains(expectedtext),"Text not found");
			logger.info("Registration URL has been validated successfully");
		}
	}
	
	public void Entername(String fname,String lname) throws IOException
	{
		firstname.clear();
		lastname.clear();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
	}
	
	public void EnterphoneandEmail() throws IOException
	{
		phoneno.clear();
		email.clear();
		phoneno.sendKeys(PropertiesReader.getphone());
		email.sendKeys(PropertiesReader.getemail());
	}
	
	public void Entermailingdetails() throws IOException
	{
		address.clear();
		city.clear();
		state.clear();
		state.clear();
		postalcode.clear();
		address.sendKeys(PropertiesReader.getaddress());
		city.sendKeys(PropertiesReader.getcity());
		state.sendKeys(PropertiesReader.getstate());
		postalcode.sendKeys(PropertiesReader.getpincode());
	    Select drp=new Select(country);
	    drp.selectByVisibleText("INDIA");
	}
	
	public void submitbyEnteringallinformation(String fname,String lname) throws IOException
	{
		Entername(fname,lname);
		EnterphoneandEmail();
		Entermailingdetails();
		EnterUserinformation();
		submitbutton.click();
		checksuccessmessage();	
		PagefactoryBase.Test.log(LogStatus.INFO,"All the data for registration page submitted successfully");
	}
	
	public void EnterUserinformation() throws IOException
	{
		username.sendKeys(PropertiesReader.getusername());
		String pwd=PagefactoryBase.decodepassword(PropertiesReader.getpassword());
		password.sendKeys(pwd);
		confirmpassword.sendKeys(pwd);
	}
	
    
	
	
	
	
	
	
	
	
	
	
}



