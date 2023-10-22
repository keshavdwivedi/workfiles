package stepDefinitions;

import Steps.CowinHomeSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class HomepageStepDefs {

    @Steps
    CowinHomeSteps homeSteps;

    @Given("^user navigate to cowin website$")
    public void user_navigate_to_cowin_website() {
       homeSteps.navigateHomePage();
    }


    @When("^user clicks on cowin dashboard link$")
    public void user_clicks_on_cowin_dashboard_link() {
        homeSteps.selectDashboard();
    }

    @When("^user switches to dashboard tab$")
    public void user_switches_to_dashboard_tab() {
        homeSteps.switchTab();
    }
}
