package BaseSetup;

import DataReaderSetup.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.IOException;
import java.time.Duration;

public class Makemytrip_SingletonBaseClass {

    private static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<>();

    private Makemytrip_SingletonBaseClass(){
        System.out.println("Singleton baseclass initialised");
    }

    public static WebDriver getInstance(){
       return driverInstance.get();
    }

     public static void webDriverInstanceSetup() throws IOException {
         if (driverInstance.get()==null){
             if (PropertiesReader.getbrowser().equalsIgnoreCase("chrome")){
                 ChromeOptions chromeOptions=new ChromeOptions();
                 chromeOptions.addArguments("--disable-infobars");
                 chromeOptions.addArguments("--kiosk");
                 chromeOptions.addArguments("--disable-notifications");
                 driverInstance.set(new ChromeDriver());
                 driverInstance.get().manage().deleteAllCookies();
                 System.out.println("Chrome instance created");
             }

             else if (PropertiesReader.getbrowser().equalsIgnoreCase("firefox")){
                 driverInstance.get().manage().window().maximize();
                 driverInstance.set(new FirefoxDriver());
                 driverInstance.get().manage().deleteAllCookies();
                 System.out.println("Firefox instance created");
             }
             driverInstance.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
             driverInstance.get().get(PropertiesReader.geturl()); //define url from properties file
         }
     }

     public static void webDriverInstanceTearDown(){
         if (driverInstance!=null){
             driverInstance.get().quit();
             System.out.println("Instance has been destroyed");
             driverInstance=null;
         }
     }
 }
