package com.framework.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;

public class BaseSetup {

    protected static WebDriver driver=null;
    protected static PropertiesReader read;
    protected static Logger logger;

    @Before
    public void pre_setup(){
        read=new PropertiesReader();
        logger= LogManager.getLogger(getClass().getName());
    }

    public static WebDriver webdriverSetup(){

        if (driver==null){
            logger.info("New Webdriver instance invoked");
            if(read.getBrowsername().equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--disable-notifications");
                driver=new ChromeDriver(options);
                logger.info("Chrome browser instance launched successfully");
            }

            else if (read.getBrowsername().equalsIgnoreCase("safari")) {
                driver=new SafariDriver();
                logger.info("Safari browser instance launched successfully");
            }

            else if (read.getBrowsername().equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                logger.info("Firefox browser instance launched successfully");
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    @After(order = 1)
    public void checkFailScenario(Scenario scenario){

        if(scenario.isFailed()){
            try {
                scenario.log("Scenario "+scenario.getName() +" has been failed");
                CommonUtils.takeScreenShotReturnPath(driver);
                CommonUtils.embedScreenShot(scenario,driver);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        else {
            try {
                scenario.log("Scenario "+scenario.getName()+ "has been passed");
                CommonUtils.takeScreenShotReturnPath(driver);
               CommonUtils.embedScreenShot(scenario,driver);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @After(order = 0)
    public void teardown(){
        if (driver!=null){
            logger.info("Webdriver instance has been closed");
            driver.close();
            //driver.quit();
            driver=null;
        }
    }
}
