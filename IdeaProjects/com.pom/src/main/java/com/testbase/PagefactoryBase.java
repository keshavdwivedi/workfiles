package com.testbase;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import com.propertiesReader.PropertiesReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class PagefactoryBase {
	
	static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest Test;
	
	@BeforeSuite
	public void reportsetup() throws IOException
	{
		extent=new ExtentReports(System.getProperty("user.dir")+PropertiesReader.getreportpath()+"Test-report.html",true);
		extent.addSystemInfo("User Name",System.getProperty("user.name"));
		extent.addSystemInfo("Time Zone", System.getProperty("user.timezone"));
		extent.addSystemInfo("User Location", System.getProperty("user.country"));
		extent.addSystemInfo("OS version", System.getProperty("os.version"));
		extent.addSystemInfo("Selenium","3.10.0");
		extent.addSystemInfo("Maven","3.5.0");
		extent.addSystemInfo("Java Version",System.getProperty("java.version"));
		extent.addSystemInfo("Browser used",PropertiesReader.getbrowser());
		extent.loadConfig(new File(System.getProperty("user.dir")+"/configurations/reportformat.xml"));
	}
	public static WebDriver startbrowser() throws IOException
	{
		if(driver==null)
		{
			System.out.println("Browser Instance Created");
			if(PropertiesReader.getbrowser().equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromiumdriver().setup();
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--disable-notifications");
				options.addArguments("--start-maximized");
				DesiredCapabilities cap=new DesiredCapabilities();
				cap.setPlatform(Platform.WIN10);
				driver=new ChromeDriver(options);
				System.out.println("Chrome driver instance initialized");
			}
			
			else if(PropertiesReader.getbrowser().equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				DesiredCapabilities cap=new DesiredCapabilities();
				cap.setPlatform(Platform.WIN10);
				driver=new FirefoxDriver();
				System.out.println("Firefox instance initialized");
			}
		}
		else if (PropertiesReader.getbrowser().equalsIgnoreCase("safari")){
			driver=new SafariDriver();
			System.out.println("Safari instance initialized");
		}
		driver.manage().window().maximize();
		driver.get(PropertiesReader.geturl());
		implicitlywait(4);
		return driver;
	}
	
	public static void implicitlywait(long time)
	{
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	 
	 @AfterTest
	 public void teardown()
	 {
		if(driver!=null)
		{
			driver.close();
			driver=null;
		}
		
		System.out.println("Browser instance Closed");
		
	 }
	 
	 @AfterSuite
	 public void reportend()
	 {
		 extent.flush();
		 extent.endTest(Test);
		 driver.close();
	 }
	 
	 public static WebDriver getbaseclassdriver()
	 {
		 return driver;
	 }
	 
	 public static String decodepassword(String pword)
		{
			byte[] decodedpassword= Base64.getDecoder().decode(pword.getBytes());
			return new String(decodedpassword);
		}
	
	 
	 
}
