package basehelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadpropertiesFile {
	
	static File propertiesfile=new File(System.getProperty("user.dir")+"/Configurations/Driverconfig.properties");
    static FileInputStream fis;
    static Properties prop=new Properties();
    
    public static String getUser() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("User");
    }
    
    public static String getURL() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("URL");
    }
    
    public static String getBrowser() throws IOException
    {
    	fis=new FileInputStream(propertiesfile);
    	prop.load(fis);
    	return prop.getProperty("Browser");
    }
}
