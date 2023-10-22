package com.Singleton.hompageTest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Singleton.pageobjects.Homepage;
import com.base.Helper;
import com.testsetup.TestSetup;

public class VerifyHomepage extends TestSetup {
	
   
   @Test
   public void checkHomepage()
   {
	  Homepage homeobj=PageFactory.initElements(Helper.Instance,Homepage.class);
      homeobj.verifylogo();
      homeobj.verifyhomepageURL();
   }

}
