package com.framework.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import com.framework.Pageobjects.SignupPageobjects;
import basehelper.Baseutil;

public class SignupSteps {

    private SignupPageobjects p;
    private Baseutil obj;

    public SignupSteps(SignupPageobjects p, Baseutil obj) {
        this.p = p;
        this.obj = obj;
    }


    @Given("^I click on signin link$")
    public void i_click_on_signin_link() {
        p.clickSigninLink();
    }

    @When("^Signup field is displayed$")
    public void signup_field_is_displayed() {
        p.checksignupfield();
    }

    @Then("^I check for Title$")
    public void i_check_for_Title(String arg) {

        System.out.println("The Title asserting is:" + arg);
        Assert.assertTrue(obj.getdriver().getTitle().contains(arg), "The title is not present wrong page reached");
    }

    @Then("^I click on Signup button$")
    public void i_click_on_Signup_button() {
        p.clickSignupButton();
    }

    @Then("^I Enter Invalid email$")
    public void i_Enter_Invalid_email() {
        p.enterInvalidEmail();
    }

    @Then("^I Enter valid email$")
    public void i_Enter_valid_email() {
        p.enterValidEmail();
    }
}
