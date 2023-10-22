package com.framework.stepDef;

import com.framework.pageFactory.HomePage_PF;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Home_stepDef {

    HomePage_PF homePage=new HomePage_PF();
    String homepageTitle="My Store";

    @When("user clicks on contact us link")
    public void user_clicks_on_contact_us_link() {
     homePage.clickContactusLink();
    }

    @Given("user should be on home page")
    public void user_should_be_on_home_page() {
        homePage.validateHomePageTitle(homepageTitle);
        homePage.validateBanner();
    }

    @Given("search textfield should be visible")
    public void search_textfield_should_be_visible() {
        homePage.validateSearchfield();
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        homePage.clickSearchIcon();
    }

    @When("^user enters (.*) in search field$")
    public void user_enters_productname_in_search_field(String productname) {

        homePage.enterSearchTxt(productname);
    }

}
