package com.framework.stepDef;

import com.framework.pageFactory.ProductList_PF;
import io.cucumber.java.en.Then;

public class ProductList_stepDef {

    ProductList_PF productlist=new ProductList_PF();

    @Then("user should be displayed validation message {string}")
    public void user_should_be_displayed_validation_message(String message) {
        productlist.validateMessage(message);
    }

    @Then("user should be displayed appropriate product listing")
    public void user_should_be_displayed_appropriate_product_listing() {
        productlist.validateProductlist();
        productlist.getProductname();
    }


}
