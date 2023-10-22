package com.Guru99telecom.stepDefs;

import com.Guru99telecom.pageFactory.AddCustomerpage_PO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Guru99_AddCustomerStepdefs {

    AddCustomerpage_PO addcustomerPo=new AddCustomerpage_PO();

    @When("User validates page heading {string} on Add customer page")
    public void user_validates_page_heading_on_add_customer_page(String addCustomerHeading) {
       addcustomerPo.validateAddCustomerHeading(addCustomerHeading);
    }

    @When("Clicks on Submit button")
    public void clicks_on_submit_button() {
        addcustomerPo.clickSubmitButton();
    }

    @Then("validates alert message {string} on the page")
    public void validates_alert_message_on_the_page(String alertMessage) {
        addcustomerPo.addCustomerValidateAlert(alertMessage);
    }

    @And("^User selects (.*) background check$")
    public void user_selects_backgroundtype_background_check(String backgroundType) {
        addcustomerPo.setAddCustomerBackgroundType(backgroundType);
    }

    @And("^User enters (.*) in First name field$")
    public void user_enters_firstname_in_first_name_field(String firstNameValue) {
        addcustomerPo.fillFirstNameField(firstNameValue);
    }

    @And("^User enters (.*) in message field$")
    public void user_enters_message_in_message_field(String message) {
      addcustomerPo.enterMessageField(message);
    }

    @And("^User enters (.*) in mobile number field$")
    public void user_enters_mobileno_in_mobile_number_field(String mobilenumber) {

        addcustomerPo.enterMobileField(mobilenumber);
    }



    @When("^User enters (.*) in Last name field$")
    public void user_enters_lastname_in_last_name_field(String lastNameValue) {

        addcustomerPo.fillLastNameField(lastNameValue);

    }

    @And("User clears data in name fields")
    public void user_clears_data_in_name_fields() {

        addcustomerPo.clearNameFields();

    }

    @Then("User should be able to view {string} validation message")
    public void user_should_be_able_to_view_validation_message(String validationMessage) {
        addcustomerPo.checkValidationMessages(validationMessage);
    }

    @And("^User enters (.*) in email field$")
    public void user_enters_emailvalue_in_email_field(String emailValue) {

        addcustomerPo.fillEmailField(emailValue);
    }

    @And("User clears data in email field")
    public void user_clears_data_in_email_field() {

        addcustomerPo.clearEmailField();

    }

}
