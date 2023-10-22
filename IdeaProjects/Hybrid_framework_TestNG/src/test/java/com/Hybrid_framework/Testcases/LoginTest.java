package com.Hybrid_framework.Testcases;

import com.Hybrid_framework.Pages.LoginPage;
import com.Hybrid_framework.BaseSetup.Baseclass;
import com.Hybrid_framework.DataSetup.ExcelDataProviders;
import com.Hybrid_framework.Utilities.MyScreenRecorder;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginTest extends Baseclass {
	
	@Test(dataProvider="PlacesData",dataProviderClass=ExcelDataProviders.class)
	public void searchtext(String text,String address) {
		 LoginPage login = PageFactory.initElements(driver, LoginPage.class);
         MyScreenRecorder.startRecording(this.getClass().getName());
         testlogger=extent.createTest("Login test");
         login.fillsearchText(text);
         login.selectKeyword(address);
         try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         login.clearsearchField();
         testlogger.info("Test has been complete");
         MyScreenRecorder.stopRecording();
	}
}


