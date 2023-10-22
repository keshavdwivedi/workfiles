package com.testsetup;

import java.io.File;
import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import com.base.Helper;
import com.base.PropertiesReader;

public class TestSetup {

	@BeforeClass
	public void Setup() throws IOException
	{
		Helper.driversetUp();
	}
	
	@AfterClass
	public void destroytest()
	{
		Helper.teardown();
	}
	
	@BeforeTest
	public void reportsetup() throws IOException
	{
		Helper.extent.addSystemInfo("Project Name","Singleton pattern Project");
		Helper.extent.addSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Helper.extent.addSystemInfo("User Location", System.getProperty("user.country"));
		Helper.extent.addSystemInfo("OS version", System.getProperty("os.version"));
		Helper.extent.addSystemInfo("Java Version", System.getProperty("java.version"));
		Helper.extent.addSystemInfo("Maven","3.5.0");
		Helper.extent.addSystemInfo("Browser used",PropertiesReader.getbrowser());
		Helper.extent.loadConfig(new File(System.getProperty("user.dir")+"/appconfig/format.xml"));
	}
	
	@AfterTest
	public void Endreport()
	{
		Helper.extent.endTest(Helper.test);
		Helper.extent.flush();
	}
}
