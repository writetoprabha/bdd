package com.seleniumcucumber.steps;

import com.seleniumcucumber.webdriver.WebConnector;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;


import java.util.Properties;

public class GenericSteps {

    WebConnector connector;

    public GenericSteps(WebConnector connector){
        this.connector = connector;
    }

    @After
    public void afterFunction(){
        System.out.println("***********************************After Scenario****************************");
        if(connector.driver != null) {
            connector.driver.quit();
            connector.driver = null;
        }
    }

    @And("I navigate to ([^\"]*)$")
    public void navigateTo(String siteName){
        connector.navigate(siteName);
    }

    @And("^I click on ([^\"]*)$")
    public void clickOnElement(String elementReference){
        connector.click(elementReference);
    }

    @And("^I enter ([^\"]*) in ([^\"]*) text field$")
    public void enterTextInTextField(String textValue, String elementReference){
        connector.enterText(elementReference, textValue);
    }

    @And("^I wait for (\\d+) milliseconds$")
    public void wait(int milliSeconds) throws InterruptedException {
        Thread.sleep(milliSeconds);
    }

}
