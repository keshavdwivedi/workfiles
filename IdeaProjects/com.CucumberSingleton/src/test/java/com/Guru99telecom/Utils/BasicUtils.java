package com.Guru99telecom.Utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class BasicUtils {

    public static int generateInteger(int minval,int maxval){
        return RandomUtils.nextInt(minval,maxval);
    }

    public static String generateString(int length){
        return (RandomStringUtils.randomAlphanumeric(length));
    }

    public static Alert switchValidationAlert(WebDriver driver){

        try {
            return driver.switchTo().alert();
          }
        catch (NoAlertPresentException e){
            System.out.println("No alert found");
            return null;
        }
    }


    public static String handleAlert(Alert alert,WebDriver driver){

        String alertText = null;
        
        if (alert!=null){
            alertText=alert.getText();
            alert.accept();
            try{

                driver.switchTo().alert();
                System.out.println("Alert still present even after acceptance");
            }catch (NoAlertPresentException e){

                System.out.println("Alert closed after acceptance successfully");

            }
        }
        return alertText;
    }

    public static  String takeScreenShotReturnPath(WebDriver driver) throws IOException {
        String screenShotFolder=System.getProperty("user.dir")+"/target/Screenshots/";
        Date date= new Date();
        long time=date.getTime();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String imagePath=screenShotFolder  + time+".png";
        FileUtils.copyFile(scrFile, new File(imagePath));
        return imagePath;
    }

    public static void embedScreenShot(Scenario scenario, WebDriver driver){
        final byte[] screenshot =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png",scenario.getName()); // stick it in the report

    }

    public static void checkTitle(WebDriver driver, String expectedTitle){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(driver.getTitle(),expectedTitle);
        System.out.println("The page title verified is "+driver.getTitle());
    }

    public static boolean validateWebelement(WebElement element){
        boolean status=false;
        if (element.isDisplayed() && element.isEnabled()){
            status=true;
        }
        return status;
    }

    public static boolean validateWebelement(WebElement element,String expectedEleTxt){
        boolean status=false;
        if(element.isDisplayed() && element.isEnabled()){
            status=true;
            Assert.assertEquals(element.getText(),expectedEleTxt);
        }
        return status;
    }



}
