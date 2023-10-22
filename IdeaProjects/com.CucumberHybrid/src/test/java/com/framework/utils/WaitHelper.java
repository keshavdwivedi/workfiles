package com.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    public static void setwaitTime(WebDriver driver, long time, WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,time);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
