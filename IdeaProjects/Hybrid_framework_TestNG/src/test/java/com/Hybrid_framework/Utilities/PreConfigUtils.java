package com.Hybrid_framework.Utilities;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class PreConfigUtils {

    private static WebDriverWait wait;

    //method for defining implicit wait

    public static void implicitWait(WebDriver driver, long implicitwait){
        driver.manage().timeouts().implicitlyWait(implicitwait, TimeUnit.SECONDS);
    }

    //method for defining pageload timeout

    public static void pageLoadTimeout(WebDriver driver,long loadtime){
        driver.manage().timeouts().pageLoadTimeout(loadtime,TimeUnit.SECONDS);
    }

    //method for giving static wait

    public static void setScriptSleep(long sleep){
        try{
            Thread.sleep(sleep);
        }catch (Exception e) {
            e.getMessage();
        }
      }

      public static void expectedWait(WebDriver driver,long waitTime, WebElement element,String conditiontxt){
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
        byte[] decodedString=Base64.decodeBase64(password);
        return (new String(decodedString));
    }
  }
