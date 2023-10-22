package com.parellelFramework.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class BrowserFactory {

    public static WebDriver createInstance(String browser) {

        WebDriver driver = null;
        ChromeOptions chromeOptions;
        FirefoxProfile profile;
        FirefoxOptions options;
        SafariOptions safariOptions;

        try {

            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--disable-extensions");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--disable-notifications");
                driver = new ChromeDriver(chromeOptions);
            } else if (browser.equalsIgnoreCase("firefox")) {

                WebDriverManager.firefoxdriver().setup();
                options = new FirefoxOptions();
                profile = new FirefoxProfile();
                profile.setPreference("extensions.logging.enabled", false);
                profile.setAcceptUntrustedCertificates(true);
                profile.setAssumeUntrustedCertificateIssuer(false);
                options.setProfile(profile);
                driver = new FirefoxDriver(options);

            } else if (browser.equalsIgnoreCase("safari")) {

                safariOptions = new SafariOptions();
                safariOptions.setUseTechnologyPreview(true);
                driver = new SafariDriver(safariOptions);
            }

            driver.manage().window().maximize();


        } catch (Exception e) {

            e.printStackTrace();
        }

        return driver;
    }

}
