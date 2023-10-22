package com.Hybrid_framework.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

    static Properties prop;

    //custom method to read any propertyvalue from the properties file

    public static String fetchPropertyValue(String key) {
        try{
            File propFile = new File(System.getProperty("user.dir") + "/Configuration/config.properties");
            FileInputStream fis = new FileInputStream(propFile);
            prop = new Properties();
            prop.load(fis);
        }catch (Exception e){
            System.out.println("The exception occurred in reading file is "+e.getMessage());
        }
        return prop.getProperty(key);
    }
  }

