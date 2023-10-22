package com.Hybrid_framework.BaseSetup;

import com.Hybrid_framework.Utilities.CustomUtility;
import com.Hybrid_framework.Utilities.PropertiesReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import org.apache.log4j.Logger;

public class Baseclass {

    public ExtentHtmlReporter htmlreporter;
    public ExtentReports extent;
    public ExtentTest testlogger;
    public WebDriver driver;
    public static final Logger logger =Logger.getLogger(Baseclass.class);

    //setup the report and its properties

    @BeforeSuite
    public void setReport(){

       // htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExecutionReports/extent-"+CustomUtility.getCurrentDateTime()+".html");
        htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExecutionReports/extent.html");
        htmlreporter.config().setDocumentTitle("Automation Test Report"); // Tile of report
        htmlreporter.config().setReportName("IB Functional Testing Report"); // Name of the report
        htmlreporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlreporter);
        extent.setSystemInfo("User name",System.getProperty("user.name"));
        extent.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        extent.setSystemInfo("User Location", System.getProperty("user.country"));
        extent.setSystemInfo("OS name", System.getProperty("os.name"));
        extent.setSystemInfo("OS version", System.getProperty("os.version"));
        extent.setSystemInfo("JDK version",System.getProperty("java.version"));
        extent.setSystemInfo("Maven version", PropertiesReader.fetchPropertyValue("Maven"));
        extent.setSystemInfo("Selenium version", PropertiesReader.fetchPropertyValue("SeleniumVersion"));
    }

    //ends the test logs in the report

    @AfterSuite
    public void endReport(){
        extent.flush();
    }

    //this method is used to setup test execution environment by supplying the driver passed on from properties file.

    @BeforeTest
    public void setupEnv(){
        driver= BrowserSetup.LaunchBrowser(driver, PropertiesReader.fetchPropertyValue("Browser"), PropertiesReader.fetchPropertyValue("Url"));
    }

    //this method is used to teardown the test execution environment

    @AfterTest
    public void closeEnv(){
        BrowserSetup.Teardown(driver);

    }

    //evaluates the status of each test case

    @AfterMethod
    public void evaluateStatus(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) {

            testlogger.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
            testlogger.log(Status.FAIL, "TEST CASE ERROR IS " + result.getThrowable());
            logger.info("The test case failed is "+result.getName());
            String screenshotpath=CustomUtility.captureScreenshot(driver,result.getName());
            testlogger.fail("Test case has failed screenshot is below ", MediaEntityBuilder.createScreenCaptureFromPath(screenshotpath).build());

            System.out.println(screenshotpath);
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            testlogger.log(Status.PASS, "Test Case Passed is " + result.getName());
            logger.info("The test case passed is "+result.getName());
        }
        else if(result.getStatus()==ITestResult.STARTED){
            testlogger.log(Status.INFO,"Execution of Test case "+result.getName()+"has been started");
            logger.info("Execution of Test case "+result.getName()+"has been started");
        }
     }
  }
