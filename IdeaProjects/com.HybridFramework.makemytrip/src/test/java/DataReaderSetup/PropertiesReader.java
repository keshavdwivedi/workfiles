package DataReaderSetup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    static File src=new File(System.getProperty("user.dir")+"/src/DataFiles/BasicEnv.properties");
    static FileInputStream fis;
    static  Properties prop=new Properties();

    public static String geturl() throws IOException
    {
        fis=new FileInputStream(src);
        prop.load(fis);
        return prop.getProperty("url");
    }

    public static String getbrowser() throws IOException
    {
        fis=new FileInputStream(src);
        prop.load(fis);
        return prop.getProperty("browser");
    }

    public static String getsignupemail()
    {
        try {
            fis=new FileInputStream(src);
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.getMessage();
        }
        return prop.getProperty("email");
    }

    public static String getpassword(){
        try {
            fis=new FileInputStream(src);
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.getMessage();
        }
        return prop.getProperty("password");
    }

}
