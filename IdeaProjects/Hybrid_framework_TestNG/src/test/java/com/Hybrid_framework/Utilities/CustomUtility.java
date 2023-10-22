package com.Hybrid_framework.Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomUtility implements IRetryAnalyzer, IAnnotationTransformer {

    int counter=0;
    int retrylimit=3;



    //highlights the Webelement while taking screenshot

    public static String captureScreenshot(WebDriver driver, String screenshotName, WebElement element){

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='2px solid red'", element);
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        String dest=System.getProperty("user.dir")+"/Screenshots/" +screenshotName+CustomUtility.getCurrentDateTime() +".png";
        File finalDestinaton=new File(dest);
        try {
            FileHandler.copy(src, finalDestinaton);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dest;

    }

    //Takes screenshot by giving name supplied as String

    public static String captureScreenshot(WebDriver driver, String screenshotName) {

        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        String dest=System.getProperty("user.dir")+"/Screenshots/" +screenshotName+CustomUtility.getCurrentDateTime() +".png";
        File finalDestinaton=new File(dest);
        try {
            FileHandler.copy(src, finalDestinaton);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return dest;
    }

    //Gets current date and time of the system

     public static String getCurrentDateTime(){
         DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy-h-m-s");
         Date date = new Date();
         return dateFormat.format(date);
     }

     //get element's dimensions
     
     public int[] getDimensionofElement(WebElement element){

        int[] arr=new int[2];
        try {
            if(element.isDisplayed()){
               arr[0]= element.getSize().getHeight();
               arr[1]=element.getSize().getWidth();
            }
        }catch (Exception e)
        {System.out.println("The exception occurred while finding element is "+e.getMessage());}
        return arr;
     }

     //custom method to get element's coordinates

    public int[] getCoordinatesofElement(WebElement element){

        int[] arr =new int[2];

        try {
            if(element.isDisplayed()){
                Point p=element.getLocation();
                arr[0]=p.getX();
                arr[1]=p.getY();
            }

        }catch (Exception e){
            System.out.println("The exception occurred while finding element is "+e.getMessage());
        }
      return arr;
    }

     //two predefined methods of TestNG for executing failed testcases thrice.

    //@Override
    public boolean retry(ITestResult iTestResult) {
        if(counter<retrylimit){
            counter++;
            return true;
        }
        return false;
    }

    //@Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setRetryAnalyzer(CustomUtility.class);
    }
}
