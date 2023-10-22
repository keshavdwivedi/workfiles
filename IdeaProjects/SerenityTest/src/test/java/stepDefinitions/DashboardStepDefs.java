package stepDefinitions;

import Steps.DashboardSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DashboardStepDefs {

    @Steps
    DashboardSteps dashboardSteps;

    @Then("^user validates todays count of vaccination should be \"([^\"]*)\"$")
    public void user_validates_todays_count_of_vaccination_should_be(String vaccineCount) {
        dashboardSteps.getVaccineCount(vaccineCount);
    }

    @When("^user selects state \"([^\"]*)\" from state dropdown$")
    public void user_selects_state_from_state_dropdown(String state) {
     dashboardSteps.selectStateVal(state);
    }


    @When("^user selects district \"([^\"]*)\" from district dropdown$")
    public void user_selects_district_from_district_dropdown(String district) {
     dashboardSteps.selectDistrictVal(district);
    }


}
