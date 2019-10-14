package com.seleniumcucumber.steps;

import com.seleniumcucumber.webdriver.WebConnector;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;
import java.util.Properties;

public class GenericSteps {

    WebConnector connector;

    //Uses Pico container. For every scenario, the pico container object gets created and the created object is assigned to connector object.
    public GenericSteps(WebConnector connector){
        this.connector = connector;
    }

    //To  close the browser after every scenario is complete.
    @After
    public void afterFunction(){
        System.out.println("***********************************After Scenario****************************");
        if(connector.driver != null) {
            connector.infoLog("Closing the browser");
            connector.driver.quit();
            connector.driver = null;
            connector.flushLogs();
        }
    }

    @Before
    public void beforeFunction(Scenario scenario){
        System.out.println("***********************************Before Scenario****************************");
        connector.initializeReports(scenario.getName());
    }


    @And("I navigate to ([^\"]*)$")
    public void navigateTo(String siteName){
        connector.navigate(siteName);
        connector.reportSuccess("Successfully navigated to " + siteName);
    }

    @And("^I click on ([^\"]*)$")
    public void clickOnElement(String elementReference){
        connector.click(elementReference);
        connector.reportSuccess("Clicked on " + elementReference);
    }

    @And("^I enter ([^\"]*) in ([^\"]*) text field$")
    public void enterTextInTextField(String textValue, String elementReference){
        connector.enterText(elementReference, textValue);
        connector.reportSuccess("Entered " + textValue + "in " + elementReference);
    }

    @And("^I wait for (\\d+) milliseconds$")
    public void wait(int milliSeconds) throws InterruptedException {
        Thread.sleep(milliSeconds);
        connector.reportSuccess("Waited for " + milliSeconds + " milli seconds");
    }

    @And("^I verify that page contains text$")
    public void verifyPageContainstext(List<String> linesOfText) {
        for(String lineOfText: linesOfText){
            String xPath = "//*[contains(text(),'" + lineOfText + "')]";
            WebElement e = connector.getElementByXPath(xPath);
            if(e != null) {
                connector.reportSuccess("Text -" + lineOfText + " -found on page");
            } else {
                connector.reportFailure("Text -" +lineOfText+ " -not found");
            }
        }
    }

}
