package com.parellelFramework.tests;

import com.parellelFramework.base.BrowserFactory;
import com.parellelFramework.base.DriverFactory;
import com.parellelFramework.utilities.PropertiesFileReader;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestSetup {

    public WebDriver driver = null;
    PropertiesFileReader propertiesFileReaderObject;
    public static Logger logger;

    @BeforeTest
    public void setTestParameters(){
        propertiesFileReaderObject=new PropertiesFileReader();
    }

    @BeforeClass
    @Parameters({"browserName"})
   public void prepareTest(String browser) {

        driver = BrowserFactory.createInstance(browser);
        DriverFactory.getInstance().setDriver(driver);
        driver = DriverFactory.getInstance().getDriver();
    }

    @AfterClass
   public void endTest() {
        DriverFactory.getInstance().removeDriver();
    }

}


