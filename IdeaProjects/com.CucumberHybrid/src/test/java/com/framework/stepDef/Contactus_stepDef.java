package com.framework.stepDef;

import com.framework.pageFactory.ContactusPage_PF;
import io.cucumber.java.en.Then;

public class Contactus_stepDef {

    ContactusPage_PF contactPage=new ContactusPage_PF();
    String contactusTitle="Contact us - My Store";

    @Then("user is navigated to contact us page")
    public void user_is_navigated_to_contact_us_page() {
        contactPage.validateContactusPageHeading(contactusTitle);
        contactPage.checkcontactusheading();
    }

    @Then("user clicks on Send button")
    public void user_clicks_on_send_button() {
       contactPage.clicksendButton();
    }

    @Then("^user is shown validation message (.*)$")
    public void user_is_shown_validation_message_validationMessage(String validationmessage) {
        contactPage.checkvalidationMessage(validationmessage);
    }

    @Then("^user selects (.*) from subject heading dropdown$")
    public void user_selects_subject_from_subject_heading_dropdown(String subjectVal) {
        contactPage.selectSubject(subjectVal);
    }

    @Then("^user enters (.*) in email field$")
    public void user_enters_email_in_email_field(String emailVal) {
        contactPage.enterEmailAddress(emailVal);
    }

    @Then("^user enters random message in message field$")
    public void user_enters_message_in_message_field() {
       contactPage.enterMessagetxt();
    }


}
