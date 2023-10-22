package com.Singleton.pageobjects;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.base.Helper;
import com.relevantcodes.extentreports.LogStatus;

public class SignupPageOne {
	
	Homepage obj;
	public SignupPageOne(WebDriver localinstance) {
		Helper.Instance=localinstance;
		Helper.logger= LogManager.getLogger(getClass().getName());
	}
	
	@FindBy(how=How.ID,using="email_create")
	@CacheLookup public WebElement signup_email;
	
	@FindBy(how=How.ID,using="SubmitCreate")
	@CacheLookup public WebElement signupbutton;
	
	public void checksignuptitle(String str)
	{
		Assert.assertEquals(str,Helper.Instance.getTitle(),"Title of homepage does not match with expected value");
		Helper.test.log(LogStatus.INFO,"Title of the Login page has been verified");
		Helper.logger.info("Signup page title has been verified");
	}
	
	public void inithomepage()
	{
		obj=PageFactory.initElements(Helper.Instance,Homepage.class);
		obj.clicksignin();
	}
	
	public void clicksignupbutton()
	{
		signupbutton.click();
	}
	
	public void enterinvalidemail(String emailId) throws IOException
	{
		signup_email.sendKeys(emailId);
		Helper.test.log(LogStatus.INFO,"Invalid email for signup has been verified");
		Helper.logger.info("Signup functionality by entering invalid email has been verified");
	}
	
	public void entervalidemail(String emailID) throws IOException
	{
		signup_email.sendKeys(emailID);
		Helper.test.log(LogStatus.INFO,"Valid email for signup has been verified");
		Helper.logger.info("Signup functionality by entering valid email has been verified");
	}
	
	
	

}
