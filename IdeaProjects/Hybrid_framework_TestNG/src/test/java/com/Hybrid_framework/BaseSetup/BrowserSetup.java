package com.Hybrid_framework.BaseSetup;

import com.Hybrid_framework.Utilities.PreConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserSetup {

    //method to setup the browser as per value passed from properties file

    public static WebDriver LaunchBrowser(WebDriver driver, String browser, String Appurl){

        if(driver==null){

            System.out.println("Browser instance created");
            if(browser.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--disable-infobars");
                driver=new ChromeDriver(options);
                System.out.println("Chrome driver instance initialized");
            }

            else if(browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addPreference("dom.webnotifications.enabled", false);
                options.addPreference("dom.disable_beforeunload", true);
                System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new FirefoxDriver(options);
                System.out.println("Firefox instance initialized");
            }

            else if (browser.equalsIgnoreCase("Safari")){
                driver=new SafariDriver();
                System.out.println("Safari driver instance initiated");
            }
        }

        driver.manage().window().maximize();
        driver.get(Appurl);
        PreConfigUtils.implicitWait(driver,30);
        return driver;
    }

    //method to close the browser

    public static void Teardown(WebDriver driver){
        if(driver!=null)
        {
            driver.quit();
            driver=null;
        }
        System.out.println("Browser instance Closed");
    }

}
