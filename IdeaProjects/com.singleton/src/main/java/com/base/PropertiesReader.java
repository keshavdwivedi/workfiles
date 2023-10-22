package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	static File f=new File(System.getProperty("user.dir")+"/appconfig/config.properties");
	static FileInputStream fis;
	static Properties pro=new Properties();
	
	public static String getUser() throws IOException
	{
		fis=new FileInputStream(f);
		pro.load(fis);
		return pro.getProperty("User");
	}
	
	public static String geturl() throws IOException
	{
		fis=new FileInputStream(f);
		pro.load(fis);
		return pro.getProperty("URL");
	}
	
	public static String getbrowser() throws IOException
	{
		fis=new FileInputStream(f);
		pro.load(fis);
		return pro.getProperty("browser");
	}
	
	public static String getsignupemail() throws IOException
	{
		fis=new FileInputStream(f);
		pro.load(fis);
		return pro.getProperty("email");
	}
	
}
