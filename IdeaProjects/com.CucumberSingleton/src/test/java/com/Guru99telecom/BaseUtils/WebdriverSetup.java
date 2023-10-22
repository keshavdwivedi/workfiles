package com.Guru99telecom.BaseUtils;
import com.Guru99telecom.Utils.PropertiesReader;
import com.Guru99telecom.Utils.WaitHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class WebdriverSetup {

    private static WebdriverSetup webdriverSetup;
    private static WebDriver driver;
    public static Logger logger;

    private WebdriverSetup(){

        String browserName=new PropertiesReader().getbrowserName();
        logger= LogManager.getLogger(getClass().getName());

        if (browserName.equalsIgnoreCase("Chrome")){
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-infobars");
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver(options);
            logger.info("New Chrome instance invoked");
        }

        else if (browserName.equalsIgnoreCase("safari")){
            driver=new SafariDriver();
            logger.info("New Safari instance invoked");
        }

        else if(browserName.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
            logger.info("New Firefox driver instance invoked");
        }

        WaitHelper.implicitWait(driver,30);
        WaitHelper.setPageLoadTimeout(driver,45);
        driver.manage().window().maximize();
    }

    public static void navigateURL(String Url){
        driver.get(Url);
        logger.info("Website has been loaded");
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void setupDriver(){
        if (webdriverSetup==null){
            webdriverSetup =new WebdriverSetup();
        }
    }


    public static void tearDownSession(){

        if (driver!=null){
            driver.close();
            //driver.quit();
            logger.info("Webdriver session terminated");
        }
        webdriverSetup=null;

    }
}
