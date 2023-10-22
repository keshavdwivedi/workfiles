package com.framework.stepDef;

import com.framework.pageFactory.ContactusSuccessPage_PF;
import io.cucumber.java.en.Then;

public class ContactusSucessPage_stepDef {
    ContactusSuccessPage_PF contactsuccess=new ContactusSuccessPage_PF();

    @Then("^user is shown success message (.*)$")
    public void user_is_shown_success_message_successMessage(String successMessage) {
        contactsuccess.validateSuccessmessage(successMessage);
    }
 }

