package Steps;

import PageObjects.CowinHomePage;
import net.thucydides.core.annotations.Step;

public class CowinHomeSteps {

    CowinHomePage homePage;

    @Step
    public void navigateHomePage(){
        homePage.open();
    }

    @Step
    public void selectDashboard(){
        homePage.clickDashboardLink();
    }

    @Step
    public void switchTab(){
        homePage.switchWindow();
    }
}
