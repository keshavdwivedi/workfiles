package com.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.safari.SafariDriver;

public class Helper {

	public static WebDriver Instance;
	public static Logger logger;
	public static Platform WIN10;
	public static ExtentReports extent=new ExtentReports(System.getProperty("user.dir")+"/target/Extent-reports/Testreport.html", true);
	public static ExtentTest test;

	public static void driversetUp() throws IOException
	{
		logger= LogManager.getLogger(Helper.class.getName());
		if(Instance==null)
		{
			logger.info("Browser instance initialized");
			if(PropertiesReader.getbrowser().equalsIgnoreCase("chrome"))
			{
				logger.info("chrome instance created");
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--start-maximized");
				options.addArguments("--disable-notifications");
				WebDriverManager.chromedriver().setup();
				Instance=new ChromeDriver(options);
			}
			
			else if(PropertiesReader.getbrowser().equalsIgnoreCase("firefox"))
			{
				logger.info("firefox instance created");
				WebDriverManager.firefoxdriver().setup();
				Instance=new FirefoxDriver();
			}
			
			else 
			{
				Instance=new SafariDriver();
				logger.info("Safari instance created");
			}
			
			Instance.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			Instance.manage().window().maximize();
			Instance.get(PropertiesReader.geturl());
		}
	}
	
	public static void teardown()
	{
		if(Instance!=null)
		{
			Instance.close();
			Instance=null;
			
		}
	}
}
