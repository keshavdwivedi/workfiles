package Steps;

import PageObjects.DashboardPage;
import net.thucydides.core.annotations.Step;

public class DashboardSteps {

    DashboardPage dashboardPage;

    @Step
    public void getVaccineCount(String count){
        dashboardPage.getVaccineText(count);
    }

    @Step
    public void selectStateVal(String stateVal){
        dashboardPage.selectState(stateVal);
    }

    @Step
    public void selectDistrictVal(String districtVal){
        dashboardPage.selectDistrict(districtVal);
    }


}
