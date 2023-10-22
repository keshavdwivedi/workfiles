package com.propertiesReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	static File propertiesfile=new File(System.getProperty("user.dir")+"/configurations/config.properties");
    static FileInputStream fis;
    static Properties prop=new Properties();
    
    public static String getUser() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("User");
    }
    
    public static String getbrowser() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("Browser");
    }
    
    public static String geturl() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("url");
    }
    
    public static String getreportpath() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("reportpath");
    }
    
    public static String getfirstname() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("firstname");
    }
    
    public static String getlastname() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("lastname");
    }
    
    public static String getphone() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("phone");
    }
    
    public static String getemail() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("email");
    }
    
    public static String getaddress() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("address");
    }
    
    public static String getcity() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("city");
    }
    
    public static String getstate() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("state");
    }
    
    public static String getpincode() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("pincode");
    }
    
    public static String getusername() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("username");
    }
    
    public static String getpassword() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("password");
    }
    
    
    
    
    
 
    
}
