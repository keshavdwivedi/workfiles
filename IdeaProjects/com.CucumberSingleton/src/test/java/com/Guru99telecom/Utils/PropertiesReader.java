package com.Guru99telecom.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

    Properties prop;

    public PropertiesReader(){

        try {

            prop=new Properties();
            prop.load(new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Configurations/setup.properties"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getbrowserName(){
        return prop.getProperty("Browser");
    }

    public String getAppURL(){
        return prop.getProperty("URL");
    }
 }
