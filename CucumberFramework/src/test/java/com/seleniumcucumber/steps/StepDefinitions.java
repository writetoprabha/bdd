package com.seleniumcucumber.steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.List;
import java.util.Map;

public class StepDefinitions {
    SoftAssertions softAssert;


    @Before
    public void beforeFunction(){
        System.out.println("***********************************Before Scenario****************************");
        softAssert = new SoftAssertions();
    }




    @And("^I navigate afd to ([^\"]*) page$")
    public void iNavigateTo(String pageName){
        System.out.println("I navigate to " +pageName+ " page");
    }
//  [^\"]*  => represents any characters including numbers, alphabets, space  and special characters

    @And("^I verify that ([^\"]*) link exists$")
    public void verifyThatLinkExists(String linkName){
        System.out.println("I verify that " + linkName + " link exists");
    }

    @And("^I add (\\d+) adults")
    public void addAdults(int adultCount) {
        System.out.println("I add " +adultCount+ "adults");
    }

    @And("^I verify that ([^\"]*) dropdown has options$")
    public void verifyDropDownOptions(String dropdownName, List<String> dropdownValues){
        System.out.println("I verify that " + dropdownName + "dropdown has values " + dropdownValues.toString());
    }

    @And("^I have (\\d+) adults$")
    public void haveAdults(int adultCount, List<Map<String, String>> names){
        System.out.println("I have " +adultCount+ "adults " + names.toString());
        softAssert.assertThat("A").isEqualTo("A");
    }

    @Given("^I open ([^\"]*)$")
    public void openBrowser(String browserName){
        System.out.println("I open "+browserName+ " browser");
    }

}
