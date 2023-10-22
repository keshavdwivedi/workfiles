package com.Singleton.signuptest;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Singleton.DataSetup.ExcelDataProviders;
import com.Singleton.pageobjects.SignupPageOne;
import com.base.Helper;
import com.testsetup.TestSetup;

public class VerifysignupOne extends TestSetup{
	
	 String title="Login - My Store";
	 SignupPageOne signupobj;
	 
	 @Test
	 public void checksignupByBlanksubmit()
	 {
		 signupobj=PageFactory.initElements(Helper.Instance,SignupPageOne.class);
		 signupobj.inithomepage();
		 signupobj.checksignuptitle(title);
		 signupobj.clicksignupbutton();
	 }
	 
	 @Test(dataProvider="SignupData",dataProviderClass=ExcelDataProviders.class)
	 public void checksignupByInvalidEmail(String email) throws IOException
	 {
		 signupobj=PageFactory.initElements(Helper.Instance,SignupPageOne.class);
		 signupobj.inithomepage();
		 signupobj.enterinvalidemail(email);
		 signupobj.clicksignupbutton();
	 }
	 
	 @Test(dataProvider="ValidSignupData",dataProviderClass=ExcelDataProviders.class)
	 public void checksignupByValidEmail(String email) throws IOException
	 {
		 signupobj=PageFactory.initElements(Helper.Instance,SignupPageOne.class);
		 signupobj.inithomepage();
		 signupobj.entervalidemail(email);
		 signupobj.clicksignupbutton();
	 }
	 
	 

}
