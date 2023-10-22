package PageObjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import java.util.ArrayList;

public class DashboardPage extends PageObject {

    @FindBy(xpath = "//*[@class='greencolor']")public WebElementFacade indiaVaccineLink;
    @FindBy(xpath = "//*[@id='state']")public WebElementFacade stateDrp;
    @FindBy(xpath = "//*[@id='district']")public WebElementFacade districtDrp;

    public void selectState(String state){
        stateDrp.selectByVisibleText(state);
    }

    public void selectDistrict(String district){
        districtDrp.selectByVisibleText(district);
    }

    public void getVaccineText(String expectedText){
        String actualText=indiaVaccineLink.getText();
        System.out.println(actualText);
        Assert.assertTrue(actualText.contains(expectedText));
        closeBrowser();
    }

    public void closeBrowser(){
        ArrayList<String>arr=new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(arr.get(1));
        getDriver().close();
    }

}
