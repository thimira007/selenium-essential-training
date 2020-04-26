package com.linkedin.learning.stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;

public class FinalBillCalculation {
    Integer billAmount;
    Double taxRate;


    public FinalBillCalculation() {
    }

    @Given("I have a Customer")
    public void i_have_a_Customer() {
        System.out.println("Customer found");
    }

    @Given("user enters initial bill amount as {int}")
    public void user_enters_initial_bill_amount_as(Integer billAmount) {
        this.billAmount = billAmount;
        System.out.println("Initial Bill Amount: " + this.billAmount);
    }

    @Given("Sales Tax Rate is {double} Percent")
    public void sales_Tax_Rate_is_Percent(Double taxRate) {
        this.taxRate = taxRate;
        System.out.println("Tax Rate: " + this.taxRate);
    }

    @Then("Final bill amount calculate is {double}")
    public void final_bill_amount_calculate_is(Double finalAmount) {
        Double actualValue = this.billAmount + (this.billAmount*this.taxRate/100);
        Assert.assertEquals(actualValue,finalAmount, "Expected and actual values not matched");
        System.out.println("Verify final bill amount");
    }
}
