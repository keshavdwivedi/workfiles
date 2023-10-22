package Utilities;

import BaseSetup.Makemytrip_SingletonBaseClass;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CommonUtilties {

    private static WebDriverWait wait=new WebDriverWait(Makemytrip_SingletonBaseClass.getInstance(), Duration.ofSeconds(30));

    public static String decryptPassword(String password){
        byte[] decryptedBytes= Base64.decodeBase64(password);
        return (new String(decryptedBytes));
    }

    public static void waitForElementTobeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementTobeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void takeWebScreenshot(String screenshotName) {
        TakesScreenshot ts=((TakesScreenshot)(driver));
        File src=ts.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(src,new File("./target/"+screenshotName+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeWebScreenshot(WebElement element,String screenshotName){
        File srcFile= element.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(srcFile,new File("./target/"+screenshotName+".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
