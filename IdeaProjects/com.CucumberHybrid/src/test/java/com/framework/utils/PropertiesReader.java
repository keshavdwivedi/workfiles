package com.framework.utils;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

    Properties prop;

    public PropertiesReader(){
        try{
            prop=new Properties();
            prop.load(new FileInputStream(System.getProperty("user.dir")+ "/src/main/resources/Configurations/Setup.properties"));

        }
        catch (Exception e){e.getMessage();}
    }

    public String getBrowsername(){
        return prop.getProperty("browser");
    }

    public String getUrl(){
        return prop.getProperty("siteURL");
    }


}
