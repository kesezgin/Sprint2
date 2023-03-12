package com.fidexio.step_definitions;

import com.fidexio.utils.Driver;
import io.cucumber.java.After;


public class Hooks {

    @After
    public void teardown(){

        Driver.closeDriver();

    }

}
