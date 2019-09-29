package com.seleniumcucumber;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.SoftAssertions;



import java.util.List;
import java.util.Map;

public class StepDefinitions {
    SoftAssertions softAssert;


    @Before
    public void beforeFunction(){
        System.out.println("***********************************Before Scenario****************************");
        softAssert = new SoftAssertions();
    }

    @After
    public void afterFunction(){
        System.out.println("***********************************After Scenario****************************");
        softAssert.assertAll();
    }


    @And("^I navigate to ([^\"]*) page$")
    public void i_navigate_to(String pageName){
        System.out.println("I navigate to " +pageName+ " page");
    }
//  [^\"]*  => represents any characters including numbers, alphabets, space  and special characters

    @And("^I verify that ([^\"]*) link exists$")
    public void i_verify_that_link_exists(String linkName){
        System.out.println("I verify that " + linkName + " link exists");
    }

//    @And("^I verify that chapter2 link exists$")
//    public void i_verify_that_chapter2(){
//        System.out.println("I verify that chapter2 link exists");
//    }
//
//    @And("^I verify that chapter3 link exists$")
//    public void i_verify_that_chapter3(){
//        System.out.println("I verify that chapter3 link exists");
//    }
//
//    @And("^I verify that chapter4 link exists$")
//    public void i_verify_that_chapter4(){
//        System.out.println("I verify that chapter4 link exists");
//    }
//
//    @And("^I verify that chapter8 link exists$")
//    public void i_verify_that_chapter8(){
//        System.out.println("I verify that chapter8 link exists");
//    }

    @And("^I add (\\d+) adults")
    public void i_add_adults(int adultCount) {
        System.out.println("I add " +adultCount+ "adults");
    }

    @And("^I verify that ([^\"]*) dropdown has options$")
    public void i_verify_dropdown_options(String dropdownName, List<String> dropdownValues){
        System.out.println("I verify that " + dropdownName + "dropdown has values " + dropdownValues.toString());
    }

    @And("^I have (\\d+) adults$")
    public void i_have_adults(int adultCount, List<Map<String, String>> names){
        System.out.println("I have " +adultCount+ "adults " + names.toString());
        softAssert.assertThat("A").isEqualTo("A");
    }

}
