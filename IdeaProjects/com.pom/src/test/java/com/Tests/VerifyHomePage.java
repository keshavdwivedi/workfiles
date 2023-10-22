package com.Tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pageobjects.Homepage;
import com.testbase.PagefactoryBase;

public class VerifyHomePage {
	
	String title="Welcome: Mercury Tours";
	
	@Test(description="This test will check Webelements on homepage of Website")
	public void checkhomepage() throws Exception
	{
		WebDriver driver=PagefactoryBase.startbrowser();
		Homepage homeobj=PageFactory.initElements(driver, Homepage.class);
		homeobj.checklogo();
		homeobj.checkhomepagetitle(title);
		homeobj.checkurl();
		homeobj.checklinks();	
	}

}
