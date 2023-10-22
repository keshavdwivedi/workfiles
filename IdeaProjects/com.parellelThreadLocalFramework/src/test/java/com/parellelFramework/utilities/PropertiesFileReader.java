package com.parellelFramework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {

    Properties properties;

    public PropertiesFileReader()  {

        try {
            properties=new Properties();
            File srcFile=new File(System.getProperty("user.dir")+"/src/main/resources/Configuration/appConfig.properties");
            properties.load(new FileInputStream(srcFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUserName(){
        return properties.getProperty("Username");
    }

    public String getAppURL(){
        return properties.getProperty("Url");
    }

}
