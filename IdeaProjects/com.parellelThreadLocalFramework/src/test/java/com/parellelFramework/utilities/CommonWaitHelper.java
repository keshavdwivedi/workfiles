package com.parellelFramework.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CommonWaitHelper {

    private static WebDriverWait wait;

    public static void setImplicitWait(WebDriver driver,long implicitWait){
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
    }

    public static void setPageLoadTimeout(WebDriver driver,long pageLoadTime){
        driver.manage().timeouts().pageLoadTimeout(pageLoadTime,TimeUnit.SECONDS);
    }

    public static void setScriptSleepTime(long sleepTime){

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 }


