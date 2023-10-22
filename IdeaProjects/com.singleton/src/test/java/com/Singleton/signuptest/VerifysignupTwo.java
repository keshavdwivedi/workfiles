package com.Singleton.signuptest;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.Singleton.pageobjects.SignupPageTwo;
import com.base.Helper;
import com.testsetup.TestSetup;

public class VerifysignupTwo extends TestSetup {
	
	//@Test(dataProviderClass=ExcelDataProviders.class,dataProvider="LoginData")
	@Test
	public void checksignupform() throws IOException, InterruptedException
	{
		SignupPageTwo signuptwoobj=PageFactory.initElements(Helper.Instance,SignupPageTwo.class);
		signuptwoobj.inithomepage();
		signuptwoobj.entersignupemail();
		signuptwoobj.checksignupheading();
		signuptwoobj.fillsignupform1();
		signuptwoobj.fillsignupform2();	
	}

}
