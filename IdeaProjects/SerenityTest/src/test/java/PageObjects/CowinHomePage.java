package PageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.ArrayList;

public class CowinHomePage extends PageObject {

    @FindBy(xpath = "//a[@title='Dashboard']")public WebElementFacade dashboardLink;

    public void clickDashboardLink(){
        dashboardLink.click();
    }

    public void switchWindow(){
        ArrayList<String>arr=new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(arr.get(1));

    }

}
