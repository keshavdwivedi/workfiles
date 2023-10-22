package com.parellelFramework.utilities;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.io.File;
import java.io.IOException;

public class CommonUtils {

    public static boolean verifyElement(WebElement element,String expectedText){

        boolean flag=false;

        if (element.isDisplayed() && element.isEnabled()){
            flag=true;
            String actualText=element.getText();
            Assert.assertEquals(actualText,expectedText);
            System.out.println("The text of element verified is "+actualText);
        }
        return flag;
    }

    public static String decodePassword(String password){
        byte[] decodedString= Base64.decodeBase64(password);
        return (new String(decodedString));
    }

    public static String TakeScreenshot(String screenShotName,WebDriver driver) {

        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String srcimage=System.getProperty("user.dir")+"/Screenshots/"+screenShotName+".png";
        File destinationPath = new File(srcimage);
        try {
            FileUtils.copyFile(src,destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return srcimage;

    }
}
