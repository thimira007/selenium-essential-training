package com.linkedin.learning.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class RestaurantSystemHooks {

    @Before
    public void BeforeDisplay(Scenario sc){
        System.out.println("Before: Before Display: "+sc.getName());
    }

    @After
    public void AfterDisplay(Scenario sc){
        System.out.println("After: After Display: "+sc.getName());
    }
}
