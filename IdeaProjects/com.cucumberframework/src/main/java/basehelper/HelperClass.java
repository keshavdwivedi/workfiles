package basehelper;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class HelperClass  {
	
	private Baseutil obj;
	public static Logger logger;
	public HelperClass(Baseutil obj) {
		this.obj=obj;
		logger= LogManager.getLogger(getClass().getName());
	}

	public static String generateString(){
		return (RandomStringUtils.randomAlphanumeric(8));
	}

	public String takeScreenShotReturnPath() throws IOException{
		String screenShotFolder=System.getProperty("user.dir")+"/target/Screenshots/";
		Date date= new Date();
		Long time=date.getTime();
		File scrFile = ((TakesScreenshot) obj.driver).getScreenshotAs(OutputType.FILE);
		String imagePath=screenShotFolder  + time+".png";
		FileUtils.copyFile(scrFile, new File(imagePath));
		logger.info("Screenshot taken and stored on file path"+imagePath);
		return imagePath;
	}

	public void embedScreenShot(Scenario scenario){
		final byte[] screenshot =  ((TakesScreenshot) obj.driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png",scenario.getName());
		logger.info("Screenshot attached in the report");

	}
	
	@Before(order=0)
	public void driverInstanceSetup() throws IOException
	{
		
		if(obj.getdriver()==null)
		{
			    logger.info("New browser instance launched");
				if(ReadpropertiesFile.getBrowser().equalsIgnoreCase("safari"))
				{
					obj.driver=new SafariDriver();
					logger.info("Safari driver launched successfully");
				}

				else if(ReadpropertiesFile.getBrowser().equalsIgnoreCase("firefox")){
					WebDriverManager.firefoxdriver().setup();
					obj.driver=new FirefoxDriver();
					logger.info("Firefox driver instance created successfully");
				}
				
				else if(ReadpropertiesFile.getBrowser().equalsIgnoreCase("Chrome"))
				{
					WebDriverManager.chromedriver().setup();
					ChromeOptions options=new ChromeOptions();
					options.addArguments("--disable-notifications");
					options.addArguments("--start-maximized");
					options.addArguments("--no-proxy-server");
					obj.driver=new ChromeDriver(options);
					logger.info("Chrome driver instance created successfully");
				}
			    obj.driver.manage().window().maximize();
				obj.driver.get(ReadpropertiesFile.getURL());
				obj.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	}

	@After(order = 1)
	public void checkFailScenario(Scenario scenario){

		if(scenario.isFailed()){
			try {
				scenario.log("Scenario "+scenario.getName() +" has been failed");
				takeScreenShotReturnPath();
				embedScreenShot(scenario);
			} catch (Exception e){
				e.printStackTrace();
			}
		}

		else {
			try {
				scenario.log("Scenario "+scenario.getName()+ "has been passed");
				takeScreenShotReturnPath();
				embedScreenShot(scenario);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	 }

	@After(order=0)
	public void tearDownDriverInstance()
	{
		if(obj.driver!=null)
		{
			logger.info("Closing driver instance");
			obj.driver.close();
			//obj.driver.quit();
		}
	}
	
	
}
