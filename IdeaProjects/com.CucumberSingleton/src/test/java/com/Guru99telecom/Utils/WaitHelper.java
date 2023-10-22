package com.Guru99telecom.Utils;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitHelper {

    public static WebDriverWait wait;

    public static void implicitWait(WebDriver driver, long implicitwait){
        driver.manage().timeouts().implicitlyWait(implicitwait, TimeUnit.SECONDS);
    }

    public static void setPageLoadTimeout(WebDriver driver,long time)
    {
        driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
    }

    public static void expectedWait(WebDriver driver, long waitTime, WebElement element, String conditiontxt){
        wait=new WebDriverWait(driver,waitTime);
        if(conditiontxt.equalsIgnoreCase("visibility"))
        {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        else if (conditiontxt.equalsIgnoreCase("clickable")){
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
    }

    public static String decodePassword(String password){
        byte[] decodedString= Base64.decodeBase64(password);
        return (new String(decodedString));
    }

}
