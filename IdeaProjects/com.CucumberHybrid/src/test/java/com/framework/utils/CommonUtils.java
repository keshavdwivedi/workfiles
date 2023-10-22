package com.framework.utils;

import io.cucumber.java.Scenario;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class CommonUtils {

    public static String decodePassword(String password){
        byte[] decodeString= Base64.decodeBase64(password);
        return (new String(decodeString));
    }

    public static  String takeScreenShotReturnPath(WebDriver driver) throws IOException {
        String screenShotFolder=System.getProperty("user.dir")+"/target/Screenshots/";
        Date date= new Date();
        Long time=date.getTime();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String imagePath=screenShotFolder  + time+".png";
        FileUtils.copyFile(scrFile, new File(imagePath));
        return imagePath;
    }

    public static void embedScreenShot(Scenario scenario,WebDriver driver){
        final byte[] screenshot =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png",scenario.getName()); // stick it in the report

    }

    public static String generateString(){
        return (RandomStringUtils.randomAlphanumeric(30));
    }

    public static void checkTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle);
        System.out.println("The page title verified is "+driver.getTitle());
    }

    public static boolean validateWebelement(WebElement element){
        boolean status=false;
        if(element.isDisplayed() && element.isEnabled()){
            status=true;
        }
        return status;
    }
}
