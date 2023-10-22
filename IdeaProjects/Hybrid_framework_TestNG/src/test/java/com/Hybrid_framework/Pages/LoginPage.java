package com.Hybrid_framework.Pages;

import java.util.Iterator;
import java.util.List;

import com.Hybrid_framework.Utilities.PreConfigUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/Configuration/log4j.properties");
    }

    @FindBy(id = "searchboxinput") public WebElement searchbox;
    @FindAll({ @FindBy(xpath="//div[@id='suggestions-grid']/div//span")})public List<WebElement>suggestedElements;
    public final Logger logger=Logger.getLogger(this.getClass());
    
    public void fillsearchText(String searchterm){
        searchbox.clear();
    	searchbox.sendKeys(searchterm);
    	logger.info("The search text "+searchterm+" has been entered");
    }
    
    public void clearsearchField() {
    	searchbox.clear();
    	logger.info("The search text has been cleared");
    }
    
    public void selectKeyword(String address) {
    	Iterator<WebElement>itr=suggestedElements.iterator();
    	while(itr.hasNext())
		{
			WebElement ele=itr.next();
			if(ele.getText().equalsIgnoreCase(address))
			{
                PreConfigUtils.expectedWait(driver,30,ele,"clickable");
				ele.click();
				break;
			}
		}
    }
}

    
