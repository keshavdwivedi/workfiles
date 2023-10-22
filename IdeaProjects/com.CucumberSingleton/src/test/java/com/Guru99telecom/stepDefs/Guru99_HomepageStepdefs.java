package com.Guru99telecom.stepDefs;

import com.Guru99telecom.pageFactory.Homepage_PO;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;


public class Guru99_HomepageStepdefs {

    Homepage_PO homeobj = new Homepage_PO();

    @When("User navigates to homepage of website")
    public void user_navigates_to_homepage_of_website() {
     homeobj.validateHomePageLogo();
    }

    @When("User validates the homepage main heading {string}")
    public void user_validates_the_homepage_main_heading(String HomepageHeading) {

        homeobj.validateHomePageHeading(HomepageHeading);
    }

    @Then("User verifies the count of homepage links")
    public void user_verifies_the_count_of_homepage_links() {
        homeobj.verifyHomepageLinksCount(4);
    }

    @Then("User validates all links text on homepage")
    public void user_validates_all_links_text_on_homepage(List<String> linkTextList) {

        //List<Map<String,String>>linkData=table.asMaps(String.class,String.class);
        for (String ElementTxt : linkTextList) {
            homeobj.validateHomePageLinks(ElementTxt);
        }
    }

    @When("^User clicks on (.*) link$")
    public void user_clicks_on_homepagelinkText_link(String linktext) {

        if (linktext.equalsIgnoreCase("Add Customer")){
            homeobj.clickAddCustomerLink();
        }
        else if (linktext.equalsIgnoreCase("Add Tariff Plan")){
            homeobj.clickAddTariffPlanLink();
        }
        else if (linktext.equalsIgnoreCase("Add Tariff Plan to Customer")){
            homeobj.clickAddTariffPlanCustomerLink();
        }
        else
            homeobj.clickPayBillLink();
    }

    @When("^User validates (.*) for the navigated page$")
    public void user_validates_pageTitle_for_the_navigated_page(String pageTitle) {
        homeobj.validateNavigatedPageTitle(pageTitle);
    }

    @Then("User navigates back to homepage of website")
    public void user_navigates_back_to_homepage_of_website() {
        homeobj.navigatebacktoHomePage();
    }


}

