package com.Singleton.pageobjects;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.base.Helper;
import com.base.PropertiesReader;
import com.relevantcodes.extentreports.LogStatus;

public class SignupPageTwo {
	
	SignupPageOne obj;
	Homepage hobj;
	
	public SignupPageTwo(WebDriver localdriver) {
		Helper.Instance=localdriver;
		Helper.logger= LogManager.getLogger(getClass().getName());
	}
	
	@FindBy(how=How.CSS,using="h1.page-heading")
	@CacheLookup public WebElement createacc_heading;
	
	@FindBy(how=How.CSS,using="input#customer_firstname")
	@CacheLookup public WebElement firstname;
	
	@FindBy(how=How.CSS,using="input#customer_lastname")
	@CacheLookup public WebElement lastname;
	
	@FindBy(how=How.CSS,using="input#passwd")
	@CacheLookup public WebElement password;
	
	@FindBy(how=How.ID,using="days")
	@CacheLookup public WebElement dob_day;
	
	@FindBy(how=How.ID,using="months")
	@CacheLookup public WebElement dob_month;
	
	@FindBy(how=How.ID,using="years")
	@CacheLookup public WebElement dob_year;
	
	@FindBy(how=How.ID,using="address1")
	@CacheLookup public WebElement address;
	
	@FindBy(how=How.ID,using="city")
	@CacheLookup public WebElement city;
	
	@FindBy(how=How.ID,using="id_state")
	@CacheLookup public WebElement state;
	
	@FindBy(how=How.ID,using="postcode")
	@CacheLookup public WebElement postalcode;
	
	@FindBy(how=How.ID,using="phone_mobile")
	@CacheLookup public WebElement mobile;
	
	@FindBy(how=How.ID,using="submitAccount")
	@CacheLookup public WebElement registerbutton;
	
	@FindBy(how=How.CSS,using="a.logout")
	@CacheLookup public WebElement logoutbutton;
	
	public void checksignupheading()
	{
		Assert.assertTrue(createacc_heading.isDisplayed(),"heading not present");
		Helper.logger.info("Signup form page heading has been verified");
	}
	
	public void fillsignupform1()
	{
		((JavascriptExecutor)Helper.Instance).executeScript("arguments[0].scrollIntoView();",password);
		selectgender();
		firstname.sendKeys("Amit");
		lastname.sendKeys("gupta");
		checkpassword();
		selectdob();
		Helper.logger.info("Signup form page till date of birth has been verified");
	}
	
	public void fillsignupform2()
	{
		address.sendKeys("1 babur road");
		city.sendKeys("Kansas city");
		((JavascriptExecutor)Helper.Instance).executeScript("arguments[0].scrollIntoView();",registerbutton);
		Select Sstate=new Select(state);
		Sstate.selectByVisibleText("Kansas");
		postalcode.sendKeys("12345");
		mobile.sendKeys("9876543210");
		registerbutton.click();
		Helper.Instance.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		logoutbutton.click();
		Helper.test.log(LogStatus.INFO,"signup form has been verified and submitted successfully");
		Helper.logger.info("Signup form page till the end has been verified");
	}
	
	public void entersignupemail() throws IOException
	{
		obj=PageFactory.initElements(Helper.Instance,SignupPageOne.class);
		//obj.signup_email.sendKeys(emailid);
		obj.signup_email.sendKeys(PropertiesReader.getsignupemail());
		obj.signupbutton.click();
	}
	
	public void inithomepage()
	{
		hobj=PageFactory.initElements(Helper.Instance,Homepage.class);
		hobj.clicksignin();
	}
	
	public void selectgender()
	{
		List<WebElement>genderlist=Helper.Instance.findElements(By.xpath("//input[@name='id_gender']"));
		for (WebElement ele : genderlist) {
			if(ele.getText().equalsIgnoreCase("Mr.")&& !(ele.isSelected()))
			{
				ele.click();
				break;
			}	
		}
	}
	
	public void selectdob()
	{
		Select sdays=new Select(dob_day);
		sdays.selectByValue("10");
		
		Select smonth=new Select(dob_month);
		smonth.selectByValue("5");
		
		Select syear=new Select(dob_year);
		syear.selectByValue("1990");
	}
	
	public void checkpassword()
	{
		WebElement check=null;
		List<WebElement>passwordlist=Helper.Instance.findElements(By.id("passwd"));
		for (WebElement we : passwordlist) {
			if(we.isDisplayed())
			{
				check=we;
				break;
			}
		}
		if(check!=null)
		{
			check.sendKeys("123456");
		}
		
		else
		{
			System.out.println("element not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
